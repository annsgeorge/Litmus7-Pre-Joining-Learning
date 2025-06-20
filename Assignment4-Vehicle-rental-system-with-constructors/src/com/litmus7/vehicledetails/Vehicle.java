package com.litmus7.vehicledetails;

import java.util.Scanner;

/**
 * This class contains basic details of the vehicle including brand,model,rental
 * price per day.
 */

public class Vehicle {

	protected String brand;
	protected String model;
	protected double rentalPricePerDay;

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

	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
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
		System.out.println("Brand :" + brand);
		System.out.println("Model : " + model);
		System.out.println("Rental Price/Day :" + rentalPricePerDay);

	}

}
