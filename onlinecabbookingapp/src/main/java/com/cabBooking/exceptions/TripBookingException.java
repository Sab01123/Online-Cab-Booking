package com.cabBooking.exceptions;

public class TripBookingException extends Exception{

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TripBookingException(String message) {
		super();
		this.message = message;
	}
	
	
	
}
