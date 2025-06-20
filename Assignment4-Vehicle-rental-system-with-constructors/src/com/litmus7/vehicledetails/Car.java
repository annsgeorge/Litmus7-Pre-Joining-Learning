/**
 * 
 */
package com.litmus7.vehicledetails;

import java.util.Scanner;

/**
* 
*/
public class Car extends Vehicle {

	int numberOfDoors;
	boolean isAutomatic;

	/**
	 * 
	 */
	public Car() {
		brand = "Honda";
		model = "Civic";
		rentalPricePerDay = 140.0;
		numberOfDoors = 4;
		isAutomatic = false;

	}

	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;

	}

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

	@Override
	public void displayDetails() {

		super.displayDetails();
		System.out.println("Number of doors : " + numberOfDoors);
		System.out.println("Automatic : " + isAutomatic);

	}

}
