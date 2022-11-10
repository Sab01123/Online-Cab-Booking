package com.cabBooking.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.exceptions.TripBookingException;
import com.cabBooking.models.Driver;
import com.cabBooking.models.TripBooking;
import com.cabBooking.repository.TripBookingRepository;


@Service
public class ITripBookingServiceImpl implements ITripBookingService{

	
	
	@Autowired
	private TripBookingRepository tbRepo;
	
	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) throws TripBookingException {
		// TODO Auto-generated method stub
		
		Driver d = new Driver();
	   d.setLiscenceNo("sgggsadhddf");
	   d.setRating((float)5);
	   d.getTripBooking().add(tripBooking);
		
		tripBooking.setDriver(d);
		
		return tbRepo.save(tripBooking);
		
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripBookingException {
		// TODO Auto-generated method stub
		
		Optional<TripBooking> opt = tbRepo.findById(tripBooking.getTripBookingId());
		
		if(opt.isPresent()) {
			tripBooking.setDriver(opt.get().getDriver());
			return tbRepo.save(tripBooking);
		}
		throw new TripBookingException("No trip is present with the id "+tripBooking.getTripBookingId());
	}

	@Override
	public TripBooking deleteTripBooking(int tripBookingId) throws TripBookingException {
		// TODO Auto-generated method stub
		return null;
	}

}
