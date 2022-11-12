package com.cabBooking.models;

public class DriverDTO {

	private Integer driverId;
	private Float rating;
	private String username;
	private String mobileNo;

	public DriverDTO(int driverId, Float rating, String username, String mobileNo) {
		super();
		this.driverId = driverId;
		this.rating = rating;
		this.username = username;
		this.mobileNo = mobileNo;
	}

	public DriverDTO() {

	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "DriverDTO [driverId=" + driverId + ", rating=" + rating + ", username=" + username + ", mobileNo="
				+ mobileNo + "]";
	}

}
