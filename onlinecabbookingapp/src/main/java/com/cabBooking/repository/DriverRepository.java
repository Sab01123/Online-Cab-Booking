package com.cabBooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cabBooking.models.Driver;
import com.cabBooking.models.DriverDTO;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

	@Query("select new com.cabBooking.models.DriverDTO(d.driverId,d.rating,d.username,d.mobileNumber) from Driver d where d.rating >= 4.5")
	public List<DriverDTO> getBestDrivers();

	@Query("select new com.cabBooking.models.DriverDTO(d.driverId,d.rating,d.username,d.mobileNumber) from Driver d where d.driverId = ?1 ")
	public DriverDTO getDriver(Integer driverID);

}