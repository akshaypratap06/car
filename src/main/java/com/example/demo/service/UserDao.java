package com.example.demo.service;

import com.example.demo.entity.Car;
import com.example.demo.entity.User;

public interface UserDao {

	User getuser(int id);

	void setcurrCar(int id);

	void bookride(int userid, Car c);

}
