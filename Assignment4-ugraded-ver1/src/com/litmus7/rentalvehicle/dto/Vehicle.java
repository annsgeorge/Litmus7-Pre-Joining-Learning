package com.litmus7.rentalvehicle.dto;

import java.util.Scanner;

/**
 * This class contains basic details of the vehicle including brand,model,rental
 * price per day.
 */

public class Vehicle {

	private String brand;
	private String model;
	private double rentalPricePerDay;
	private boolean available;

	/**
	 * default constructor
	 */
	public Vehicle() {

	}

	/**
	 * parameterized constructor to initialize vehicle details
	 * 
	 * @param brand
	 * @param model
	 * @param rentalPricePerDay
	 */

	public Vehicle(String brand, String model, double rentalPricePerDay, boolean available) {
		this.setBrand(brand);
		this.setModel(model);
		this.setRentalPricePerDay(rentalPricePerDay);
		this.available = available;
	}


	/**
	 * Method to input vehicle details from the user
	 */
	public void inputDetails() {
		System.out.println("Enter brand : ");
		Scanner scanner = new Scanner(System.in);
		setBrand(scanner.nextLine());

		System.out.println("Enter model : ");
		setModel(scanner.nextLine());

		System.out.println("Enter  rental price per day : ");
		setRentalPricePerDay (scanner.nextDouble());

	}

	/**
	 * Method to display the vehicle details
	 */
	public void displayDetails() {
		System.out.println("Brand :" + getBrand());
		System.out.println("Model : " + model);
		System.out.println("Rental Price/Day :" + rentalPricePerDay);
		// System.out.println("Available :" + available);
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param rentalPricePerDay the rentalPricePerDay to set
	 */
	public void setRentalPricePerDay(double rentalPricePerDay) {
		this.rentalPricePerDay = rentalPricePerDay;
	}

	/**
	 * @return the rentalPricePerDay
	 */
	public double getRentalPricePerDay() {
		return rentalPricePerDay;
	}

	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return available;
	}

}