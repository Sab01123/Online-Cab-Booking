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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driverId;
	private String liscenceNo;

	@OneToOne(cascade = CascadeType.ALL)
	private Cab cab;
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

	
}
