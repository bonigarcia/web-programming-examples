package io.github.web.data.mysql;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private CustomerRepository repository;

    public DatabaseLoader(CustomerRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    private void initDatabase() {
        // Create
        repository.save(new Customer("John", "Doe"));
        repository.save(new Customer("Michael", "Smith"));

        // Update
        Customer firstCustomer = repository.findAll().iterator().next();
        firstCustomer.setFirstName("Peter");
        log.info("Updating {}", firstCustomer);
        repository.save(firstCustomer);

        // Read
        Iterable<Customer> all = repository.findAll();
        for (Customer customer : all) {
            log.info("Reading {}", customer);
        }

        // Delete
        long firstId = repository.findAll().iterator().next().getId();
        repository.deleteById(firstId);
        log.info("Number of costumer(s) after deleting: {}",
                repository.count());
    }
}
