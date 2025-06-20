package com.litmus7.vehicledetails;

import java.util.Scanner;

/**
 * The Car class extends the Vehicle class and adds specific attributes like
 * number of doors and whether the car is automatic.
 * 
 */
public class Car extends Vehicle {

	int numberOfDoors;
	boolean isAutomatic;

	/**
	 * Default constructor initializes car with default values.
	 */
	public Car() {
		brand = "Honda";
		model = "Civic";
		rentalPricePerDay = 140.0;
		numberOfDoors = 4;
		isAutomatic = false;

	}

	/**
	 * Parameterized constructor to initialize a Car object with specific details.
	 * 
	 * @param brand
	 * @param model
	 * @param rentalPricePerDay
	 * @param numberOfDoors
	 * @param isAutomatic
	 */

	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;

	}

	/**
	 * This method overrides the Vehicle's inputDetails method. It collects
	 * car-specific details from the user.
	 * 
	 */
	@Override
	public void inputDetails() {
		System.out.println("\nEnter car details :");
		super.inputDetails();
		System.out.println(" Enter number of doors : ");
		Scanner scanner = new Scanner(System.in);
		numberOfDoors = scanner.nextInt();
		scanner.nextLine();
		System.out.println(" Is it automatic (true/false )?  : ");
		isAutomatic = scanner.nextBoolean();

	}

	/**
	 * This method overrides the Vehicle's displayDetails method.
	 */

	@Override
	public void displayDetails() {

		super.displayDetails();
		System.out.println("Number of doors : " + numberOfDoors);
		System.out.println("Automatic : " + isAutomatic);

	}

}
