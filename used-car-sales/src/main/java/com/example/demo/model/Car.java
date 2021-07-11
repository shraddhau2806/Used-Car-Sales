package com.example.demo.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Car implements Comparable<Car> {

	private String model;
	private int year;
	private int kilometers;
	private String brand;
	private String staus;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String model, int year, int kilometers, String brand, String staus) {
		super();
		this.model = model;
		this.year = year;
		this.kilometers = kilometers;
		this.brand = brand;
		this.staus = staus;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getKilometer() {
		return kilometers;
	}
	public void setKilometer(int kilometers) {
		this.kilometers = kilometers;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getStaus() {
		return staus;
	}
	public void setStaus(String staus) {
		this.staus = staus;
	}
	@Override
	public String toString() {
		return "Car [model=" + model + ", year=" + year + ", kilometers=" + kilometers + ", brand=" + brand + ", staus="
				+ staus + "]";
	}
	@Override
	public int compareTo(Car o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
