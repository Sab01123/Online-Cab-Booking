package com.cabBooking.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cabBooking.exceptions.AdminExceptions;
import com.cabBooking.models.Admin;
import com.cabBooking.models.Customer;
import com.cabBooking.models.TripBooking;
import com.cabBooking.repository.AdminDao;
import com.cabBooking.repository.CabDao;
import com.cabBooking.repository.CustomerRepository;
import com.cabBooking.repository.DriverRepository;
import com.cabBooking.repository.TripBookingRepository;

@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private CustomerRepository customerDao;

	@Autowired
	private DriverRepository driverDao;

	@Autowired
	private CabDao cabDao;

	@Autowired
	private TripBookingRepository tripDao;

	@Override
	public Admin insertAdmin(Admin admin) throws AdminExceptions {
		System.out.println(admin);
		return adminDao.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminExceptions {

		Optional<Admin> opt = adminDao.findById(admin.getAdminId());
		if (opt.isPresent()) {
			return adminDao.save(admin);
		}
		throw new AdminExceptions("Invalid Id");

	}

	@Override
	public Admin deleteAdmin(Integer id) throws AdminExceptions {
		Admin existingAdmin = adminDao.findById(id).orElseThrow(() -> new AdminExceptions("Invalid Id"));
		adminDao.delete(existingAdmin);

		return existingAdmin;
	}

	@Override // all trips detail of customer
	public List<TripBooking> getAllTrips(Integer customerid) throws AdminExceptions {
		// customer exception
		Optional<Customer> opt = customerDao.findById(customerid);
		if (opt.isPresent()) {
			List<TripBooking> trips = tripDao.findAll();
			return trips;

		}
		throw new AdminExceptions("Invalid Id");
	}

	@Override
	public List<TripBooking> getTripsCabwise()throws AdminExceptions {

		List<TripBooking> list = tripDao.findByDriverAscs();

		if (list.size() > 0)
			return list;
		else
			throw new AdminExceptions("No trips found");
	}

	@Override
	public List<TripBooking> getTripsCustomerwise()throws AdminExceptions {

		List<TripBooking> list = tripDao.findByCustomeridAsce();
		if (list.size() > 0)
			return list;
		else
			throw new AdminExceptions("No trips found");

	}

	@Override
	public List<TripBooking> getTripsDatewise() throws AdminExceptions {

		List<TripBooking> list = tripDao.findByFromdate_timeAsce();
		if (list.size() > 0)
			return list;
		else
			throw new AdminExceptions("No trips found");

	}

	@Override
	public List<TripBooking> getAllTripsForDays(Integer customerId, LocalDate date) throws AdminExceptions {

		List<TripBooking> list = tripDao.findByCustomerIdAndFromdate_time(customerId, date);
		if (list.size() > 0)
			return list;
		else
			throw new AdminExceptions("No trips found for customer id " + customerId + " and date : " + date);

	}
}
