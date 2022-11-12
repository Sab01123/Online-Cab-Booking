package com.cabBooking.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.exceptions.AdminExceptions;
import com.cabBooking.exceptions.CustomerNotFound;
import com.cabBooking.exceptions.TripBookingException;
import com.cabBooking.models.Admin;
import com.cabBooking.models.AdminCurrentSession;
import com.cabBooking.models.AdminCurrentSessionDto;
import com.cabBooking.models.AdminDTO;
import com.cabBooking.models.TripBooking;
import com.cabBooking.services.AdminService;
import com.cabBooking.services.AdminServiceImp;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/login")
	public ResponseEntity<AdminCurrentSession> adminLogin(@RequestBody AdminDTO admin) throws AdminExceptions{
		
		return new ResponseEntity<AdminCurrentSession>(adminService.LoginAdmin(admin), HttpStatus.ACCEPTED);
		
	}
	
	
	@PostMapping("/insert/{key}")
	public ResponseEntity<Admin> insertAdmin(@RequestBody Admin admin,@PathVariable("key") String key) throws AdminExceptions{
		
		return new ResponseEntity<Admin>(adminService.insertAdmin(admin, key), HttpStatus.ACCEPTED);
		
	}

	@PutMapping("/update/{key}")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin, @PathVariable("key") String key) throws AdminExceptions{
		
		return new ResponseEntity<Admin>( adminService.updateAdmin(admin, key) ,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Admin> deleteAdmin(@PathVariable("id") int id , @RequestBody AdminCurrentSessionDto acsd) throws AdminExceptions{
		
		return new ResponseEntity<Admin>( adminService.deleteAdmin(id, acsd.getKey()) ,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/trips/{key}")
	public ResponseEntity<List<TripBooking>> getTrips(@PathVariable("key") String key) throws AdminExceptions{
		
		return new ResponseEntity<List<TripBooking>>(adminService.getAllTrips(key), HttpStatus.OK);
		
	}
	
	@GetMapping("/tripsByCab/{type}")
	public ResponseEntity<List<TripBooking>> getTripsByCabType(@PathVariable("type") String type , @RequestBody AdminCurrentSessionDto acsd) throws AdminExceptions, TripBookingException{
		
		return new ResponseEntity<List<TripBooking>>(adminService.getTripsCabwise(type, acsd.getKey()), HttpStatus.OK);
		
	}
	
	@GetMapping("/tripsByDate/{date}")
	public ResponseEntity<List<TripBooking>> getTripsByDate(@PathVariable("date") String date , @RequestBody AdminCurrentSessionDto acsd) throws AdminExceptions, TripBookingException{
		
		LocalDate realDate = LocalDate.parse(date);
		
		return new ResponseEntity<List<TripBooking>>(adminService.getTripsDatewise(realDate, acsd.getKey()), HttpStatus.OK);
		
	}
	
	@GetMapping("/tripsByCustomer/{id}")
	public ResponseEntity<List<TripBooking>> getTripsByDate(@PathVariable("id") Integer id , @RequestBody AdminCurrentSessionDto acsd) throws AdminExceptions, TripBookingException, CustomerNotFound{
		
		
		
		return new ResponseEntity<List<TripBooking>>(adminService.getTripsCustomerwise(id, acsd.getKey()), HttpStatus.OK);
		
	}
	
	@GetMapping("/tripsByCustomer/{id}/{date}")
	public ResponseEntity<List<TripBooking>> getTripsByDateWithCustomer(@PathVariable("id") Integer id ,@PathVariable("date") String date, @RequestBody AdminCurrentSessionDto acsd) throws AdminExceptions, TripBookingException, CustomerNotFound{
		
		LocalDate realDate = LocalDate.parse(date);
		
		return new ResponseEntity<List<TripBooking>>(adminService.getAllTripsForDays(id, realDate, acsd.getKey()), HttpStatus.OK);
		
	}
	
}