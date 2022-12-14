package com.cabBooking.models;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

@PrimaryKeyJoinColumn(name = "adminId")
public class Admin extends AbstractUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;

	public Integer getAdminId() {
		return adminId;
	}

	public Admin(Integer adminId) {
		super();
		this.adminId = adminId;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

}
