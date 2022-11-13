package com.cabBooking.services;

import java.util.List;

import com.cabBooking.exceptions.AdminExceptions;
import com.cabBooking.exceptions.CabException;
import com.cabBooking.models.Cab;

public interface CabService {

	public Cab insertCab(Cab cab, Integer adminId) throws AdminExceptions;

	public Cab updateCab(Cab cab, Integer adminId) throws CabException, AdminExceptions;

	public Cab deleteCab(Integer cabId, Integer adminId) throws CabException, AdminExceptions;

	public List<Cab> viewCabsOfTypes(String carType, Integer adminId) throws CabException, AdminExceptions;

	public List<Cab> countTotalNoOfCabs(Integer adminId) throws CabException, AdminExceptions;

}
