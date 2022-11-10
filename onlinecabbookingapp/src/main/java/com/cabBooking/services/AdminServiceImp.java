package com.cabBooking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cabBooking.models.Admin;
import com.cabBooking.repository.AdminDao;

@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin saveAdmin(Admin admin) {

		return adminDao.save(admin);
	}

	@Override
	public Admin update(Admin admin) {

		return admin ;
	}

	@Override
	public Admin delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}
