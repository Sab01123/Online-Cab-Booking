package com.cabBooking.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.exceptions.DriverException;
import com.cabBooking.models.Driver;
import com.cabBooking.models.DriverDTO;
import com.cabBooking.repository.DriverRepository;

@Service
public class DriverServicesImpl implements DriverServices {

	@Autowired
	private DriverRepository dRepo;

	@Override
	public Driver insertDriver(Driver driver) throws DriverException {
		// TODO Auto-generated method stub

		Driver savedDriver = dRepo.save(driver);

		if (savedDriver == null) {
			throw new DriverException("Failed To Add Driver");
		}

		return savedDriver;
	}

	@Override
	public Driver updateDriver(Driver driver) throws DriverException {
		// TODO Auto-generated method stub

		Optional<Driver> opt = dRepo.findById(driver.getDriverId());
		if (opt.isPresent()) {

			return dRepo.save(driver);

		} else {
			throw new DriverException("No Driver Found With Driver Id:-" + driver.getDriverId());
		}

	}

	@Override
	public Driver deleteDriver(int driverID) throws DriverException {
		// TODO Auto-generated method stub

		Optional<Driver> opt = dRepo.findById(driverID);
		if (opt.isPresent()) {
			Driver driver = opt.get();
			dRepo.delete(driver);

			return driver;

		} else {
			throw new DriverException("No Driver Found With Driver Id:-" + driverID);
		}

	}

	@Override
	public List<DriverDTO> viewBestDriver() throws DriverException {
		// TODO Auto-generated method stub

		System.out.println("===========================");
		List<DriverDTO> listOfDrivers = dRepo.getBestDrivers();

		System.out.println(listOfDrivers);
		System.out.println("=======================");

		if (listOfDrivers.size() == 0) {
			throw new DriverException("Sorry, Currently We Dont Have Any Best Drivers");

		}

		return listOfDrivers;
	}

	@Override
	public DriverDTO viewDriver(int driverId) throws DriverException {

		DriverDTO driver = dRepo.getDriver(driverId);
		if (driver != null) {

			return driver;

		} else {
			throw new DriverException("No Driver Found With Driver Id:-" + driverId);
		}

	}

}
