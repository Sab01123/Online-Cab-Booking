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
	
	@ExceptionHandler(CabException.class)
	public ResponseEntity<MyErrorDetail>  cabException(CabException me,WebRequest web) {

		MyErrorDetail err = new MyErrorDetail();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(web.getDescription(false));

		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);


	}
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<MyErrorDetail>  IllegalArguException(IllegalArgumentException me,WebRequest web) {

		MyErrorDetail err = new MyErrorDetail();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(web.getDescription(false));

		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);



}
