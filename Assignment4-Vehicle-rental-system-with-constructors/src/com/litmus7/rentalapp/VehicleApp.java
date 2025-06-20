package com.litmus7.rentalapp;

import java.util.Scanner;
import com.litmus7.vehicledetails.*;

public class VehicleApp {

	public static void main(String[] args) {

		Car car = new Car();

		Bike bike = new Bike();

		car.inputDetails();
		System.out.println("\n---Displaying Car Details---");
		car.displayDetails();

		System.out.println("\nEnter bike details :");
		bike.inputDetails();
		System.out.println("\n---Displaying Bike Details---");
		bike.displayDetails();

		Car car1 = new Car();
		System.out.println("\nDisplaying car details(default) : ");
		car1.displayDetails();

		Bike bike1 = new Bike();
		System.out.println("\nDisplaying bike details(default) : ");
		bike1.displayDetails();
		Scanner scanner = new Scanner(System.in);

	}

}
