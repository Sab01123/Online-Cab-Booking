package com.cabBooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cabBooking.models.TripBooking;


@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking, Integer>{

	@Query("from TripBooking where customerId=?1")
	public List<TripBooking> findAllTripsByCustomerId(int id);
	
}
