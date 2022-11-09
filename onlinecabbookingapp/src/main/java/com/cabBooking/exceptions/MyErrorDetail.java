package com.cabBooking.exceptions;

import java.time.LocalDateTime;

public class MyErrorDetail {

	
	private LocalDateTime timestamp;
	private String message;
	private String description;
	
//	Constructor
	
	public MyErrorDetail() {
		
	}
	
	public MyErrorDetail(LocalDateTime timestamp, String message, String description) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}
	
//	getter-setter

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	//	tostring

	@Override
	public String toString() {
		return "MyErrorDetail [timestamp=" + timestamp + ", message=" + message + ", description=" + description + "]";
	}
	


	
	
	
	
	
}
