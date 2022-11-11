package com.cabBooking.services;

import java.util.List;

import com.cabBooking.exceptions.CustomerNotFound;
import com.cabBooking.exceptions.InvalidId;
import com.cabBooking.models.Customer;

public interface CustomerServices {

	public Customer insertCustomer(Customer customer)throws CustomerNotFound;
	public Customer updateCustomer(Customer customer) throws CustomerNotFound ;
	public Customer deleteCustomer(Integer customerId) throws CustomerNotFound,InvalidId;
	public List<Customer> viewCustomers()throws CustomerNotFound;
	public Customer viewCustomerById(Integer customerId) throws InvalidId ;
	public Customer validateCustomer(String username, String password) throws CustomerNotFound;
	
	
}
