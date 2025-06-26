package com.litmus7.rentalvehicle.dto;

import java.util.Scanner;

import com.litmus7.rentalvehicle.dto.*;

/**
 * The Bike class extends the Vehicle class and adds bike-specific details such
 * as gear availability and engine capacity.
 * 
 */
public class Bike extends Vehicle {

	boolean hasGear;
	int engineCapacity;

	/**
	 * Default constructor initializing the Bike with default values.
	 */
	public Bike() {
		setBrand("Suzuki");
		setModel("Gixxer");
		setRentalPricePerDay(600.0);
		setAvailable(false);
		hasGear = false;
		engineCapacity = 125;

	}

	/**
	 * 
	 * Parameterized constructor to initialize a BIke object with specific details.
	 * 
	 * @param brand
	 * @param model
	 * @param rentalPricePerDay
	 * @param available
	 * 
	 *
	 */
	public Bike(String brand, String model, double rentalPricePerDay, boolean available, boolean hasGear,
			int engineCapacity) {
		super(brand, model, rentalPricePerDay, available);
		this.hasGear = hasGear;
		this.engineCapacity = engineCapacity;
	}

	/**
	 * Overrides Vehicle's inputDetails method to include bike-specific inputs.
	 * Collects information from the user about gear and engine capacity.
	 * 
	 */

	@Override
	public void inputDetails() {

		super.inputDetails();
		System.out.println(" Does it have gears(true/false)? : ");
		Scanner scanner = new Scanner(System.in);
		hasGear = scanner.nextBoolean();

		System.out.println(" Enter engine capacity (cc)  : ");
		engineCapacity = scanner.nextInt();

	}

	/**
	 * Overrides Vehicle's displayDetails method to include bike-specific details.
	 */

	@Override
	public void displayDetails() {
		// System.out.println("\nRental Bike Details");
		super.displayDetails();
		System.out.println("Has Gear : " + hasGear);
		System.out.println("Engine Capacity : " + engineCapacity);
	}

}
