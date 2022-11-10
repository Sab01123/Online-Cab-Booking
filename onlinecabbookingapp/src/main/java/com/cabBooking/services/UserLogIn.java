package com.cabBooking.services;

import com.cabBooking.models.LoginDTO;

public interface UserLogIn {

	public String logIntoAccount(LoginDTO loginDTO);

	public String logOutFromAccount(String key);
}
