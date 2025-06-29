package com.litmus7.vehiclerentalapp.dto;

import java.util.Scanner;

/**
 * The Car class extends the abstract Vehicle class and includes additional
 * attributes specific to cars, such as number of doors and transmission type.
 */
public class Car extends Vehicle {

	// Number of doors in the car
	private int numberOfDoors;

	// Indicates whether the car has automatic transmission
	private boolean isAutomatic;

	/**
	 * Default constructor initializes a Car with default values.
	 */
	public Car() {
		setBrand("Honda");
		setModel("Civic");
		setRentalPricePerDay(140.0);
		setAvailable(true);
		numberOfDoors = 4;
		isAutomatic = false;
	}

	/**
	 * Parameterized constructor to create a Car with specific details.
	 *
	 * @param brand             the brand of the car
	 * @param model             the model name
	 * @param rentalPricePerDay daily rental price
	 * @param available         whether the car is available
	 * @param numberOfDoors     number of doors in the car
	 * @param isAutomatic       whether the car has automatic transmission
	 */
	public Car(String brand, String model, double rentalPricePerDay, boolean available, int numberOfDoors,
			boolean isAutomatic) {
		super(brand, model, rentalPricePerDay, available);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;
	}

	/**
	 * Reads car-specific input from the user including number of doors and
	 * transmission type.
	 */
	@Override
	public void inputDetails() {
		System.out.println("\nEnter car details:");
		super.inputDetails(); // Input common vehicle details
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of doors: ");
		numberOfDoors = scanner.nextInt();

		System.out.print("Is it automatic (true/false)? ");
		isAutomatic = scanner.nextBoolean();
	}

	/**
	 * Returns the number of doors.
	 */
	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	/**
	 * Returns true if the car has automatic transmission.
	 */
	public boolean isAutomatic() {
		return isAutomatic;
	}

	/**
	 * Returns a formatted string representing the car details.
	 */
	@Override
	public String toString() {
		return "Car [ Brand=" + getBrand() + ", Model=" + getModel() + ", RentalPricePerDay=" + getRentalPricePerDay()
				+ ", numberOfDoors=" + numberOfDoors + ", isAutomatic=" + isAutomatic + ", isAvailable=" + isAvailable()
				+ "]\n";
	}
}
