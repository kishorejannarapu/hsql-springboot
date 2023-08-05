package com.example;

import com.example.entities.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * Hello world!
 */
@SpringBootApplication
public class HqlTestApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;


    public static void main(String[] args) {
        SpringApplication.run(HqlTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("List all Customers");

        List<Customer> customers = customerService.findAllCustomers();
        customers.forEach(System.out::println);

        System.out.println("Customer information with Customer Id = 2");
        Customer findCustomer = customerRepository.findById(2L).orElse(null);
        System.out.println(findCustomer);

        System.out.println();


        System.out.println();
        System.out.println("Add new Customer");

        Customer customer = new Customer();
        customer.setCustomerName("Soumitra Roy");
        customer.setCustomerAddress("Tiruvanmiyur");
        customer.setCustomerCity("Chennai");
        customer.setCustomerState("Tamil Nadu");
        customer.setCustomerZip("600020");
        customerRepository.save(customer);

        System.out.println();
        System.out.println("New customer information");
        Customer cust = customerRepository.findById(6L).orElse(null);
        System.out.println(cust);

        System.out.println("After creating a new Customer, list all Customers");
        List<Customer> customersAfterAddition = customerRepository.findAll();
        customersAfterAddition.stream().forEach(c -> System.out.println(c));

        System.out.println("Update customer information for Customer Id = 6");
        Customer customerUpdate = customerRepository.findById(6L).orElse(new Customer());
        customerUpdate.setCustomerAddress("Chingrihata");
        customerUpdate.setCustomerCity("Kolkata");
        customerUpdate.setCustomerState("West Bengal");
        customerUpdate.setCustomerZip("700105");
        customerRepository.save(customerUpdate);

        System.out.println();
        System.out.println("After updating customer information for Customer Id = 6");
        Customer custUpdate = customerRepository.findById(6L).orElse(new Customer());
        System.out.println(custUpdate);

        System.out.println();
        System.out.println("Delete customer information for Customer Id = 6");
        Customer customer1 = new Customer();
        customer1.setCustomerId(6L);
        customerRepository.delete(customer1);

        System.out.println();
        System.out.println("After deleting a Customer for Customer Id = 6, list all Customers");
        List<Customer> customersAfterDeletion = customerRepository.findAll();
        customersAfterDeletion.stream().forEach(c -> System.out.println(c));
    }

}
