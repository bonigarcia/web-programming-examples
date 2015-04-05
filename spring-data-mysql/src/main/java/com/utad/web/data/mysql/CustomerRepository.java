package com.utad.web.data.mysql;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);

	List<Customer> findByFirstName(String firstName);

	@Query(value = "SELECT * FROM CUSTOMER", nativeQuery = true)
	List<Customer> selectAll();

}
