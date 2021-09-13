package com.example.demo.service;

import com.example.demo.entity.Car;

public interface CarDao {

	Car getcarbyid(int car);

	void setcarnotbooked(int carid);

	void setcarbooked(int car);

}
