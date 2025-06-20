package com.litmus7.vehicledetails;

import java.util.Scanner;

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
		brand = "Suzuki";
		model = "Gixxer";
		rentalPricePerDay = 600.0;
		hasGear = false;
		engineCapacity = 125;

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

		super.displayDetails();
		System.out.println("Has Gear : " + hasGear);
		System.out.println("Engine Capacity : " + engineCapacity);
	}

}
