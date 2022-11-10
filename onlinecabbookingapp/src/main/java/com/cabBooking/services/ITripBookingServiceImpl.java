package com.cabBooking.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBooking.exceptions.CustomerNotFound;
import com.cabBooking.exceptions.TripBookingException;
import com.cabBooking.models.Customer;
import com.cabBooking.models.Driver;
import com.cabBooking.models.TripBooking;
import com.cabBooking.repository.CustomerRepository;
import com.cabBooking.repository.DriverRepo;
import com.cabBooking.repository.TripBookingRepository;


@Service
public class ITripBookingServiceImpl implements ITripBookingService{

	
	@Autowired
	private CustomerRepository cRepo;
	
	@Autowired
	private DriverRepo dRepo;
	
	@Autowired
	private TripBookingRepository tbRepo;
	
	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) throws TripBookingException {
		// TODO Auto-generated method stub
		
		
	  boolean assigned = false;	
	
	  List<Driver> drivers = dRepo.findAll();
	  
	  for(Driver d:drivers) {
		  
		  Set<TripBooking> trips = d.getTripBooking();
		  
		  boolean flag = false;
		  
		  for(TripBooking tb:trips) {
			  
			  
			 

				if((tripBooking.getFromDateTime().isAfter(tb.getFromDateTime()) && tripBooking.getFromDateTime().isBefore(tb.getToDateTime())) || (tripBooking.getToDateTime().isAfter(tb.getFromDateTime()) && tripBooking.getToDateTime().isBefore(tb.getToDateTime()))) {
				  if(tripBooking.getFromDateTime().toLocalDate().equals(tb.getFromDateTime().toLocalDate())) {
					
					flag = true;  
					break;
				}
				
			  }
			  
		  }
		  
		  if(!flag) {
			  assigned = true;
			  
			  d.getTripBooking().add(tripBooking);
			  tripBooking.setDriver(d);
			  break;
		  }
		  
	  }
		
	  
	  if(assigned) {
		  
		  return tbRepo.save(tripBooking);
	  }else {
		  throw new TripBookingException("No Driver is available in the time slot from "+tripBooking.getFromDateTime().toLocalTime()+" to "+tripBooking.getToDateTime().toLocalTime()+" on "+tripBooking.getFromDateTime().toLocalDate());
	  }
		
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
		
		Optional<TripBooking> opt = tbRepo.findById(tripBookingId);
		TripBooking res = opt.get();
				if(opt.isPresent()) {
			
			Optional<Driver> optDriver = dRepo.findById(opt.get().getDriver().getDriverId());
			
			optDriver.get().getTripBooking().remove(opt.get());
			
			tbRepo.delete(res);
			
			return res;
		}
		
		else throw new TripBookingException("No trip exixts with this Id");
	}
	
	
	
	
	public Set<TripBooking> viewTripsWithTheDriverId(int driverId){
		
		Optional<Driver> opt = dRepo.findById(driverId);
		
		return opt.get().getTripBooking();
		
	}

	
	
	
	@Override
	public List<TripBooking> viewAllTripsCustomer(int customerId) throws CustomerNotFound {
		// TODO Auto-generated method stub
		Optional<Customer> opt = cRepo.findById(customerId);
		
		if(opt.isPresent()) {
			
			List<TripBooking> trips = tbRepo.findAllTripsByCustomerId(customerId);
			
			return trips;
			
		}
		
		throw new CustomerNotFound("No customer exists with the id "+customerId);
	}

	
	
	public List<TripBooking> calculateBill(int customerId) throws CustomerNotFound, TripBookingException {
		
		Optional<Customer> c = cRepo.findById(customerId);
		
		if(c.isPresent()) {
			
			List<TripBooking> trips = tbRepo.findAllTripsByCustomerId(customerId);
			
			if(trips.size()!=0) {
				
				for(TripBooking tb:trips) {
					if(tb.getToDateTime().isBefore(LocalDateTime.now())) {
				
						float bill = 0;
						if(tb.getDistanceInKm()>2) {
							
							bill =  (tb.getDistanceInKm() - 2) * 8 + 25;
						}else {
							bill = 25;
						}
						tb.setBill(bill);
					}
					}
				
				return trips;
			}
			else {
				throw new TripBookingException("No trip current trip is booked with the customer id "+customerId);
			}
		}
		else {
			throw new CustomerNotFound("No customer exists with the customer id "+customerId);
		}
		
	}
}
