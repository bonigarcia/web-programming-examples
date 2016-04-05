package io.github.web.data.mongodb;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {

    List<Customer> findByLastName(String lastName);

    List<Customer> findByFirstName(String firstName);

}
