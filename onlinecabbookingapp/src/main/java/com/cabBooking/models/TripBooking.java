package com.cabBooking.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TripBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tripBookingId;
	private Integer customerId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Driver driver;
	private String fromLocation;
	private String toLocation;
	private boolean status;
	private Float distanceInKm;
	private Float bill;
	
	
	
}
