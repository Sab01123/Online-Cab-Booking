package com.cabBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabBooking.models.AdminCurrentSession;

public interface AdminCurrentSessionRepo extends JpaRepository<AdminCurrentSession, Integer>{

	public AdminCurrentSession findByAdminKey(String key);
	
}
