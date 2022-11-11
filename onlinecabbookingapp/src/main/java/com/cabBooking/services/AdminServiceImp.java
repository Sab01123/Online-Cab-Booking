package com.cabBooking.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cabBooking.exceptions.AdminExceptions;
import com.cabBooking.models.Admin;
import com.cabBooking.models.TripBooking;
import com.cabBooking.repository.AdminDao;


@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin LoginAdmin(Admin admin) throws AdminExceptions {
		
		/*
		Optional<Admin> opt = adminDao.findById(admin.getUserId());
		if (opt.isPresent()) {
			// Admin existAdmin = opt.get();
			return adminDao.save(admin);
		}
		throw new AdminExceptions("Invalid Id");
		*/
		return null;
		
	}
	
	/*
	  @Autowired private CustomerDao customerDao;
	  
	  @Autowired private DriverDao driverDao;
	  
	  @Autowired private CabDao cabDao;
	 
	  @Autowired private TripDao tripDao;
	 */
	@Override
	public Admin insertAdmin(Admin admin) throws AdminExceptions {
		System.out.println(admin);
		return adminDao.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminExceptions {
		/*
		Optional<Admin> opt = adminDao.findById(admin.getUserId());
		if (opt.isPresent()) {
			// Admin existAdmin = opt.get();
			return adminDao.save(admin);
		}
		throw new AdminExceptions("Invalid Id");
		*/
		return null;
		
	}

	@Override
	public Admin deleteAdmin(Integer id) throws AdminExceptions {
		Admin existingAdmin = adminDao.findById(id).orElseThrow(() -> new AdminExceptions("Invalid Id"));
		adminDao.delete(existingAdmin);

		return existingAdmin;
	}

	@Override
	public List<TripBooking> getAllTrips(Integer customerid) throws AdminExceptions {

		/*
		  // customer exception Optional<Customer> opt =
		  customerDao.findById(customerid); if (opt.isPresent()) { List<TripBooking>
		  trips = tripDao.findAll(); return trips;
		  
		  } throw new AdminExceptions("Invalid Id");
		  
		 */
		return null;
	}

	@Override
	public List<TripBooking> getTripsCabwise() {
	/*
		List<TripBooking> list = tripDao.findByCabAscs();

		if (list.size() > 0)
			return list;
		else
			throw new AdminExceptions("No trips found");
     */
		return null;
	}

	@Override
	public List<TripBooking> getTripsCustomerwise() {
	
		/*
		List<TripBooking> list = tripDao.findByCustomeridAsce();
		if (list.size() > 0)
			return list;
		else
			throw new AdminExceptions("No trips found");
		*/
		
		return null;
	}

	@Override
	public List<TripBooking> getTripsDatewise() throws AdminExceptions {

        /*
         List<TripBooking> list = tripDao.findByFromdate_timeAsce();
		if (list.size() > 0)
			return list;
		else
			throw new AdminExceptions("No trips found");
                 
         */
         
		return null;
	}

	@Override
	public List<TripBooking> getAllTripsForDays(Integer customerId, LocalDate date) throws AdminExceptions {
	
		/*
		List<TripBooking> list = tripDao.findByCustomerIdAndFromdate_time(customerId, date);
		if (list.size() > 0)
			return list;
		else
			throw new AdminExceptions("No trips found for customer id " + customerId + " and date : " + date);
		*/
		
		return null;
	}
}
