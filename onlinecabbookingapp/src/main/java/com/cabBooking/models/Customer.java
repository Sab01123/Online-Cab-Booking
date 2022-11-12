package com.cabBooking.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Customer extends AbstractUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	
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

	


	
	
	
	
	
}
