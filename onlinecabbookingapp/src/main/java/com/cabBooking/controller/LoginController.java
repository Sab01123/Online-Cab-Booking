package com.cabBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.exceptions.LoginException;
import com.cabBooking.models.LoginDTO;
import com.cabBooking.services.LoginServiceImpl;

@RestController
public class LoginController {

	@Autowired
	private LoginServiceImpl lSImpl;

	@PostMapping("/login")
	public ResponseEntity<String> logIn(@RequestBody LoginDTO logInDTO) throws LoginException {

		return new ResponseEntity<String>(lSImpl.logIntoAccount(logInDTO), HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/logout/{key}")
	public ResponseEntity<String> logOut(@PathVariable("key") String key) throws LoginException {

		return new ResponseEntity<String>(lSImpl.logOutFromAccount(key), HttpStatus.OK);

	}

}