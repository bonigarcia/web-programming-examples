package io.github.web.data.h2;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader {

	@Autowired
	private CustomerRepository repository;

	@PostConstruct
	private void initDatabase() {
		// Create
		repository.save(new Customer("John", "Doe"));
		repository.save(new Customer("Michael", "Smith"));

		// Update
		Customer firstCustomet = repository.findAll().iterator().next();
		System.out.println(firstCustomet);
		firstCustomet.setFirstName("Peter");
		repository.save(firstCustomet);

		// Read
		Iterable<Customer> all = repository.findAll();
		for (Customer customer : all) {
			System.out.println(customer);
		}

		// Delete
		long firstId = repository.findAll().iterator().next().getId();
		repository.delete(firstId);
		System.out.println(repository.count());
	}
}
