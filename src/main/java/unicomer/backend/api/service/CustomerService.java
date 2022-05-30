package unicomer.backend.api.service;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import unicomer.backend.api.common.Constants;
import unicomer.backend.api.data.CustomerDTO;
import unicomer.backend.api.entity.CustomerEntity;
import unicomer.backend.api.interfaces.ICustomer;
import unicomer.backend.api.repository.ICustomerRepository;

/**
 * @author Kevin Candia
 * 28-05-2022
 */
@Log4j2
@Service
public class CustomerService implements ICustomer{

    @Autowired
    private ICustomerRepository iCustomer;

    @Override
    public CustomerDTO findById(Long customer) {
        log.info("STARTING - findById");
        return fillCustomerDTO(iCustomer.findByIdCustomer(customer));
    }

    @Override
    public Page<CustomerDTO> findAll(Pageable customerPage) {
        log.info("STARTING - findAll");
        return fillCustomerDTOPage(iCustomer.findAll(customerPage));
    }

    @Override
    public void save(CustomerDTO customerDTO) {
        log.info("*START - save Label*");
		iCustomer.save(fillCustomerEntity(customerDTO));
		log.info("*FINISHED - save Label*");
    }

    @Override
    public String updateName(Long idCustomer, String firstName, String lastName) {
        var customer = iCustomer.findByIdCustomer(idCustomer);

        if (customer == null) {
            return Constants.NOT_FOUND;
        }

        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        iCustomer.save(customer);
        return Constants.SUCCESS_SAVE;
    }

    @Override
    public String deleteById(Long customer) {
        log.info("*START - delete customer*");

        if (!iCustomer.existsById(customer)) {
            return Constants.NOT_FOUND;
        }

		iCustomer.deleteById(customer);
		log.info("*FINISHED - delete customer*");
        return Constants.SUCCESS_DELETE;
    }

    private Page<CustomerDTO> fillCustomerDTOPage(Page<CustomerEntity> customerPage) {
        log.info("STARTING - fillCustomerDTO");
        if (customerPage == null || customerPage.getNumberOfElements() == 0) {
            return null;
        }
        var listCustomerDTO = new ArrayList<CustomerDTO>();
        customerPage.forEach(customer -> {
            listCustomerDTO.add(fillCustomerDTO(customer));
        });
        log.info("FINISHING - fillCustomerDTO");
        return new PageImpl<CustomerDTO>(listCustomerDTO);
    }

    private CustomerEntity fillCustomerEntity(CustomerDTO customerDTO) {
		if (customerDTO == null) {
			return null;
		}

        var customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customerDTO, customerEntity);
        return customerEntity;
	}

    private CustomerDTO fillCustomerDTO(CustomerEntity customerEntity) {
		if (customerEntity == null) {
			return null;
		}

        var customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customerEntity, customerDTO);
        return customerDTO;
	}

}