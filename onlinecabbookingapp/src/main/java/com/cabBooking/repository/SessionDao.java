package com.cabBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabBooking.models.CurrentUserSession;

public interface SessionDao extends JpaRepository<CurrentUserSession, Integer> {

	public CurrentUserSession findByUuid(String uuid);
}
