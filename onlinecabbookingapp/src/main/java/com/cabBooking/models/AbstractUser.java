package com.cabBooking.models;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class AbstractUser {

//	@NotNull(message ="username should not be null")
//	@Size(min =3,max=15,message="length of username must be between 3 & 15")
	private String username;

//	@NotNull(message ="user password should not be null")
//	@Size(min =3,max=10,message="length of username must be between 3 & 10")
	private String password;

//	@NotNull(message ="user address should not be null")
	private String address;

//	@NotNull(message ="user mobileNumber should not be null")
	private String mobileNumber;

//	@Email(message ="email should be in correct formate")
	private String email;

//	constructor
	public AbstractUser(
//			@NotNull(message = "username should not be null") @Size(min = 3, max = 15, message = "length of username must be between 3 & 15")
			String username,
//			@NotNull(message = "user password should not be null") @Size(min = 3, max = 10, message = "length of username must be between 3 & 10") 
			String password,
//			@NotNull(message = "user address should not be null")
			String address,
//			@NotNull(message = "user mobileNumber should not be null") 
			String mobileNumber,
//			@Email(message = "email should be in correct formate") 
			String email) {
		super();
		this.username = username;
		this.password = password;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public AbstractUser() {

	}

//	getter&& setter

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	toString

	@Override
	public String toString() {
		return "AbstractUser [username=" + username + ", password=" + password + ", address=" + address
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + "]";
	}

}
