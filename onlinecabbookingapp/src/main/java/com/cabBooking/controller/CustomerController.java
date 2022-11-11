package com.cabBooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.exceptions.CustomerNotFound;
import com.cabBooking.exceptions.InvalidId;
import com.cabBooking.models.Customer;
import com.cabBooking.services.CustomerServices;

@RestController

public class CustomerController {
     @Autowired
	private CustomerServices customerService;
	
	@PostMapping("/save")
	public ResponseEntity<Customer> insertCustomersHandler(@Valid @RequestBody Customer customer) throws CustomerNotFound{
	Customer cus = 	customerService.insertCustomer(customer);
	
	return new ResponseEntity<Customer>(cus, HttpStatus.OK);
		
	}
	
	@PutMapping("/update/customer")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestBody Customer customer) throws CustomerNotFound{
		
		Customer cus = customerService.updateCustomer(customer);
		
		return new ResponseEntity<Customer>(cus,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Customer> deleteCustomerHandler(@PathVariable("id")  Integer id) throws CustomerNotFound, InvalidId{
			
		Customer cus = 	customerService.deleteCustomer(id);
			
			return new ResponseEntity<Customer>(cus, HttpStatus.OK);
			
	}
	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomersHandler() throws CustomerNotFound{
		
		List<Customer> cus = customerService.viewCustomers();
		
		return new ResponseEntity<List<Customer>>(cus,HttpStatus.OK);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerByIdHandler(@PathVariable("id") Integer id) throws InvalidId{
		
		Customer cus = 	customerService.viewCustomerById(id);
		
		return new ResponseEntity<Customer> (cus,HttpStatus.OK);
		
}
	@PostMapping("/validateCustomer/{username}/{password}")
//	@PostMapping("/validateCustomer")
	public ResponseEntity<Customer> vaildCustomerByUserName( @PathVariable("username") String username, @PathVariable("password") String password) throws CustomerNotFound{
		Customer cus = 	customerService.validateCustomer(username, password);
		
		return new ResponseEntity<>(cus,HttpStatus.ACCEPTED);
		
		
	}
	
	
	
}
