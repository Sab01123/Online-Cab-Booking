package com.cabBooking.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@NotEmpty(message = "Cab type can't be Empty..")
	private String cabType;
	private Float perKmRate;

	@JsonIgnore

	@OneToMany(mappedBy = "cab")
	private List<Driver> drivers= new ArrayList<>();


	@Override
	public String toString() {
		return "Cab [cabId=" + cabId + ", cabType=" + cabType + ", perKmRate=" + perKmRate + ", driver=" + drivers
				+ "]";
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

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}
	
	public static void main(String[] args) {
		
	}

}
