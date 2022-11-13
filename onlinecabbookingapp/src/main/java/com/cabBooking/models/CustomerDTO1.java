package com.cabBooking.models;

import lombok.Data;

@Data
public class CustomerDTO1 {

	private String username;
	private String password;

	public CustomerDTO1(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public CustomerDTO1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
