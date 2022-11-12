package com.cabBooking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.exceptions.CabException;
import com.cabBooking.models.Cab;
import com.cabBooking.repository.CabDao;
import com.cabBooking.repository.DriverRepository;

@Service
public class CabServiceImpl implements CabService {

	@Autowired
	private CabDao dao;
	@Autowired
	private DriverRepository dRepo;

	@Override
	public Cab insertCab(Cab cab) {

		if (cab != null)

			return dao.save(cab);
		else
			throw new IllegalArgumentException("Please provide correct cab details..");

	}

	@Override
	public Cab updateCab(Cab cab) throws CabException {

		Optional<Cab> opt = dao.findById(cab.getCabId());
		if (opt.isPresent())
			return dao.save(cab);

		else
			throw new CabException("Cab not found with id: " + cab.getCabId());
	}

	@Override
	public Cab deleteCab(Integer cabId) throws CabException {

		Optional<Cab> id = dao.findById(cabId);
		if (id.isPresent()) {

			Cab delCab = id.get();
			dao.delete(delCab);
			return delCab;
		} else
			throw new CabException("Cab not found with id: " + cabId);

	}

	@Override
	public List<Cab> viewCabsOfTypes(String carType) throws CabException {

		List<Cab> cabList = dao.findByCabType(carType);

		if (cabList.size() == 0)
			throw new CabException("Sorry, no Cabs found with type: " + carType);
		else

			return cabList;
	}

	@Override
	public int countCabsOfType(String carType) throws CabException {

		List<Cab> cabList = dao.findByCabType(carType);

		if (cabList.size() == 0)
			throw new CabException("Sorry, no number of Cabs found with type: " + carType);
		else

			return cabList.size();

	}
}
