package com.cabBooking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.exceptions.CustomerNotFound;
import com.cabBooking.exceptions.InvalidId;
import com.cabBooking.models.Customer;
import com.cabBooking.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerServices {
	
	@Autowired
	private CustomerRepository customerRepo;
	

	@Override
	public Customer insertCustomer(Customer customer) throws CustomerNotFound {
		Customer c = customerRepo.findByUsername(customer.getUsername());
		
		if(c==null) {
			customerRepo.save(customer);
		}
		
		throw new CustomerNotFound("Customer already exists with this username "+customer.getUsername());
		
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFound {
	 
		Optional<Customer> cust = customerRepo.findById(customer.getCustomerId());
		
		if(cust.isPresent()) {
			Customer updateCustomer = customerRepo.save(customer) ;

			return updateCustomer;
		}else {
			throw new CustomerNotFound("customer detail Error.");
		}
		
		
	}

	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerNotFound,InvalidId{
		Optional<Customer>  cust = customerRepo.findById(customerId);
		 
		if(cust.isPresent()) {	
		Customer cus = cust.get();
		customerRepo.delete(cus);
		return cus;
		
		}else {
			
			throw new InvalidId("customer id is invalid or not present:" + customerId);
		}
		
		
	
	}

	@Override
	public List<Customer> viewCustomers()throws CustomerNotFound {
		
		List<Customer> cust = customerRepo.findAll();
		
		if(cust.size()==0) {
			throw new CustomerNotFound("Customer not found");
		}
		return cust;
		
		
	}

	@Override
	public Customer viewCustomerById(Integer customerId)throws InvalidId{
	
		Optional<Customer>  cust = customerRepo.findById(customerId);
		 
		if(cust.isPresent()) {	
		Customer cus = cust.get();
		return cus;
		
		}else {
			
			throw new InvalidId("customer id is invalid or not present:" + customerId);
		}
		
		
	}

	@Override
	public Customer validateCustomer(String username, String password) throws CustomerNotFound{
		
		List<Customer> cust = customerRepo.findAll();
		
		for(Customer c :cust) {
			if(c.getUsername().equalsIgnoreCase(username)
					&& c.getPassword().equals(password)) {
				  return c;
			
			}
			
		}
		
			
				throw new CustomerNotFound("Customer should not present with this username:" +username + "password :"+ password);
		
		}
		
		

	

}
