package com.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.entities.Customer;
import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();

		customer.setCustomerId(rs.getLong("CUSTOMER_ID"));
		customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
		customer.setCustomerAddress(rs.getString("CUSTOMER_ADDRESS"));
		customer.setCustomerCity(rs.getString("CUSTOMER_CITY"));
		customer.setCustomerState(rs.getString("CUSTOMER_STATE"));
		customer.setCustomerZip(rs.getString("CUSTOMER_ZIP_POSTAL"));

		return customer;
	}

}