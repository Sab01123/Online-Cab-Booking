package com.cabBooking.services;

import java.util.List;

import com.cabBooking.exceptions.AdminExceptions;
import com.cabBooking.exceptions.CustomerNotFound;
import com.cabBooking.exceptions.TripBookingException;
import com.cabBooking.models.TripBooking;

public interface ITripBookingService {

	public TripBooking insertTripBooking(TripBooking tripBooking, Integer id)
			throws TripBookingException, CustomerNotFound;

	public TripBooking updateTripBooking(TripBooking tripBooking, Integer id)
			throws TripBookingException, AdminExceptions;

	public TripBooking deleteTripBooking(int tripBookingId) throws TripBookingException, AdminExceptions;

	public List<TripBooking> viewAllTripsCustomer(Integer customerId, Integer id)
			throws CustomerNotFound, AdminExceptions;
}