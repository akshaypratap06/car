package com.example.demo.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="user")
public class User {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="name")
		private String name;
		
		@Column(name="email")
		private String email;
		
		@OneToOne(cascade={CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch=FetchType.EAGER)
		@JoinColumn(name="ccurrcar")
		private Car currcar;
		
		@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch=FetchType.EAGER)
		@JoinTable(name="usercar",joinColumns=@JoinColumn(name="userid"),inverseJoinColumns=@JoinColumn(name="carid"))
		Collection<Car> cars;
		
	
		

		

		public User() {
			super();
		}



		public User(String name, String email, Car car, Collection<Car> cars) {
			super();
			this.name = name;
			this.email = email;
			this.currcar = car;
			this.cars = cars;
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public Car getCurrcar() {
			return currcar;
		}



		public void setCurrcar(Car currcar) {
			this.currcar = currcar;
		}



		public Collection<Car> getCars() {
			return cars;
		}



		public void setCars(Collection<Car> cars) {
			this.cars = cars;
		}



		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", email=" + email + ", currcar=" + currcar + ", cars=" + cars
					+ "]";
		}



		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		

		

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}


		
		
		
		
	

	
}
