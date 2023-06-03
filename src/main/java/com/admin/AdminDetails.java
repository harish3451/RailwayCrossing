package com.admin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admindetails")
public class AdminDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="password")
	private String password;

	
	public AdminDetails() {
		
	}
	
	
	public AdminDetails(String mail, String password) {
		this.mail = mail;
		this.password = password;
	}

	public int getId() {
		return this.id;
	}
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
