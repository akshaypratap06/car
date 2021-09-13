package com.example.demo.service;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Car;
import com.example.demo.entity.User;
@Repository
public class UserDaoImpl implements UserDao {

	
	@Autowired
	private EntityManager em;
	
	@Override
	public User getuser(int id) {
		// TODO Auto-generated method stub
		Session s= em.unwrap(Session.class);
		User u= null;
		try
		{
			u=s.find(User.class, id);
		}
		catch(Exception c)
		{
			u=null;
		}
		return u;
	}

	@Override
	public void setcurrCar(int id) {
		// TODO Auto-generated method stub
		Session s= em.unwrap(Session.class);
		User u= s.find(User.class, id);
		u.setCurrcar(null);
		
	}

	@Override
	public void bookride(int userid, Car c) {
		// TODO Auto-generated method stub
		Session s= em.unwrap(Session.class);
		User u =s.find(User.class, userid);
		u.setCurrcar(c);
		u.getCars().add(c);
	}

}
