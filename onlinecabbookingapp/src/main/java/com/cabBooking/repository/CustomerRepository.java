package com.cabBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabBooking.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


	public Customer findByMobileNumber(String mobileNumber);

	


	
}
