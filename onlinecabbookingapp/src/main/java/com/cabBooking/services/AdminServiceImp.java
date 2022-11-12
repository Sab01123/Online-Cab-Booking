package com.cabBooking.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cabBooking.exceptions.AdminExceptions;
import com.cabBooking.exceptions.CustomerNotFound;
import com.cabBooking.exceptions.TripBookingException;
import com.cabBooking.models.Admin;
import com.cabBooking.models.AdminCurrentSession;
import com.cabBooking.models.AdminDTO;
import com.cabBooking.models.Cab;
import com.cabBooking.models.Customer;
import com.cabBooking.models.Driver;
import com.cabBooking.models.TripBooking;
import com.cabBooking.repository.AdminCurrentSessionRepo;
import com.cabBooking.repository.AdminDao;
import com.cabBooking.repository.CabDao;
import com.cabBooking.repository.CustomerRepository;
import com.cabBooking.repository.DriverRepository;
import com.cabBooking.repository.TripBookingRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private DriverRepository driverRepo;

	@Autowired
	private CabDao cabDao;

	@Autowired
	private TripBookingRepository tripRepo;

	@Autowired
	private AdminCurrentSessionRepo adminSessionRepo;

	@Override
	public AdminCurrentSession LoginAdmin(AdminDTO admin) throws AdminExceptions {

		Admin a = adminDao.findByUsername(admin.getUsername());

		if (a != null) {
			Optional<AdminCurrentSession> opt = adminSessionRepo.findById(a.getAdminId());

			if (opt.isPresent()) {
				throw new AdminExceptions(admin.getUsername() + " is already logged in");
			}
			if (admin.getPassword().equals(a.getPassword())) {

				AdminCurrentSession acs = new AdminCurrentSession(a.getAdminId(),
						admin.getUsername() + RandomString.make(6), LocalDateTime.now());

				return adminSessionRepo.save(acs);

			}

			throw new AdminExceptions("Admin password is wrong");
		}
		throw new AdminExceptions(admin.getUsername() + " is not an admin");

//		return null;

	}

	@Override
	public Admin insertAdmin(Admin admin, String key) throws AdminExceptions {

		if (adminSessionRepo.findByAdminKey(key) != null) {

			if (adminDao.findByUsername(admin.getUsername()) == null) {

				return adminDao.save(admin);
			} else {
				throw new AdminExceptions("Admin with username " + admin.getUsername() + " already exists");
			}

		}

		throw new AdminExceptions("No current admin session exixts with the key " + key);

	}

	@Override
	public Admin updateAdmin(Admin admin, String key) throws AdminExceptions {

		if (adminSessionRepo.findByAdminKey(key) != null) {

			Optional<Admin> opt = adminDao.findById(admin.getAdminId());
			if (opt.isPresent()) {

				List<Admin> admins = adminDao.findAll();

				for (Admin a : admins) {

					if (a.getAdminId() != admin.getAdminId()
							&& a.getUsername().toLowerCase().equals(admin.getUsername().toLowerCase())) {

						throw new AdminExceptions(
								"Admin with same username " + admin.getUsername() + " already exists");

					}

				}

				return adminDao.save(admin);

			}

			throw new AdminExceptions("No admin exists with this Id");
		}
		throw new AdminExceptions("No admin current session exists with the key " + key);

	}

	@Override
	public Admin deleteAdmin(Integer id, String key) throws AdminExceptions {

		if (adminSessionRepo.findByAdminKey(key) != null) {
			Optional<Admin> opt = adminDao.findById(id);

			if (opt.isPresent()) {

				Admin res = opt.get();

				adminDao.delete(opt.get());

				return res;

			}
			throw new AdminExceptions("No Admin Exists with the id " + id);
		}
		throw new AdminExceptions("No current session of admin exixts with the key " + key);

	}

	@Override
	public List<TripBooking> getAllTrips(String key) throws AdminExceptions {

		if (adminSessionRepo.findByAdminKey(key) != null) {

			List<TripBooking> trips = tripRepo.findAll();

			if (trips.size() != 0) {

				return trips;

			}
			throw new AdminExceptions("No trip is booked");

		}
		throw new AdminExceptions("No current session of admin exixts with the key " + key);
	}

	@Override
	public List<TripBooking> getTripsCabwise(String cabType, String key) throws TripBookingException, AdminExceptions {

		if (adminSessionRepo.findByAdminKey(key) != null) {

			List<Cab> cabs = cabDao.findByCabType(cabType.toLowerCase());

			List<TripBooking> res = new ArrayList<>();

			for (Cab c : cabs) {

				List<Driver> drivers = c.getDrivers();

				for (Driver d : drivers) {

					Set<TripBooking> trips = d.getTripBooking();

					for (TripBooking tb : trips) {
						res.add(tb);
					}
				}
			}

			if (res.size() == 0) {
				throw new TripBookingException("No trips present with the cab type " + cabType);
			}
			return res;
		}

		throw new AdminExceptions("No current session of admin exixts with the key " + key);
	}

	@Override
	public List<TripBooking> getTripsCustomerwise(Integer customerId, String key)
			throws CustomerNotFound, AdminExceptions {

		if (adminSessionRepo.findByAdminKey(key) != null) {

			Optional<Customer> opt = customerRepo.findById(customerId);

			if (opt.isPresent()) {

				return new ArrayList<>(opt.get().getTrips());

			}
			throw new CustomerNotFound("No customer found with id " + customerId);
		}

		throw new AdminExceptions("No current session of admin exixts with the key " + key);

	}

	@Override
	public List<TripBooking> getTripsDatewise(LocalDate date, String key) throws AdminExceptions, TripBookingException {

		if (adminSessionRepo.findByAdminKey(key) != null) {

			List<TripBooking> trips = tripRepo.findAll();

			List<TripBooking> res = new ArrayList<>();

			for (TripBooking tb : trips) {

				if (tb.getFromDateTime().toLocalDate().isEqual(date)) {

					res.add(tb);

				}

			}

			if (res.size() != 0) {
				return res;
			}
			throw new TripBookingException("No trip is booked on " + date);

		}

		throw new AdminExceptions("No current session of admin exixts with the key " + key);
	}

	@Override
	public List<TripBooking> getAllTripsForDays(Integer customerId, LocalDate date, String key)
			throws AdminExceptions, TripBookingException {
		// TODO Auto-generated method stub

		if (adminSessionRepo.findByAdminKey(key) != null) {

			List<TripBooking> trips = tripRepo.findAllTripsByCustomerId(customerId);
			List<TripBooking> res = new ArrayList<>();

			for (TripBooking tb : trips) {

				if (tb.getFromDateTime().toLocalDate().isEqual(date)) {
					res.add(tb);
				}

			}

			if (res.size() != 0) {
				return res;
			}
			throw new TripBookingException("No trip found on " + date + " for customer with customer id " + customerId);
		}

		throw new AdminExceptions("No current session of admin exixts with the key " + key);
	}

}