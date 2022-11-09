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
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
	Set<TripBooking> tripBooking = new HashSet<>();

	
}
