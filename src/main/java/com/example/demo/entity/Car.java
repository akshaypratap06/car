package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="car")
public class Car {

	
	@Override
	public String toString() {
		return "Car [id=" + id + ", carnumber=" + carnumber + ", booked=" + booked + ", user=" + user + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="carnumber")
	private String carnumber;
	
	@Column(name="booked")
	private int booked;
	
	@OneToOne(mappedBy="currcar")
	private User user;

	public Car(String carnumber, int booked, User user) {
		super();
		this.carnumber = carnumber;
		this.booked = booked;
		this.user = user;
	}

	public Car() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public int getBooked() {
		return booked;
	}

	public void setBooked(int booked) {
		this.booked = booked;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
