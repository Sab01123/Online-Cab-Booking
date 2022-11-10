package com.cabBooking.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<MyErrorDetail>  myMNVEHandler(MethodArgumentNotValidException me) {
		
		MyErrorDetail err = new MyErrorDetail();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage("Valadition Error");
		err.setDescription(me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);
		
		
	}
	
	
	
	
	
	
	@ExceptionHandler(CustomerNotFound.class)
public ResponseEntity<MyErrorDetail> customerNotFoundHandler (CustomerNotFound cf , WebRequest wr) {
		
		MyErrorDetail err = new MyErrorDetail();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(cf.getMessage());
		err.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);
		
		
	}
	
	@ExceptionHandler(InValidId.class)
	public ResponseEntity<MyErrorDetail> inValidIdHandler ( InValidId id, WebRequest wr) {
			
			MyErrorDetail err = new MyErrorDetail();
			
			err.setTimestamp(LocalDateTime.now());
			err.setMessage(id.getMessage());
			err.setDescription(wr.getDescription(false));
			
			return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);
			
			
		}
	
	@ExceptionHandler(TripBookingException.class)
	public ResponseEntity<MyErrorDetail> tripBookingExceptionHandler(TripBookingException tbe, WebRequest wr){
		
		MyErrorDetail med = new MyErrorDetail(LocalDateTime.now(), tbe.getMessage(), wr.getDescription(false));
	
	
		return new ResponseEntity<MyErrorDetail>(med, HttpStatus.BAD_REQUEST);
	}
	
	
}
