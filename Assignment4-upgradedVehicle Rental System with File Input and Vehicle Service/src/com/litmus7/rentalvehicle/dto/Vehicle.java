package com.litmus7.rentalvehicle.dto;

import java.util.Scanner;

/**
 * This class contains basic details of the vehicle including brand,model,rental
 * price per day.
 */

public class Vehicle {

	private String brand;
	protected String model;
	protected double rentalPricePerDay;
	protected boolean available;

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
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
		this.available = available;
	}

	/**
	 * Method to input vehicle details from the user
	 */
	public void inputDetails() {
		System.out.println("Enter brand : ");
		Scanner scanner = new Scanner(System.in);
		String brand = scanner.nextLine();

		System.out.println("Enter model : ");
		String model = scanner.nextLine();

		System.out.println("Enter  rental price per day : ");
		double rentalPricePerDay = scanner.nextDouble();

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
	 * @return the model
	 */
	public String getModel() {
		return model;
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