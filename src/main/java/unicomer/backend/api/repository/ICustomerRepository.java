package unicomer.backend.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import unicomer.backend.api.entity.CustomerEntity;

/**
 * @author Kevin Candia
 * 28-05-2022
 */
@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {

    public Page<CustomerEntity> findAll(@Param("customerPage") Pageable customerPage);

    public CustomerEntity findByIdCustomer(@Param("customer") Long customer);

}