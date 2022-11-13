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
	public ResponseEntity<AdminCurrentSession> adminLogin(@RequestBody AdminDTO admin) throws AdminExceptions {

		return new ResponseEntity<AdminCurrentSession>(adminService.LoginAdmin(admin), HttpStatus.ACCEPTED);

	}

	@PostMapping("/insert/{adminId}")
	public ResponseEntity<Admin> insertAdmin(@RequestBody Admin admin, @PathVariable("adminId") Integer adminId)
			throws AdminExceptions {

		return new ResponseEntity<Admin>(adminService.insertAdmin(admin, adminId), HttpStatus.ACCEPTED);

	}

	@PutMapping("/update/{adminId}")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin, @PathVariable("adminId") Integer adminId)
			throws AdminExceptions {

		return new ResponseEntity<Admin>(adminService.updateAdmin(admin, adminId), HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/delete/{adminId}")
	public ResponseEntity<Admin> deleteAdmin(@PathVariable("adminId") int id, @RequestBody AdminCurrentSessionDto acsd)
			throws AdminExceptions {

		return new ResponseEntity<Admin>(adminService.deleteAdmin(id, acsd.getKey()), HttpStatus.ACCEPTED);

	}

	@GetMapping("/trips/{adminId}")
	public ResponseEntity<List<TripBooking>> getTrips(@PathVariable("adminId") Integer adminId) throws AdminExceptions {

		return new ResponseEntity<List<TripBooking>>(adminService.getAllTrips(adminId), HttpStatus.OK);

	}

	@GetMapping("/tripsByCab/{type}/{adminId}")
	public ResponseEntity<List<TripBooking>> getTripsByCabType(@PathVariable("type") String type,
			@PathVariable("id") Integer adminId) throws AdminExceptions, TripBookingException {

		return new ResponseEntity<List<TripBooking>>(adminService.getTripsCabwise(type, adminId), HttpStatus.OK);

	}

	@GetMapping("/tripsByDate/{date}/{adminId}")
	public ResponseEntity<List<TripBooking>> getTripsByDate(@PathVariable("date") String date,
			@PathVariable("adminId") Integer adminId) throws AdminExceptions, TripBookingException {

		LocalDate realDate = LocalDate.parse(date);

		return new ResponseEntity<List<TripBooking>>(adminService.getTripsDatewise(realDate, adminId),
				HttpStatus.OK);

	}

	@GetMapping("/tripsByCustomer/{customerId}/{adminId}")
	public ResponseEntity<List<TripBooking>> getTripsByDate(@PathVariable("customerId") Integer customerId,
			@PathVariable("adminId") Integer adminId) throws AdminExceptions, TripBookingException, CustomerNotFound {

		return new ResponseEntity<List<TripBooking>>(adminService.getTripsCustomerwise(customerId, adminId),
				HttpStatus.OK);

	}

	@GetMapping("/tripsByCustomer/{customerId}/{adminId}/{date}")
	public ResponseEntity<List<TripBooking>> getTripsByDateWithCustomer(@PathVariable("customerId") Integer customerId,
			@PathVariable("date") String date, @PathVariable("adminId") Integer adminId)
			throws AdminExceptions, TripBookingException, CustomerNotFound {

		LocalDate realDate = LocalDate.parse(date);

		return new ResponseEntity<List<TripBooking>>(adminService.getAllTripsForDays(customerId, realDate, adminId),
				HttpStatus.OK);

	}

}
