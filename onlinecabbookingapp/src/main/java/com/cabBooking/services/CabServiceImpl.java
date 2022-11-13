package com.cabBooking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.exceptions.AdminExceptions;
import com.cabBooking.exceptions.CabException;
import com.cabBooking.models.AdminCurrentSession;
import com.cabBooking.models.Cab;
import com.cabBooking.repository.AdminCurrentSessionRepo;
import com.cabBooking.repository.CabDao;
import com.cabBooking.repository.DriverRepository;

@Service
public class CabServiceImpl implements CabService {

	@Autowired
	private CabDao dao;
	@Autowired
	private DriverRepository dRepo;

	@Autowired
	private AdminCurrentSessionRepo adminSession;

	@Override
	public Cab insertCab(Cab cab, Integer adminId) throws AdminExceptions {
		Optional<AdminCurrentSession> opt = adminSession.findById(adminId);

		if (opt.isPresent()) {

			if (cab != null)

				return dao.save(cab);
			else
				throw new IllegalArgumentException("Please provide correct cab details..");
		}
		throw new AdminExceptions("You are not logged in as Admin");
	}

	@Override
	public Cab updateCab(Cab cab, Integer adminId) throws CabException, AdminExceptions {

		Optional<AdminCurrentSession> aOpt = adminSession.findById(adminId);

		if (aOpt.isPresent()) {
			Optional<Cab> opt = dao.findById(cab.getCabId());

			if (opt.isPresent())
				return dao.save(cab);

			else
				throw new CabException("Cab not found with id: " + cab.getCabId());
		}
		throw new AdminExceptions("You are not logged in as Admin");
	}

	@Override
	public Cab deleteCab(Integer cabId, Integer adminId) throws CabException, AdminExceptions {

		Optional<AdminCurrentSession> opt = adminSession.findById(adminId);
		if (opt.isPresent()) {

			Optional<Cab> id = dao.findById(cabId);
			if (id.isPresent()) {

				Cab delCab = id.get();
				dao.delete(delCab);
				return delCab;
			} else
				throw new CabException("Cab not found with id: " + cabId);
		}
		throw new AdminExceptions("You are not logged in as Admin");

	}

	@Override
	public List<Cab> viewCabsOfTypes(String carType, Integer adminId) throws CabException, AdminExceptions {

		Optional<AdminCurrentSession> opt = adminSession.findById(adminId);

		if (opt.isPresent()) {

			List<Cab> cabList = dao.findByCabType(carType);

			if (cabList.size() == 0)
				throw new CabException("Sorry, no Cabs found with type: " + carType);
			else

				return cabList;
		}
		throw new AdminExceptions("You are not logged in as Admin");

	}

	@Override
	public int countCabsOfType(String carType, Integer adminId) throws CabException, AdminExceptions {

		Optional<AdminCurrentSession> opt = adminSession.findById(adminId);

		if (opt.isPresent()) {

			List<Cab> cabList = dao.findByCabType(carType);

			if (cabList.size() == 0)
				throw new CabException("Sorry, no number of Cabs found with type: " + carType);
			else

				return cabList.size();
		}
		throw new AdminExceptions("You are not logged in as Admin");

	}
}
