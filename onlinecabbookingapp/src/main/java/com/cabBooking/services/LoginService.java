package com.cabBooking.services;

import javax.validation.Valid;

import com.cabBooking.exceptions.LoginException;
import com.cabBooking.models.CustomerDTO;
import com.cabBooking.models.LoginDTO;

public interface LoginService {

	public String logIntoAccount(LoginDTO ldo) throws LoginException;

	public String logOutFromAccount(String key) throws LoginException;

}