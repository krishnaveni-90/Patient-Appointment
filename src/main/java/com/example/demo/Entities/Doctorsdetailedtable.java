package com.example.demo.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="doctordetailedtable")
public class Doctorsdetailedtable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name="avl-day")
	private String avlday;
	@Column(name="avl-time")
	private String avltime;
	private String from;
	private String to;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvlday() {
		return avlday;
	}
	public void setAvlday(String avlday) {
		this.avlday = avlday;
	}
	public String getAvltime() {
		return avltime;
	}
	public void setAvltime(String avltime) {
		this.avltime = avltime;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	

}
