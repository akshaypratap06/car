package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Car;
import com.example.demo.entity.User;
import com.example.demo.service.ServiceLayer;

@RestController
public class DemoController {
	
	@Autowired
	private ServiceLayer sl;

	@PostMapping("/book/{car}/{user}/{x1}/{y1}/{x2}/{y2}")
	public String book(@PathVariable("car") int car,@PathVariable("user") int userid,@PathVariable("x1") int x1,
			@PathVariable("x2") int x2,@PathVariable("y1") int y1,@PathVariable("y2") int y2)
	{ System.out.println(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)));
		if(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))>3)
		{
			return "too much distance";
		}
		Car c= sl.getcarbyid(car);
		if( c== null || c.getBooked()==1)
		{
			return "Already Booked";
		}
		User u= sl.getuser(userid);
		if(u==null || u.getCurrcar()!=null)
		{
			return "user already riding";
		}
		sl.bookthiscarwiththisuser(car,userid);
		return "booked";
	}
	
	
	@GetMapping("/pre/{id}")
	public Collection<Car> pre(@PathVariable("id") int id)
	{
		User u= sl.getuser(id);
		if(u==null || u.getCars().size()==0)
		{
			return new ArrayList<>();
		}
		return u.getCars();
	}
	
	@PutMapping("/end/{id}")
	public String end(@PathVariable("id") int id)
	{
		User u= sl.getuser(id);
		if(u==null || u.getCurrcar()==null)
		{
			return "No ride";
		}
		else {
			sl.freecar(id);
			return "ended";
		}
	}
}
