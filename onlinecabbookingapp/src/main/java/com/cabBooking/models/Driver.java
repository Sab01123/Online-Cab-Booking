package com.cabBooking.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Driver extends AbstractUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driverId;

	private String liscenceNo;

//	@OneToOne(cascade = CascadeType.ALL)
//	private Cab cab;
	private Float rating;
	
	@JsonIgnore
	@OneToMany(mappedBy = "driver")
	Set<TripBooking> tripBooking = new HashSet<>();

	public Integer getDriverId() {
		return driverId;
	}

	public Set<TripBooking> getTripBooking() {
		return tripBooking;
	}

	public void setTripBooking(Set<TripBooking> tripBooking) {
		this.tripBooking = tripBooking;
	}

	public String getLiscenceNo() {
		return liscenceNo;
	}

	public void setLiscenceNo(String liscenceNo) {
		this.liscenceNo = liscenceNo;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public String getLiscenceNo() {
		return liscenceNo;
	}

	public void setLiscenceNo(String liscenceNo) {
		this.liscenceNo = liscenceNo;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", liscenceNo=" + liscenceNo + ", rating=" + rating + "]";
	}

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Driver(
			@NotNull(message = "username should not be null") @Size(min = 3, max = 15, message = "length of username must be between 3 & 15") String username,
			@NotNull(message = "user password should not be null") @Size(min = 3, max = 10, message = "length of username must be between 3 & 10") String password,
			@NotNull(message = "user address should not be null") String address,
			@NotNull(message = "user mobileNumber should not be null") String mobileNumber,
			@Email(message = "email should be in correct formate") String email) {
		super(username, password, address, mobileNumber, email);
		// TODO Auto-generated constructor stub
	}

	public Driver(
			@NotNull(message = "username should not be null") @Size(min = 3, max = 15, message = "length of username must be between 3 & 15") String username,
			@NotNull(message = "user password should not be null") @Size(min = 3, max = 10, message = "length of username must be between 3 & 10") String password,
			@NotNull(message = "user address should not be null") String address,
			@NotNull(message = "user mobileNumber should not be null") String mobileNumber,
			@Email(message = "email should be in correct formate") String email, Integer driverId, String liscenceNo,
			Float rating) {
		super(username, password, address, mobileNumber, email);
		this.driverId = driverId;
		this.liscenceNo = liscenceNo;
		this.rating = rating;
	}

	public static void main(String[] args) {

	}
}
