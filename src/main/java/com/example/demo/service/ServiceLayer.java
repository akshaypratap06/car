package com.example.demo.service;

import com.example.demo.entity.Car;
import com.example.demo.entity.User;

public interface ServiceLayer {

	Car getcarbyid(int car);

	User getuser(int id);

	void freecar(int id);

	void bookthiscarwiththisuser(int car, int userid);

}
