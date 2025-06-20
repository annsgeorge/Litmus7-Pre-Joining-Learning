/**
 * 
 */
package com.litmus7.vehicledetails;

import java.util.Scanner;

/**
 * 
 */
public class Vehicle {

	protected String brand;
	protected String model;
	protected double rentalPricePerDay;

	public Vehicle() {

	}

	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}

	public void inputDetails() {
		System.out.println("Enter brand : ");
		Scanner scanner = new Scanner(System.in);
		String brand = scanner.nextLine();

		System.out.println("Enter model : ");
		String model = scanner.nextLine();

		System.out.println("Enter  rental price per day : ");
		double rentalPricePerDay = scanner.nextDouble();

	}

	public void displayDetails() {
		System.out.println("Brand :" + brand);
		System.out.println("Model : " + model);
		System.out.println("Rental Price/Day :" + rentalPricePerDay);

	}

}
