package com.cabBooking.controller;

import java.util.List;

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

import com.cabBooking.exceptions.AdminExceptions;
import com.cabBooking.exceptions.CabException;
import com.cabBooking.models.Cab;
import com.cabBooking.services.CabServiceImpl;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CabController {

	@Autowired
	private CabServiceImpl service;

	@PostMapping("/cab/{adminId}")
	public ResponseEntity<Cab> RegisterCabHandler(@RequestBody Cab cab, @PathVariable("adminId") Integer adminId)
			throws AdminExceptions {

		Cab insertCab = service.insertCab(cab, adminId);

		return new ResponseEntity<Cab>(insertCab, HttpStatus.CREATED);
	}

	@PutMapping("/cab/{adminId}")
	public ResponseEntity<Cab> updateCabHandler(@RequestBody Cab cab, @PathVariable("adminId") Integer adminId)
			throws CabException, AdminExceptions {

		Cab updateCab = service.updateCab(cab, adminId);

		return new ResponseEntity<Cab>(updateCab, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/cab/{cId}/{adminId}")
	public ResponseEntity<Cab> deleteCabHandler(@PathVariable("cId") Integer cabId,
			@PathVariable("adminId") Integer adminId) throws CabException, AdminExceptions {

		Cab deleteCab = service.deleteCab(cabId, adminId);

		return new ResponseEntity<Cab>(deleteCab, HttpStatus.OK);
	}

	@GetMapping("/cabs/{carType}/{adminId}")
	public ResponseEntity<List<Cab>> viewCabsOfTypesHandler(@PathVariable("carType") String carType,
			@PathVariable("adminId") Integer adminId) throws CabException, AdminExceptions {

		List<Cab> viewCabsOfTypes = service.viewCabsOfTypes(carType, adminId);

		return new ResponseEntity<List<Cab>>(viewCabsOfTypes, HttpStatus.OK);
	}

	@GetMapping("/countofcabs/{carType}/{adminId}")
	public ResponseEntity<Integer> countCabsOfTypeHandler(@PathVariable("carType") String carType,
			@PathVariable("adminId") Integer adminId) throws CabException, AdminExceptions {
		Integer count = service.countCabsOfType(carType, adminId);
		return new ResponseEntity<Integer>(count, HttpStatus.OK);
	}

}
