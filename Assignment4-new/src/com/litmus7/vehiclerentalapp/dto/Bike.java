package com.litmus7.vehiclerentalapp.dto;

import java.util.Scanner;

/**
 * The Bike class extends the Vehicle class and adds bike-specific details such
 * as gear availability and engine capacity.
 */
public class Bike extends Vehicle {

	// Indicates whether the bike has gears
	private boolean hasGear;

	// Engine capacity of the bike in cc
	private int engineCapacity;

	/**
	 * Default constructor initializing the Bike with default values.
	 */
	public Bike() {
		setBrand("Suzuki");
		setModel("Gixxer");
		setRentalPricePerDay(600.0);
		setAvailable(true);
		hasGear = false;
		engineCapacity = 125;
	}

	/**
	 * Parameterized constructor to initialize a Bike object with specific details.
	 *
	 * @param brand             brand of the bike
	 * @param model             model of the bike
	 * @param rentalPricePerDay daily rental price
	 * @param available         availability status
	 * @param hasGear           whether the bike has gear
	 * @param engineCapacity    engine capacity in cc
	 */
	public Bike(String brand, String model, double rentalPricePerDay, boolean available, boolean hasGear,
			int engineCapacity) {
		super(brand, model, rentalPricePerDay, available);
		this.hasGear = hasGear;
		this.engineCapacity = engineCapacity;
	}

	/**
	 * Collects bike-specific details from the user such as gear and engine
	 * capacity. Overrides the inputDetails method from the Vehicle class.
	 */
	@Override
	public void inputDetails() {
		super.inputDetails(); // Collect common vehicle details
		Scanner scanner = new Scanner(System.in);

		System.out.println("Does it have gears (true/false)? : ");
		hasGear = scanner.nextBoolean();

		System.out.println("Enter engine capacity (cc) : ");
		engineCapacity = scanner.nextInt();
	}

	/**
	 * @return true if the bike has gears, false otherwise
	 */
	public boolean isHasGear() {
		return hasGear;
	}

	/**
	 * @return the engine capacity in cc
	 */
	public int getEngineCapacity() {
		return engineCapacity;
	}

	/**
	 * Returns a string representation of the bike's details, including inherited
	 * and bike-specific fields.
	 */
	@Override
	public String toString() {
		return "Bike [ Brand=" + getBrand() + ", Model=" + getModel() + ",RentalPricePerDay=" + getRentalPricePerDay()
				+ ", hasGear=" + hasGear + ", engineCapacity=" + engineCapacity + ", isAvailable=" + isAvailable()
				+ "]\n";
	}
}
