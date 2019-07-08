package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity //to use relation with other tables
@Table(name="CarTable") //to create table automatically
public class Car {

	@Id //value will be unique
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID") //ID column will be in table
	private int id;
	
	@NotNull
	@Column(name="Engine")
	private String engine;
	
	@NotNull
	@Column(name="Speed")
	private double speed;
	
	@NotNull
	@Column(name="Year")
	private int year;
	
	@NotNull
	@Column(name="Color")
	private String color;
	
	
	public Car() {
	}
	
	public Car(String engine, double speed, int year, String color) {
		setEngine(engine);
		setSpeed(speed);
		setYear(year);
		setColor(color);
		//setID();
	}
	
	public int getID() {
		return id;
	}
	
	/*
	public void setID() {
		this.id = idCounter;
		idCounter++;
	}
	*/

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		if (speed >= 0 && speed < 301)
			this.speed = speed;
		else
			this.speed = 50;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year > 1960 && year < 2020)
			this.year = year;
		else {
			/*
			 * Date date = new Date(); NOT WORK IN JAVA 11 (laikam)
			 */

			this.year = 2000;
			;
		}
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if (color != null) {
			boolean isOnlyLetters = false;
			for (int i = 0; i < color.length(); i++) {
				if (Character.isLetter(color.charAt(i)))
					isOnlyLetters = true;
				else {
					isOnlyLetters = false;
					break;
				}
			}
			if (isOnlyLetters)
				this.color = color;
			else
				this.color = "inputerror";
		}
	}

	@Override
	public String toString() {
		return "engine = " + engine + ", speed = " + speed + ", year = " + year + ", color = " + color + ", ID = " + id;
	}
	
	

}
