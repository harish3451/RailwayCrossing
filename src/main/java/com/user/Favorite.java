package com.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="favorite")
public class Favorite {

	
	@Id
	@Column(name="user_id")
	private int user_id;

	@Id
	@Column(name="crossing_id")
	private int crossing_id;
	
	Favorite(){
		
	}
	public Favorite(int uid, int cid) {
		this.user_id=uid;
		this.crossing_id=cid;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCrossing_id() {
		return crossing_id;
	}
	public void setCrossing_id(int crossing_id) {
		this.crossing_id = crossing_id;
	}
	
	
}
