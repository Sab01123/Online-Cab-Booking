package com.cabBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.exceptions.TripBookingException;
import com.cabBooking.models.TripBooking;
import com.cabBooking.services.ITripBookingServiceImpl;

@RestController
public class TripBookingCntroller {
    
	@Autowired
	private ITripBookingServiceImpl iTBSImpl;
	
	@PostMapping("/bookings")
	public ResponseEntity<TripBooking> addTrip(@RequestBody TripBooking tb) throws TripBookingException{
		
		return new ResponseEntity<TripBooking>(iTBSImpl.insertTripBooking(tb), HttpStatus.OK);
		
	}
	
	@PutMapping("/bookings")
	public ResponseEntity<TripBooking> updateTrip(@RequestBody TripBooking tb) throws TripBookingException{
		
		return new ResponseEntity<TripBooking>(iTBSImpl.updateTripBooking(tb), HttpStatus.ACCEPTED);
		
	}
}
