package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Car;
import com.example.demo.entity.User;
@Service
public class ServiceLayerImpl implements ServiceLayer {

@Autowired 
private UserDao userDao;


@Autowired
private CarDao carDao;
	
	
	@Override
	@Transactional
	public Car getcarbyid(int car) {
		// TODO Auto-generated method stub
		return carDao.getcarbyid(car);
	}


	@Override
	@Transactional
	public User getuser(int id) {
		// TODO Auto-generated method stub
		return userDao.getuser(id);
	}


	@Override
	@Transactional
	public void freecar(int id) {
		// TODO Auto-generated method stub
		User u= userDao.getuser(id);
		int carid= u.getCurrcar().getId();
		carDao.setcarnotbooked(carid);
		userDao.setcurrCar(id);
		
	}


	@Override
	@Transactional
	public void bookthiscarwiththisuser(int car, int userid) {
		// TODO Auto-generated method stub
		Car c= carDao.getcarbyid(car);
		carDao.setcarbooked(car);
		userDao.bookride(userid,c);
	}

}
