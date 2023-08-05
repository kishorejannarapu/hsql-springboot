package com.example.service;

import java.util.List;

import com.example.entities.Customer;
import com.example.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public Customer findByCustomerId(long customerId) {
		return customerDao.findByCustomerId(customerId);
	}

	public List<Customer> findAllCustomers() {
		return customerDao.findAllCustomers();
	}

	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	public void deleteCustomer(long customerId) {
		customerDao.deleteCustomer(customerId);
	}

}