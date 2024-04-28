package com.example.demo.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.DoctorAvailability;
import com.example.demo.Entities.Doctors;
import com.example.demo.Entities.Doctorsdetailedtable;
import com.example.demo.service.ServiceClass;

@RestController
public class ControllerClass {
	
	@Autowired
	ServiceClass service;
	
	
	//Doctors list(Basic Information)(1)
	@GetMapping("/doctors")
	public List<Doctors> getDoctorsData(){
		
		return service.getData();	
	}
	
	@GetMapping("/doctors/{doctor_id}")
	public Doctors getDoctorInfo(@PathVariable int doctor_id) {
		return service.getDoctorData(doctor_id);
	}
	
	@GetMapping("/doctors-details")
	public List<Doctorsdetailedtable> getDoctorsdetailedinfo(){
		return service.getDoctorsDetailedData();
	}
	
	//Particular doctor detailed data(complete information)(2)
	@GetMapping("/doctor-details/{id}")
	public Doctorsdetailedtable getDoctorDetails(@PathVariable int id) {
		return service.getDoctorDetailedData(id);
		
	}
	
	
	//Availability of particular doctor to book a slot
	@GetMapping("/availability/{d_id}")
	public DoctorAvailability getAvlData(@PathVariable int d_id) {
		return service.getAvailablilityData(d_id);
		
	}
	
	
	//Slot booking with particular doctor
	@GetMapping("/booking/{id}")
	public String getBooking(@PathVariable int id,@RequestParam(name="date" ,required=true) String date,@RequestParam(name="time" ,required=true) String time) throws ParseException {
		System.out.println("In controller....");
		 String bookingData = service.getBookingData(id,date,time);
		return bookingData;
	}

}
