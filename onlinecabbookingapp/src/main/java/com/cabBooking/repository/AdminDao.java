package com.cabBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cabBooking.models.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {

//	@Query("from Admin  where mobileNumber =?1")
//	public Admin getByMobileNumber(String mobileNo);

}
