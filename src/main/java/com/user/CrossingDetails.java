package com.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="crossings")
public class CrossingDetails {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(name="CrossingName")
	private String CrossingName;
	
	@Column(name="CrossingStatus")
	private String CrossingStatus;
	
	@Column(name="PersonIncharge")
	private String PersonIncharge;
	
	@Column(name="TrainSchedule")
	private String TrainSchedule;
	
	@Column(name="Landmark")
	private String Landmark;
	
	@Column(name="Address")
	private String Address;
	
	CrossingDetails(){
		
	}
	
	
	public CrossingDetails(String crossingName, String crossingStatus, String personIncharge, String trainSchedule,
			String landmark, String address) {
		super();
		CrossingName = crossingName;
		CrossingStatus = crossingStatus;
		PersonIncharge = personIncharge;
		TrainSchedule = trainSchedule;
		Landmark = landmark;
		Address = address;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCrossingName() {
		return CrossingName;
	}
	public void setCrossingName(String crossingName) {
		CrossingName = crossingName;
	}
	public String getCrossingStatus() {
		return CrossingStatus;
	}
	public void setCrossingStatus(String crossingStatus) {
		CrossingStatus = crossingStatus;
	}
	public String getPersonIncharge() {
		return PersonIncharge;
	}
	public void setPersonIncharge(String personIncharge) {
		PersonIncharge = personIncharge;
	}
	public String getTrainSchedule() {
		return TrainSchedule;
	}
	public void setTrainSchedule(String trainSchedule) {
		TrainSchedule = trainSchedule;
	}
	public String getLandmark() {
		return Landmark;
	}
	public void setLandmark(String landmark) {
		Landmark = landmark;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
	
}
