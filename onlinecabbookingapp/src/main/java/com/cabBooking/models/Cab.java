package com.cabBooking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Cab {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cabId;
	private String	cabType;
	private Float	perKmRate;
	
	public Cab() {
		// TODO Auto-generated constructor stub
	}
}
