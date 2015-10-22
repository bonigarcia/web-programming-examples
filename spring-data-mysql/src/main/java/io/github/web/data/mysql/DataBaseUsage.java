package io.github.web.data.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DataBaseUsage implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	@Override
	public void run(String... args) throws Exception {
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
