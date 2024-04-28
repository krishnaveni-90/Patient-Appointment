package com.example.demo.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="doctoravailability")
public class DoctorAvailability {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="6:00-7:00PM")
	private int slot6_7PM;
	
	@Column(name="7:00-8:00PM")
	private int slot7_8PM;
	
	@Column(name="8:00-9:00PM")
	private int slot8_9PM;
	
	@Column(name="9:00-10:00PM")
	private int slot9_10PM;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSlot6_7PM() {
		return slot6_7PM;
	}

	public void setSlot6_7PM(int slot6_7pm) {
		slot6_7PM = slot6_7pm;
	}

	public int getSlot7_8PM() {
		return slot7_8PM;
	}

	public void setSlot7_8PM(int slot7_8pm) {
		slot7_8PM = slot7_8pm;
	}

	public int getSlot8_9PM() {
		return slot8_9PM;
	}

	public void setSlot8_9PM(int slot8_9pm) {
		slot8_9PM = slot8_9pm;
	}

	public int getSlot9_10PM() {
		return slot9_10PM;
	}

	public void setSlot9_10PM(int slot9_10pm) {
		slot9_10PM = slot9_10pm;
	}

	@Override
	public String toString() {
		return "DoctorAvailability [id=" + id + ", slot6_7PM=" + slot6_7PM + ", slot7_8PM=" + slot7_8PM + ", slot8_9PM="
				+ slot8_9PM + ", slot9_10PM=" + slot9_10PM + "]";
	}
	
	

	
	
	
	

}
