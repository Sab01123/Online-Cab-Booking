package com.cabBooking.services;

import com.cabBooking.exceptions.AdminExceptions;
import com.cabBooking.models.Admin;
import com.cabBooking.models.AdminCurrentSession;
import com.cabBooking.models.AdminDTO;
import com.cabBooking.models.TripBooking;

import java.time.LocalDate;
import java.util.List;

public interface AdminService {
	
	public AdminCurrentSession LoginAdmin(AdminDTO admin) throws AdminExceptions;
	
	public Admin insertAdmin(Admin admin, String key) throws AdminExceptions;

	

	public Admin deleteAdmin(Integer id, String key) throws AdminExceptions;

	public List<TripBooking> getAllTrips(Integer customerid, String key) throws AdminExceptions;

	public List<TripBooking> getTripsCabwise();

	public List<TripBooking> getTripsCustomerwise();

	public List<TripBooking> getTripsDatewise() throws AdminExceptions;

	public List<TripBooking> getAllTripsForDays(Integer customerId, LocalDate date) throws AdminExceptions;

	public Admin updateAdmin(Admin admin, String key) throws AdminExceptions;

}
