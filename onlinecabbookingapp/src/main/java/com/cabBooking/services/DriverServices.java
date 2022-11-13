package com.cabBooking.services;

import java.util.List;

import com.cabBooking.exceptions.AdminExceptions;
import com.cabBooking.exceptions.DriverException;
import com.cabBooking.models.Driver;
import com.cabBooking.models.DriverDTO;

public interface DriverServices {

	public Driver insertDriver(Driver driver, Integer adminId) throws DriverException, AdminExceptions;

	public Driver updateDriver(Driver driver, Integer adminId) throws DriverException, AdminExceptions;

	public Driver deleteDriver(int driverID, Integer adminId) throws DriverException, AdminExceptions;

	public List<DriverDTO> viewBestDriver() throws DriverException;

	public DriverDTO viewDriver(int driverId, Integer adminId) throws DriverException, AdminExceptions;

}
