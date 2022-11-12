package com.cabBooking.services;

import java.util.List;

import com.cabBooking.exceptions.CabException;
import com.cabBooking.models.Cab;

public interface CabService {

	public Cab insertCab(Cab cab);

	public Cab updateCab(Cab cab) throws CabException;

	public Cab deleteCab(Integer cabId) throws CabException;

	public List<Cab> viewCabsOfTypes(String carType) throws CabException;

	public int countCabsOfType(String carType) throws CabException;

}