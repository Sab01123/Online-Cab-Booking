package com.cabBooking.controller;

import java.util.List;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.exceptions.AdminExceptions;
import com.cabBooking.exceptions.CustomerNotFound;
import com.cabBooking.exceptions.TripBookingException;
import com.cabBooking.models.TripBooking;
import com.cabBooking.models.Driver;
import com.cabBooking.services.ITripBookingServiceImpl;

@RestController
public class TripBookingCntroller {
    
	@Autowired
	private ITripBookingServiceImpl iTBSImpl;
	
	@PostMapping("/bookings/{id}")
	public ResponseEntity<TripBooking> addTrip(@RequestBody TripBooking tb,@PathVariable("id") Integer id) throws TripBookingException, CustomerNotFound{
		
		
		
		return new ResponseEntity<TripBooking>(iTBSImpl.insertTripBooking(tb, id), HttpStatus.OK);
		
	}
	
	@PutMapping("/bookings/{id}")
	public ResponseEntity<TripBooking> updateTrip(@RequestBody TripBooking tb, @PathVariable("id") Integer id) throws TripBookingException, AdminExceptions{
		
		return new ResponseEntity<TripBooking>(iTBSImpl.updateTripBooking(tb, id), HttpStatus.ACCEPTED);
		
	}
    
	@GetMapping("/getTrips/{id}")
	public ResponseEntity<Set<TripBooking>> getTripsByDriver(@PathVariable("id") int id){
		
		Set<TripBooking> tbSet = iTBSImpl.viewTripsWithTheDriverId(id);
		for(TripBooking tb:tbSet) {
			
			System.out.println(tb.getFromDateTime().getHour());
		}
		
		return new ResponseEntity<Set<TripBooking>>(iTBSImpl.viewTripsWithTheDriverId(id) , HttpStatus.FOUND);
		
	}
   
	
	@DeleteMapping("/bookings/{id}")
	public ResponseEntity<TripBooking> removeTrip(@PathVariable("id") int tripiId) throws TripBookingException, AdminExceptions{
		
		return new ResponseEntity<TripBooking>(iTBSImpl.deleteTripBooking(tripiId), HttpStatus.OK);
		
	}
	
	@GetMapping("/trips/{id}/{aId}")
	public ResponseEntity<List<TripBooking>> getAllTripsByCustomer(@PathVariable("id") int id, @PathVariable("aId") Integer aId) throws CustomerNotFound, AdminExceptions{
		
		return new ResponseEntity<List<TripBooking>>(iTBSImpl.viewAllTripsCustomer(id, aId), HttpStatus.FOUND);
		
	}
	
	@GetMapping("/bill/{id}")
	public ResponseEntity<List<TripBooking>> calculateBill(@PathVariable("id") int customerId) throws CustomerNotFound, TripBookingException{
		
		
		return new ResponseEntity<List<TripBooking>>(iTBSImpl.calculateBill(customerId), HttpStatus.OK);
		
	}
}
