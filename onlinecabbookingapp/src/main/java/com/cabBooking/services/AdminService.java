package com.cabBooking.services;

import com.cabBooking.exceptions.AdminExceptions;
import com.cabBooking.models.Admin;
import com.cabBooking.models.TripBooking;

import java.time.LocalDate;
import java.util.List;

public interface AdminService {

	public Admin insertAdmin(Admin admin) throws AdminExceptions;

	public Admin updateAdmin(Admin admin) throws AdminExceptions;

	public Admin deleteAdmin(Integer id) throws AdminExceptions;

	public List<TripBooking> getAllTrips(Integer customerid) throws AdminExceptions;

	public List<TripBooking> getTripsCabwise() throws AdminExceptions;;

	public List<TripBooking> getTripsCustomerwise() throws AdminExceptions;;

	public List<TripBooking> getTripsDatewise() throws AdminExceptions;

	public List<TripBooking> getAllTripsForDays(Integer customerId, LocalDate date) throws AdminExceptions;

}
