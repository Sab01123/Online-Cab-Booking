package com.cabBooking.services;

import com.cabBooking.exceptions.AdminExceptions;
import com.cabBooking.exceptions.CustomerNotFound;
import com.cabBooking.exceptions.TripBookingException;
import com.cabBooking.models.Admin;
import com.cabBooking.models.AdminCurrentSession;
import com.cabBooking.models.AdminDTO;
import com.cabBooking.models.TripBooking;

import java.time.LocalDate;
import java.util.List;

public interface AdminService {
	
	public AdminCurrentSession LoginAdmin(AdminDTO admin) throws AdminExceptions;
	
	public Admin insertAdmin(Admin admin, Integer id) throws AdminExceptions;

	

	public Admin deleteAdmin(Integer id, String key) throws AdminExceptions;

	public List<TripBooking> getAllTrips(Integer id) throws AdminExceptions;

	public List<TripBooking> getTripsCabwise(String cabType, Integer adminId) throws TripBookingException, AdminExceptions;

	public List<TripBooking> getTripsCustomerwise(Integer id, Integer adminId)throws CustomerNotFound, AdminExceptions;

	public List<TripBooking> getTripsDatewise(LocalDate date, Integer adminId) throws AdminExceptions, TripBookingException;

	public List<TripBooking> getAllTripsForDays(Integer customerId, LocalDate date, Integer adminId) throws AdminExceptions, TripBookingException;
		

	public Admin updateAdmin(Admin admin, Integer id) throws AdminExceptions;

}
