package com.cabBooking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.exceptions.AdminExceptions;
import com.cabBooking.exceptions.DriverException;
import com.cabBooking.models.AdminCurrentSession;
import com.cabBooking.models.Cab;
import com.cabBooking.models.Driver;
import com.cabBooking.models.DriverDTO;
import com.cabBooking.repository.AdminCurrentSessionRepo;
import com.cabBooking.repository.CabDao;
import com.cabBooking.repository.DriverRepository;
import com.cabBooking.repository.SessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class DriverServicesImpl implements DriverServices {

	@Autowired
	private DriverRepository dRepo;

	@Autowired
	private CabDao cabDao;

	@Autowired
	private AdminCurrentSessionRepo adminSession;

	@Override
	public Driver insertDriver(Driver driver, Integer adminId) throws DriverException, AdminExceptions {
		// TODO Auto-generated method stub

		Optional<AdminCurrentSession> opt = adminSession.findById(adminId);

		if (opt.isPresent()) {

			Boolean flag = false;
			List<Cab> cabs = cabDao.findAll();

			for (Cab i : cabs) {
				if (i.getCabType().toLowerCase().equals(driver.getCabType().toLowerCase())) {
					driver.setCab(i);
					i.getDrivers().add(driver);
					flag = true;
					break;
				}

			}

			if (!flag) {

				System.out.println(flag);
				System.out.println(driver);
				throw new DriverException("Failed To Add Driver");
			}

			driver.setLiscenceNo(RandomString.make(6));
			Driver savedDriver = dRepo.save(driver);

			return savedDriver;
		} else {
			throw new AdminExceptions("You Are Not Logged In As Admin");
		}
	}

	@Override
	public Driver updateDriver(Driver driver, Integer adminId) throws DriverException, AdminExceptions {
		// TODO Auto-generated method stub

		Optional<AdminCurrentSession> admin = adminSession.findById(adminId);

		if (admin.isPresent()) {

			Optional<Driver> opt = dRepo.findById(driver.getDriverId());
			if (opt.isPresent()) {
				Driver d = opt.get();
				driver.setCab(d.getCab());

				return dRepo.save(driver);

			} else {
				throw new DriverException("No Driver Found With Driver Id:-" + driver.getDriverId());
			}
		} else
			throw new AdminExceptions("You Are Not Logged In As Admin");

	}

	@Override
	public Driver deleteDriver(int driverID, Integer adminId) throws DriverException, AdminExceptions {
		// TODO Auto-generated method stub

		Optional<AdminCurrentSession> admin = adminSession.findById(adminId);

		if (admin.isPresent()) {

			Optional<Driver> opt = dRepo.findById(driverID);
			if (opt.isPresent()) {
				Driver driver = opt.get();
				dRepo.delete(driver);

				return driver;

			} else {
				throw new DriverException("No Driver Found With Driver Id:-" + driverID);
			}
		} else {
			throw new AdminExceptions("You Are Not Logged In As Admin");
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
	public DriverDTO viewDriver(int driverId, Integer adminId) throws DriverException, AdminExceptions {

		Optional<AdminCurrentSession> admin = adminSession.findById(adminId);

		if (admin.isPresent()) {

			DriverDTO driver = dRepo.getDriver(driverId);
			if (driver != null) {

				return driver;

			} else {
				throw new DriverException("No Driver Found With Driver Id:-" + driverId);
			}
		} else {
			throw new AdminExceptions("You Are Not Logged In As Admin");
		}

	}
//
//	public List<Driver> getDriversByCabId(Integer cabId) {
//
//		Optional<Cab> cab = cabDao.findById(cabId);
//
//		return cab.get().getDrivers();
//
//	}

}
