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

import com.cabBooking.exceptions.CabException;
import com.cabBooking.models.Cab;
import com.cabBooking.services.CabServiceImpl;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
public class CabController {

	@Autowired
	private	CabServiceImpl service;



	@PostMapping("/cab")
	public ResponseEntity<Cab> RegisterCabHandler(@RequestBody Cab cab){

		Cab insertCab = service.insertCab(cab);


		return  new ResponseEntity<Cab>(insertCab, HttpStatus.CREATED);
	}

	@PutMapping("/cab")
	public ResponseEntity<Cab> updateCabHandler(@RequestBody Cab cab) throws CabException{

		Cab updateCab = service.updateCab(cab);


		return new ResponseEntity<Cab>(updateCab, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/cab/{cId}")
	public ResponseEntity<Cab> deleteCabHandler(@PathVariable("cId") Integer cabId) throws CabException{

		Cab deleteCab = service.deleteCab(cabId);

		return new ResponseEntity<Cab>(deleteCab, HttpStatus.OK);
	}

	@GetMapping("/cabs/{carType}")
	public ResponseEntity<List<Cab>> viewCabsOfTypesHandler(@PathVariable("carType") String carType) throws CabException {

		List<Cab> viewCabsOfTypes = service.viewCabsOfTypes(carType);

		return new ResponseEntity<List<Cab>>(viewCabsOfTypes, HttpStatus.OK);
	}

	@GetMapping("/countofcabs/{carType}")
	public ResponseEntity<Integer> countCabsOfTypeHandler(@PathVariable("carType") String carType) throws CabException {
		Integer count = service.countCabsOfType(carType);
		return new ResponseEntity<Integer>(count, HttpStatus.OK);
	}


}
