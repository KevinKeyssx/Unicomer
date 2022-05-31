package unicomer.backend.api.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import unicomer.backend.api.data.CustomerDTO;

/**
 * @author Kevin Candia
 * 28-05-2022
 */
public interface ICustomer {

    public CustomerDTO findById(Long customer);

    public Page<CustomerDTO> findAll(Pageable customerPage);

    public void save(CustomerDTO customerDTO);

    public String updateName(Long idCustomer, String firstName, String lastName);

	public String deleteById(Long customer);

}