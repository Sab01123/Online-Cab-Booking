package com.cabBooking.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.exceptions.AdminExceptions;
import com.cabBooking.exceptions.CustomerNotFound;
import com.cabBooking.exceptions.TripBookingException;
import com.cabBooking.models.AdminCurrentSession;
import com.cabBooking.models.CurrentUserSession;
import com.cabBooking.models.Customer;
import com.cabBooking.models.Driver;
import com.cabBooking.models.TripBooking;
import com.cabBooking.repository.AdminCurrentSessionRepo;
import com.cabBooking.repository.CustomerRepository;
import com.cabBooking.repository.DriverRepository;
import com.cabBooking.repository.SessionDao;
import com.cabBooking.repository.TripBookingRepository;

@Service
public class ITripBookingServiceImpl implements ITripBookingService {

	@Autowired
	private SessionDao session;

	@Autowired
	private AdminCurrentSessionRepo adminRepo;

	@Autowired
	private CustomerRepository cRepo;

	@Autowired
	private DriverRepository dRepo;

	@Autowired
	private TripBookingRepository tbRepo;

	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking, Integer id)
			throws TripBookingException, CustomerNotFound {
		// TODO Auto-generated method stub

		boolean assigned = false;

		List<Driver> drivers = dRepo.findAll();

		for (Driver d : drivers) {

			Set<TripBooking> trips = d.getTripBooking();

			boolean flag = false;

			for (TripBooking tb : trips) {

				if ((tripBooking.getFromDateTime().isAfter(tb.getFromDateTime())
						&& tripBooking.getFromDateTime().isBefore(tb.getToDateTime()))
						|| (tripBooking.getToDateTime().isAfter(tb.getFromDateTime())
								&& tripBooking.getToDateTime().isBefore(tb.getToDateTime()))
						|| tripBooking.getFromDateTime().isEqual(tb.getFromDateTime())
						|| tripBooking.getToDateTime().isEqual(tb.getToDateTime())) {
					if (tripBooking.getFromDateTime().toLocalDate().equals(tb.getFromDateTime().toLocalDate())) {

						flag = true;
						break;
					}

				}

			}

			if (!flag) {
				assigned = true;
				Optional<Customer> cOpt = cRepo.findById(id);
				if (cOpt.isPresent()) {
					tripBooking.setCustomer(cOpt.get());
					d.getTripBooking().add(tripBooking);
					tripBooking.setDriver(d);
					break;

				}

				throw new CustomerNotFound("No customer exists with the id " + id);
			}

		}

		if (assigned) {

			return tbRepo.save(tripBooking);
		} else {
			throw new TripBookingException("No Driver is available in the time slot from "
					+ tripBooking.getFromDateTime().toLocalTime() + " to " + tripBooking.getToDateTime().toLocalTime()
					+ " on " + tripBooking.getFromDateTime().toLocalDate());
		}

	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking, Integer id)
			throws TripBookingException, CustomerNotFound {
		// TODO Auto-generated method stub

		Optional<TripBooking> opt = tbRepo.findById(tripBooking.getTripBookingId());

		if (opt.isPresent()) {
			Optional<Customer> cOpt = cRepo.findById(id);

			if (cOpt.isPresent()) {

				tripBooking.setCustomer(opt.get().getCustomer());
				tripBooking.setDriver(opt.get().getDriver());
				return tbRepo.save(tripBooking);
			}
			throw new CustomerNotFound("You are not logged in as Customer");
		}
		throw new TripBookingException("No trip is present with the id " + tripBooking.getTripBookingId());
	}

	@Override
	public TripBooking deleteTripBooking(int tripBookingId) throws TripBookingException, CustomerNotFound {
		// TODO Auto-generated method stub

		Optional<TripBooking> opt = tbRepo.findById(tripBookingId);
		TripBooking res = opt.get();
		if (opt.isPresent()) {
			Optional<CurrentUserSession> cOpt = session.findById(res.getCustomer().getCustomerId());
			if (cOpt.isPresent()) {
				Optional<Driver> optDriver = dRepo.findById(opt.get().getDriver().getDriverId());

				optDriver.get().getTripBooking().remove(opt.get());

				tbRepo.delete(res);

				return res;
			}
			throw new CustomerNotFound("Customer is not logged in");
		}

		else
			throw new TripBookingException("No trip exixts with this Id");
	}

	public Set<TripBooking> viewTripsWithTheDriverId(int driverId) {

		Optional<Driver> opt = dRepo.findById(driverId);

		return opt.get().getTripBooking();

	}

	@Override
	public List<TripBooking> viewAllTripsCustomer(Integer customerId, Integer id)
			throws CustomerNotFound, AdminExceptions {
		// TODO Auto-generated method stub
		Optional<Customer> opt = cRepo.findById(customerId);

		if (opt.isPresent()) {
			Optional<AdminCurrentSession> cOpt = adminRepo.findById(id);
			if (cOpt.isPresent()) {
//			List<TripBooking> trips = tbRepo.findAllTripsByCustomerId(customerId);

				Set<TripBooking> trips = opt.get().getTrips();

				List<TripBooking> res = new ArrayList<>(trips);
				return res;
			}
			throw new AdminExceptions("You are not logged in as admin");
		}

		throw new CustomerNotFound("No customer exists with the id " + customerId);
	}

	public List<TripBooking> calculateBill(int customerId) throws CustomerNotFound, TripBookingException {

		Optional<Customer> c = cRepo.findById(customerId);

		if (c.isPresent()) {

//			List<TripBooking> trips = tbRepo.findAllTripsByCustomerId(customerId);
			Optional<CurrentUserSession> opt = session.findById(customerId);
			if (opt.isPresent()) {
				Set<TripBooking> trips = cRepo.findById(customerId).get().getTrips();

				if (trips.size() != 0) {

					for (TripBooking tb : trips) {

						float bill = 0;
						if (tb.getDistanceInKm() > 2) {

							bill = (tb.getDistanceInKm() - 2) * tb.getDriver().getCab().getPerKmRate() + 25;
						} else {
							bill = 25;
						}
						tb.setBill(bill);
						tbRepo.save(tb);
					}

					return new ArrayList<>(trips);
				}
				throw new CustomerNotFound("Customer is not logged in");
			} else {
				throw new TripBookingException("No trip current trip is booked with the customer id " + customerId);
			}
		} else {
			throw new CustomerNotFound("No customer exists with the customer id " + customerId);
		}

	}
}
