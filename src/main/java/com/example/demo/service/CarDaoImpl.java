package com.example.demo.service;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Car;
@Repository
public class CarDaoImpl implements CarDao {

	@Autowired
	private EntityManager em;
	
	@Override
	public Car getcarbyid(int car) {
		// TODO Auto-generated method stub
		
		Session s= em.unwrap(Session.class);
		Car c=null;
		try {
			c= s.find(Car.class, car);
		}
		catch(Exception cs)
		{
			c=null;
		}
		return c;
	}

	@Override
	public void setcarnotbooked(int carid) {
		// TODO Auto-generated method stub
		Session s= em.unwrap(Session.class);
		Car c= s.find(Car.class, carid);
		c.setBooked(0);
		
	}

	@Override
	public void setcarbooked(int car) {
		// TODO Auto-generated method stub
		Session s= em.unwrap(Session.class);
		Car c= s.find(Car.class, car);
		c.setBooked(1);
		
	}

}
