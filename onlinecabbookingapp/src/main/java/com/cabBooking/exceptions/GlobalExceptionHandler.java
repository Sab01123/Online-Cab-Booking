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
	public ResponseEntity<MyErrorDetail> myMNVEHandler(MethodArgumentNotValidException me) {

		MyErrorDetail err = new MyErrorDetail();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage("Valadition Error");
		err.setDescription(me.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(DriverException.class)
	public ResponseEntity<MyErrorDetail> productExceptionHandler(DriverException pe, WebRequest req) {

		MyErrorDetail err = new MyErrorDetail();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(pe.getMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);
	}

}
