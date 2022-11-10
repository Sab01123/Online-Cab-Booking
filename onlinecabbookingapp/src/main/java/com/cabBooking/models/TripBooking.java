package com.cabBooking.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class TripBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tripBookingId;
	private Integer customerId;
	
	@ManyToOne
	private Driver driver;
	private String fromLocation;
	private String toLocation;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime fromDateTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime toDateTime;
	private boolean status;
	private Float distanceInKm;
	private Float bill;
	public Integer getTripBookingId() {
		return tripBookingId;
	}
	public void setTripBookingId(Integer tripBookingId) {
		this.tripBookingId = tripBookingId;
	}
	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}
	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
	public LocalDateTime getToDateTime() {
		return toDateTime;
	}
	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Float getDistanceInKm() {
		return distanceInKm;
	}
	public void setDistanceInKm(Float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}
	public Float getBill() {
		return bill;
	}
	public void setBill(Float bill) {
		this.bill = bill;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	
	
	
}
