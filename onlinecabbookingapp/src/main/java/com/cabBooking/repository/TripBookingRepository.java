package com.cabBooking.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cabBooking.models.TripBooking;

@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking, Integer> {

	@Query("from TripBooking where customerId=?1")
	public List<TripBooking> findAllTripsByCustomerId(int id);

	@Query("from TripBooking order by CustomerId")
	public List<TripBooking> findByCustomeridAsce();

	@Query("from TripBooking  order by fromdate_time")
	public List<TripBooking> findByFromdate_timeAsce();

	@Query("from TripBooking where CustomerId=:customerId AND Fromdate_time=:date")
	public List<TripBooking> findByCustomerIdAndFromdate_time(Integer customerId, LocalDate date);

	@Query("from TripBooking Group by driver_id ORDER by driver_id")
	public List<TripBooking> findByDriverAscs();

}
