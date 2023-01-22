package org.id.customerservice;

import org.id.customerservice.dao.CustomerRepository;
import org.id.customerservice.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class CustomerServiceApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	ArrayList<Customer> customers = new ArrayList<Customer>();

	void addCustomer(){
		customers.add(new Customer(null,"varus","varus@gmail.com"));
		customers.add(new Customer(null,"borel","borel@gmail.com"));
		customers.add(new Customer(null,"toutou","toutou@gmail.com"));

		customers.stream().forEach(customer -> customerRepository.save(customer));
	}


	@Override
	public void run(String... args) throws Exception {
		addCustomer();
	}
}
