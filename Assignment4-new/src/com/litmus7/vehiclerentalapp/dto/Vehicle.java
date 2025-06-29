package com.litmus7.vehiclerentalapp.dto;

import java.util.Scanner;

/**
 * The Vehicle class is the base class for all types of vehicles. It contains
 * basic attributes such as brand, model, rental price per day, and
 * availability. This class provides getters and setters, input functionality,
 * and a formatted string representation.
 */
public class Vehicle {

	// Brand of the vehicle
	private String brand;

	// Model name of the vehicle
	private String model;

	// Rental price per day for the vehicle
	private double rentalPricePerDay;

	// Availability status of the vehicle
	private boolean available;

	/**
	 * Default constructor. Initializes an empty vehicle object.
	 */
	public Vehicle() {
		// No initialization required
	}

	/**
	 * Parameterized constructor to initialize a vehicle with specific details.
	 *
	 * @param brand             the brand of the vehicle
	 * @param model             the model of the vehicle
	 * @param rentalPricePerDay the daily rental price
	 * @param available         availability status
	 */
	public Vehicle(String brand, String model, double rentalPricePerDay, boolean available) {
		this.setBrand(brand);
		this.setModel(model);
		this.setRentalPricePerDay(rentalPricePerDay);
		this.available = available;
	}

	/**
	 * Prompts the user to enter the basic vehicle details: brand, model, and price.
	 * This method uses the Scanner class to read user input.
	 */
	public void inputDetails() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter brand : ");
		setBrand(scanner.nextLine());

		System.out.println("Enter model : ");
		setModel(scanner.nextLine());

		System.out.println("Enter rental price per day : ");
		setRentalPricePerDay(scanner.nextDouble());
	}

	// Setter for availability
	public void setAvailable(boolean available) {
		this.available = available;
	}

	// Setter for brand
	public void setBrand(String brand) {
		this.brand = brand;
	}

	// Getter for brand
	public String getBrand() {
		return brand;
	}

	// Setter for model
	public void setModel(String model) {
		this.model = model;
	}

	// Getter for model
	public String getModel() {
		return model;
	}

	// Setter for rental price per day
	public void setRentalPricePerDay(double rentalPricePerDay) {
		this.rentalPricePerDay = rentalPricePerDay;
	}

	// Getter for rental price per day
	public double getRentalPricePerDay() {
		return rentalPricePerDay;
	}

	// Getter for availability
	public boolean isAvailable() {
		return available;
	}

	/**
	 * Returns a string representation of the vehicle object.
	 *
	 * @return formatted string of vehicle details
	 */
	@Override
	public String toString() {
		return "Vehicle [brand=" + brand + ", model=" + model + ", rentalPricePerDay=" + rentalPricePerDay
				+ ", available=" + available + ",]\n";
	}
}
