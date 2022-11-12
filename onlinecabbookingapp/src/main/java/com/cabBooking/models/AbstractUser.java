package com.cabBooking.models;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@MappedSuperclass

public class AbstractUser {

	@NotNull(message ="username should not be null")
	@Size(min =3,max=15,message="length of username must be between 3 & 15")
	private String username;

	@NotNull(message ="user password should not be null")
	@Size(min =3,max=10,message="length of username must be between 3 & 10")
	private String password;

	@NotNull(message ="user address should not be null")
	private String address;

	@NotNull(message ="user mobileNumber should not be null")
	private String mobileNumber;

	@Email(message ="email should be in correct formate")
	private String email;



	



	


	
	

	

	

 

	
	
	

}
