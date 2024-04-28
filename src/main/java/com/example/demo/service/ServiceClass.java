package com.example.demo.service;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.DoctorAvailability;
import com.example.demo.Entities.Doctors;
import com.example.demo.Entities.Doctorsdetailedtable;
import com.example.demo.repository.DoctorAvlRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.DoctorsDetailedRepository;

@Service
public class ServiceClass {

	@Autowired
	DoctorRepository repo;

	@Autowired
	DoctorsDetailedRepository repository;

	@Autowired
	DoctorAvlRepository avlrepo;

	public List<Doctors> getData() {
		List<Doctors> list = new ArrayList<Doctors>();
		repo.findAll().forEach(Doctors -> list.add(Doctors));
		return list;
	}

	public Doctors getDoctorData(int doctor_id) {
		Doctors doctors = repo.findById(doctor_id).get();
		return doctors;
	}

	public List<Doctorsdetailedtable> getDoctorsDetailedData() {
		List<Doctorsdetailedtable> list = new ArrayList<Doctorsdetailedtable>();
		repository.findAll().forEach(Doctorsdetailedtable -> list.add(Doctorsdetailedtable));
		return list;
	}
	
	public Doctorsdetailedtable getDoctorDetailedData(int id) {
		Doctorsdetailedtable doctorsdetailedtable = repository.findById(id).get();
		return doctorsdetailedtable;
		
	}

	public DoctorAvailability getAvailablilityData(int d_id) {
		DoctorAvailability doctorAvailability = avlrepo.findById(d_id).get();
		return doctorAvailability;

	}

	public String getBookingData(int id, String date, String time) throws ParseException {
		LocalDate date1 = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalTime time1 = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm:ss"));
       
        if (date1.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return "Not available on Sundays";
        }
        
        int hour = time1.getHour();
        int minute = time1.getMinute();
        
        if (hour == 18 && minute >= 0 && minute < 60) {
            
            return checkAvailability(id, "Slot6_7PM");
        } else if (hour == 19 && minute >= 0 && minute < 60) {
            
            return checkAvailability(id, "Slot7_8PM");
        } else if (hour == 20 && minute >= 0 && minute < 60) {
            
            return checkAvailability(id, "Slot8_9PM");
        } else if (hour == 21 && minute >= 0 && minute < 60) {
            
            return checkAvailability(id, "Slot9_10PM");
        } else {
            
            return "invalid time";
        }
	}
	private String checkAvailability(int id, String timeSlot) {
           
            DoctorAvailability doctorAvailability = avlrepo.findById(id).orElse(null);
            if (doctorAvailability == null) {
                
                return "doctor availability data not found";
            }

            
            switch (timeSlot) {
                case "Slot6_7PM":
                    if (doctorAvailability.getSlot6_7PM() > 0) {
                        
                        return "available";
                    } else {
                       
                        return "not available";
                    }
                case "Slot7_8PM":
                    if (doctorAvailability.getSlot7_8PM() > 0) {
                        
                        return "available";
                    } else {
                        
                        return "not available";
                    }
                case "Slot8_9PM":
                    if (doctorAvailability.getSlot8_9PM() > 0) {
                        
                        return "available";
                    } else {
                        
                        return "not available";
                    }
                case "Slot9_10PM":
                    if (doctorAvailability.getSlot9_10PM() > 0) {
                        
                        return "available";
                    } else {
                        
                        return "not available";
                    }
                default:
                    
                    return "invalid time slot";
            }
	}
}
        

