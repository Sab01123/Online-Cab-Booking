package com.cabBooking.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cab {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cabId;
	private String cabType;
	private Float perKmRate;

	@OneToOne(cascade = CascadeType.ALL)
	private Driver driver;

	public Cab(Integer cabId, String cabType, Float perKmRate, Driver driver) {
		super();
		this.cabId = cabId;
		this.cabType = cabType;
		this.perKmRate = perKmRate;
		this.driver = driver;
	}

	public Cab() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cab [cabId=" + cabId + ", cabType=" + cabType + ", perKmRate=" + perKmRate + ", driver=" + driver + "]";
	}

	public Integer getCabId() {
		return cabId;
	}

	public void setCabId(Integer cabId) {
		this.cabId = cabId;
	}

	public String getCabType() {
		return cabType;
	}

	public void setCabType(String cabType) {
		this.cabType = cabType;
	}

	public Float getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(Float perKmRate) {
		this.perKmRate = perKmRate;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

}
