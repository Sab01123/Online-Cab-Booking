package com.cabBooking.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cabBooking.exceptions.LoginException;
import com.cabBooking.models.CustomerDTO;
import com.cabBooking.models.LoginDTO;
import com.cabBooking.services.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService userLogIn;

	// for user Login
	@PostMapping(value = "/login")
	public String logInCustomer(@Valid @RequestBody LoginDTO logindto) throws LoginException {
		return userLogIn.logIntoAccount(logindto);
	}

	// for user Logout
	@PatchMapping(value = "/logout")
	public String logOutCustomer(@RequestParam(required = false) String key) throws LoginException {
		return userLogIn.logOutFromAccount(key);
	}

}
