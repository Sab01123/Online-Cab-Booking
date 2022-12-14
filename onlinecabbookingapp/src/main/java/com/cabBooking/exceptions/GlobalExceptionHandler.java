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
	public ResponseEntity<MyErrorDetail> cabException(CabException me, WebRequest web) {

		MyErrorDetail err = new MyErrorDetail();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(me.getMessage());
		err.setDescription(web.getDescription(false));

		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetail> myMNVEHandler(MethodArgumentNotValidException me) {

		MyErrorDetail err = new MyErrorDetail();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage("Valadition Error");
		err.setDescription(me.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(CustomerNotFound.class)
	public ResponseEntity<MyErrorDetail> customerNotFoundHandler(CustomerNotFound cf, WebRequest wr) {

		MyErrorDetail err = new MyErrorDetail();

		err.setTimestamp(LocalDateTime.now());

		err.setMessage(cf.getMessage());
		err.setDescription(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<MyErrorDetail> IllegalArgumentExceptionHandler(IllegalArgumentException id, WebRequest wr) {

		MyErrorDetail err = new MyErrorDetail();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(id.getMessage());
		err.setDescription(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidId.class)
	public ResponseEntity<MyErrorDetail> inValidIdHandler(InvalidId id, WebRequest wr) {

		MyErrorDetail err = new MyErrorDetail();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(id.getMessage());
		err.setDescription(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TripBookingException.class)
	public ResponseEntity<MyErrorDetail> tripBookingExceptionHandler(TripBookingException tbe, WebRequest wr) {

		MyErrorDetail err = new MyErrorDetail();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(tbe.getMessage());
		err.setDescription(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetail> tripBookingExceptionHandler(LoginException le, WebRequest wr) {

		MyErrorDetail err = new MyErrorDetail();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(le.getMessage());
		err.setDescription(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(AdminExceptions.class)
	public ResponseEntity<MyErrorDetail> tripBookingExceptionHandler(AdminExceptions ae, WebRequest wr) {

		MyErrorDetail err = new MyErrorDetail();

		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ae.getMessage());
		err.setDescription(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetail>(err, HttpStatus.BAD_REQUEST);
	}
}
