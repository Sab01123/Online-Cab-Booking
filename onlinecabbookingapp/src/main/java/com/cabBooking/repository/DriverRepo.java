package com.cabBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabBooking.models.Driver;

public interface DriverRepo extends JpaRepository<Driver, Integer>{

}
