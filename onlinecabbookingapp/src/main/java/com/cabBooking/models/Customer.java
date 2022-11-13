package com.cabBooking.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
public class Customer extends AbstractUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;

	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private Set<TripBooking> trips = new HashSet<>();

	public Set<TripBooking> getTrips() {
		return trips;
	}

	public void setTrips(Set<TripBooking> trips) {
		this.trips = trips;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(
			@NotNull(message = "username should not be null") @Size(min = 3, max = 15, message = "length of username must be between 3 & 15") String username,
			@NotNull(message = "user password should not be null") @Size(min = 3, max = 10, message = "length of username must be between 3 & 10") String password,
			@NotNull(message = "user address should not be null") String address,
			@NotNull(message = "user mobileNumber should not be null") String mobileNumber,
			@Email(message = "email should be in correct formate") String email) {
		super(username, password, address, mobileNumber, email);
		// TODO Auto-generated constructor stub
	}

}
