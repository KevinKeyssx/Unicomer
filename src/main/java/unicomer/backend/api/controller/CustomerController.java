package unicomer.backend.api.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;
import unicomer.backend.api.common.Constants;
import unicomer.backend.api.common.Util;
import unicomer.backend.api.data.CustomerDTO;
import unicomer.backend.api.data.ResponseDTO;
import unicomer.backend.api.interfaces.ICustomer;

import java.text.ParseException;

/**
 * @author Kevin Candia
 * 28-05-2022
 */
@CrossOrigin
@Log4j2
@RestController
public class CustomerController {

	@Autowired
	private ICustomer iCustomer;

	@GetMapping(path = Constants.SEARCH_ALL, produces = "application/json")
	public ResponseEntity<Page<CustomerDTO>> findPageCustomer(
		@RequestParam(defaultValue = Constants.DEFAULT_PAGE, name = "Page number") 	int page,
		@RequestParam(defaultValue = Constants.DEFAULT_SIZE, name = "Page size") 	int size,
		@RequestParam(defaultValue = Constants.DEFAULT_ORDER, name = "Page order") 	String order,
		@RequestParam(defaultValue = Constants.DEFAULT_ASC, name = "Page upward") 	boolean asc
	) throws ParseException {
		log.info("*START - Controller findPageCustomer*");
		var sort = asc ? Sort.by(order) : Sort.by(order).descending();
		var customersDTO = iCustomer.findAll(PageRequest.of(page, size, sort));
		log.info("*FINISHED - Controller findPageCustomer*");
		return new ResponseEntity<>(
			customersDTO,
			new Util(true).typeStatus(customersDTO)
		);
	}

    @GetMapping(path = Constants.SEARCH_BY_ID, produces = "application/json")
	public ResponseEntity<CustomerDTO> findById(@RequestParam(value = "customer", required = true) Long customer) {
		log.info("*START - Controller getCustomer*");
		var customerDTO = iCustomer.findById(customer);
		log.info("*FINISHED - Controller getCustomer*");
		return new ResponseEntity<>(
			customerDTO,
			new Util(true).typeStatus(customerDTO)
		);
	}

	@PostMapping(path =	Constants.SAVE, consumes = "application/json", produces = "application/json")
	public ResponseEntity<ResponseDTO> save(@Valid @RequestBody CustomerDTO customerDTO) {
		log.info("*START - Controller customer save*");
		iCustomer.save(customerDTO);
		log.info("*FINISHED - Controller customer save*");
		return new ResponseEntity<ResponseDTO>(
			new ResponseDTO(
				Constants.SUCCESS_SAVE,
				new Date()
			),
			HttpStatus.CREATED
		);
	}

	@PatchMapping(path = Constants.UPDATE_NAME, produces = "application/json")
	public ResponseEntity<ResponseDTO> updateName(
		@RequestParam(value = "idCustomer", required = true) Long idCustomer,
		@RequestParam(value = "fistName", 	required = true) String firstName,
		@RequestParam(value = "lastName", 	required = true) String lastName
	) {
		log.info("*START - Controller updateName*");
		return new ResponseEntity<ResponseDTO>(
			new ResponseDTO(
				iCustomer.updateName(idCustomer, firstName, lastName),
				new Date()
			),
			HttpStatus.OK
		);
	}

	@DeleteMapping(path = Constants.DELETE, produces = "application/json")
	public ResponseEntity<ResponseDTO> deleteById(@RequestParam(value = "customer", required = true) Long customer) {
		log.info("*START - Controller deleteById*");
		return new ResponseEntity<>(
			new ResponseDTO(
				iCustomer.deleteById(customer),
				new Date()
			),
			HttpStatus.OK
		);
	}

}