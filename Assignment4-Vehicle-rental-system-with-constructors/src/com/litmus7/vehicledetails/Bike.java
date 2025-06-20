package com.litmus7.vehicledetails;

import java.util.Scanner;

public class Bike extends Vehicle {

	boolean hasGear;
	int engineCapacity;

	public Bike() {
		brand = "Suzuki";
		model = "Gixxer";
		rentalPricePerDay = 600.0;
		hasGear = false;
		engineCapacity = 125;

	}

	@Override
	public void inputDetails() {

		super.inputDetails();
		System.out.println(" Does it have gears(true/false)? : ");
		Scanner scanner = new Scanner(System.in);
		hasGear = scanner.nextBoolean();

		System.out.println(" Enter engine capacity (cc)  : ");
		engineCapacity = scanner.nextInt();

	}

	@Override
	public void displayDetails() {

		super.displayDetails();
		System.out.println("Has Gear : " + hasGear);
		System.out.println("Engine Capacity : " + engineCapacity);
	}

}
