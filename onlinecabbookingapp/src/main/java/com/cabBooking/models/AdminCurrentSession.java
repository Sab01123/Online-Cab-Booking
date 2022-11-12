package com.cabBooking.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminCurrentSession {

	@Id
	@Column(unique = true)
	private Integer adminId;

	private String adminKey;

	private LocalDateTime sessionStarted;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminKey() {
		return adminKey;
	}

	public void setAdminKey(String adminKey) {
		this.adminKey = adminKey;
	}

	public LocalDateTime getSessionStarted() {
		return sessionStarted;
	}

	public void setSessionStarted(LocalDateTime sessionStarted) {
		this.sessionStarted = sessionStarted;
	}

	public AdminCurrentSession(Integer adminId, String adminKey, LocalDateTime sessionStarted) {
		super();
		this.adminId = adminId;
		this.adminKey = adminKey;
		this.sessionStarted = sessionStarted;
	}

	public AdminCurrentSession() {
		// TODO Auto-generated constructor stub
	}

}