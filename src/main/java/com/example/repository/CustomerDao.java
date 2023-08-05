package com.example.repository;

import java.util.List;

import com.example.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SQL_NEW_CUSTOMER = "INSERT INTO CUSTOMER(CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_CITY, CUSTOMER_STATE, CUSTOMER_ZIP_POSTAL) VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE_CUSTOMER = "UPDATE CUSTOMER SET CUSTOMER_NAME = ?, CUSTOMER_ADDRESS = ?, CUSTOMER_CITY = ?, CUSTOMER_STATE = ?, CUSTOMER_ZIP_POSTAL = ? WHERE CUSTOMER_ID = ?";
    private static final String SQL_DELETE_CUSTOMER = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID = ?";
    private static final String SQL_FIND_ALL_CUSTOMERS = "SELECT * FROM CUSTOMER";
    private static final String SQL_FIND_BY_CUSTOMER_ID = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";

    public Customer findByCustomerId(long customerId) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_CUSTOMER_ID, new CustomerRowMapper(),
                customerId);
    }

    public List<Customer> findAllCustomers() {
       return jdbcTemplate.query(SQL_FIND_ALL_CUSTOMERS, new CustomerRowMapper());
    }

    public void saveCustomer(Customer customer) {
        jdbcTemplate.update(SQL_NEW_CUSTOMER, customer.getCustomerName(), customer.getCustomerAddress(),
                customer.getCustomerCity(), customer.getCustomerState(), customer.getCustomerZip());
    }

    public void updateCustomer(Customer customer) {
        jdbcTemplate.update(SQL_UPDATE_CUSTOMER,
                customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerCity(),
                customer.getCustomerState(), customer.getCustomerZip(), customer.getCustomerId());
    }

    public void deleteCustomer(long customerId) {
        jdbcTemplate.update(SQL_DELETE_CUSTOMER, customerId);
    }

}
