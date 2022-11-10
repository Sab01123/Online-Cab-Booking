package com.cabBooking.services;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cabBooking.models.LoginDTO;
import net.bytebuddy.utility.RandomString;

@Service
public class UserLogInImpl implements UserLogIn {

	@Override
	public String logOutFromAccount(String key) {
	
		return null;
	}

	@Override
	public String logIntoAccount(LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
