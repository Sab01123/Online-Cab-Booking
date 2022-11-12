package com.cabBooking.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabBooking.exceptions.DriverException;
import com.cabBooking.models.Driver;
import com.cabBooking.models.DriverDTO;
import com.cabBooking.services.DriverServices;
import com.cabBooking.services.DriverServicesImpl;

@RestController
public class DriverContoller {

	@Autowired
	DriverServicesImpl dService;

	@PostMapping("/driver")
	public ResponseEntity<Driver> addDriver(@RequestBody Driver driver) throws DriverException {

		Driver newDriver = dService.insertDriver(driver);

		return new ResponseEntity<Driver>(newDriver, HttpStatus.CREATED);

	}

	@PutMapping("/driver")
	public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver) throws DriverException {

		Driver newDriver = dService.updateDriver(driver);

		return new ResponseEntity<Driver>(newDriver, HttpStatus.OK);

	}

	@DeleteMapping("/driver/{driverId}")
	public ResponseEntity<Driver> deleteDriver(@PathVariable("driverId") int driverID) throws DriverException {

		Driver newDriver = dService.deleteDriver(driverID);

		return new ResponseEntity<Driver>(newDriver, HttpStatus.OK);

	}

	@GetMapping("/drivers")
	public ResponseEntity<List<DriverDTO>> bestDriver() throws DriverException {

		List<DriverDTO> list = dService.viewBestDriver();

		return new ResponseEntity<List<DriverDTO>>(list, HttpStatus.CREATED);

	}

	@GetMapping("/driver/{id}")
	public ResponseEntity<DriverDTO> getDriver(@PathVariable("id") int Driverid) throws DriverException {

		DriverDTO requiredDriver = dService.viewDriver(Driverid);

		return new ResponseEntity<DriverDTO>(requiredDriver, HttpStatus.CREATED);

	}

	@GetMapping("/listOfDrivers/{id}")
	public ResponseEntity<List<Driver>> listOfDriver(@PathVariable("id") Integer id) {
		List<Driver> list = dService.getDriversByCabId(id);

		return new ResponseEntity<List<Driver>>(list, HttpStatus.OK);
	}

}