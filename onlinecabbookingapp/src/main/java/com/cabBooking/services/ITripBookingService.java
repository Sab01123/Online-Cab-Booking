package com.cabBooking.services;

import java.util.List;

import com.cabBooking.exceptions.CustomerNotFound;
import com.cabBooking.exceptions.TripBookingException;
import com.cabBooking.models.TripBooking;

public interface ITripBookingService {

	public TripBooking insertTripBooking(TripBooking tripBooking) throws TripBookingException;
	
	
	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripBookingException;
	
	
	public TripBooking deleteTripBooking(int tripBookingId) throws TripBookingException;


	public List<TripBooking> viewAllTripsCustomer(int customerId) throws CustomerNotFound;
}
