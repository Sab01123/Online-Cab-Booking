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
	
	
	@PostMapping("/insert")
	public ResponseEntity<Admin> insertAdmin(@RequestBody Admin admin, @RequestBody AdminCurrentSessionDto acsd) throws AdminExceptions{
		
		return new ResponseEntity<Admin>(adminService.insertAdmin(admin, acsd.getKey()), HttpStatus.ACCEPTED);
		
	}

	@PutMapping("/update")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin, @RequestBody AdminCurrentSessionDto acsd) throws AdminExceptions{
		
		return new ResponseEntity<Admin>( adminService.updateAdmin(admin, acsd.getKey()) ,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Admin> deleteAdmin(@PathVariable("id") int id , @RequestBody AdminCurrentSessionDto acsd) throws AdminExceptions{
		
		return new ResponseEntity<Admin>( adminService.deleteAdmin(id, acsd.getKey()) ,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/trips/{id}")
	public ResponseEntity<List<TripBooking>> getTrips(@PathVariable("id") int id , @RequestBody AdminCurrentSessionDto acsd) throws AdminExceptions{
		
		return new ResponseEntity<List<TripBooking>>(adminService.getAllTrips(id, acsd.getKey()), HttpStatus.OK);
		
	}
	
}
