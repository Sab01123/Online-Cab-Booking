package com.cabBooking.services;

import java.util.List;

import com.cabBooking.exceptions.DriverException;
import com.cabBooking.models.Driver;
import com.cabBooking.models.DriverDTO;

public interface DriverServices {

	public Driver insertDriver(Driver driver) throws DriverException;

	public Driver updateDriver(Driver driver) throws DriverException;

	public Driver deleteDriver(int driverID) throws DriverException;

	public List<DriverDTO> viewBestDriver() throws DriverException;

	public DriverDTO viewDriver(int driverId) throws DriverException;

}