package com.cabBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cabBooking.models.Admin;


@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {

}
