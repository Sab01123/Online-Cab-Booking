package com.cabBooking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.exceptions.CustomerNotFound;
import com.cabBooking.exceptions.InvalidId;
import com.cabBooking.models.CurrentUserSession;
import com.cabBooking.models.Customer;
import com.cabBooking.models.CustomerDTO1;
import com.cabBooking.repository.CustomerRepository;
import com.cabBooking.repository.SessionDao;

@Service
public class CustomerServiceImpl implements CustomerServices {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private SessionDao session;

	@Override
	public Customer insertCustomer(Customer customer) throws CustomerNotFound {
		Customer c = customerRepo.findByUsername(customer.getUsername());

		if (c == null) {

			return customerRepo.save(customer);

		}

		throw new CustomerNotFound("Customer already exists with this username " + customer.getUsername());

	}

	@Override
	public Customer updateCustomer(Customer customer, Integer id) throws CustomerNotFound {

		Optional<Customer> cust = customerRepo.findById(customer.getCustomerId());

		if (cust.isPresent()) {

			Optional<CurrentUserSession> opt = session.findById(id);

			if (opt.isPresent()) {
				Customer updateCustomer = customerRepo.save(customer);

				return updateCustomer;
			}
			throw new CustomerNotFound("No current session exists for this user");

		} else {
			throw new CustomerNotFound("customer detail Error.");
		}

	}

	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerNotFound, InvalidId {
		Optional<Customer> cust = customerRepo.findById(customerId);

		if (cust.isPresent()) {

			Optional<CurrentUserSession> opt = session.findById(customerId);
			
			if (opt.isPresent()) {

				Customer c = cust.get();

				customerRepo.delete(c);
				session.delete(opt.get());

				return c;

			}

			throw new CustomerNotFound("No current user session exists for this user");
		}

		throw new InvalidId("Customer not present with id " + customerId);

	}

//	@Override
//	public List<Customer> viewCustomers()throws CustomerNotFound {
//		
//		List<Customer> cust = customerRepo.findAll();
//		
//		if(cust.size()==0) {
//			throw new CustomerNotFound("Customer not found");
//		}
//		return cust;
//		
//		
//	}

	@Override
	public Customer viewCustomerById(Integer customerId) throws InvalidId, CustomerNotFound {

		Optional<Customer> cust = customerRepo.findById(customerId);

		if (cust.isPresent()) {

			Optional<CurrentUserSession> opt = session.findById(customerId);

			if (opt.isPresent()) {

				Customer cus = cust.get();
				return cus;

			}
			throw new CustomerNotFound("No current user session exists for this user");
		}

		throw new InvalidId("customer id is invalid or not present:" + customerId);

	}

	@Override
	public Customer validateCustomer(CustomerDTO1 customerdto) throws CustomerNotFound {

		List<Customer> cus = customerRepo.findAll();

		for (int i = 0; i < cus.size(); i++) {
			if (cus.get(i).getUsername().equals(customerdto.getUsername())
					&& cus.get(i).getPassword().equals(customerdto.getPassword()))
				return cus.get(i);
		}

		throw new CustomerNotFound("Invalid username and password");

	}

}
