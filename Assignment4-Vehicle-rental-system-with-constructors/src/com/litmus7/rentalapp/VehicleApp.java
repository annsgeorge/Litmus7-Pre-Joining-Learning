package com.litmus7.rentalapp;

import java.util.Scanner;
import com.litmus7.vehicledetails.*;

/**
 * This class demonstrates creation of Car and Bike objects, input of their
 * details, and displays their information.
 * 
 */
public class VehicleApp {

	public static void main(String[] args) {

		// Creating a Car object and getting details from user
		Car car = new Car();
		car.inputDetails();
		System.out.println("\n---Displaying Car Details---");
		car.displayDetails();

		// Creating a Bike object and getting details from user
		Bike bike = new Bike();
		System.out.println("\nEnter bike details :");
		bike.inputDetails();
		System.out.println("\n---Displaying Bike Details---");
		bike.displayDetails();

		// Creating a Car object using default constructor and displaying default values
		Car car1 = new Car();
		System.out.println("\nDisplaying car details(default) : ");
		car1.displayDetails();

		// Creating a Bike object using default constructor and displaying default
		// values
		Bike bike1 = new Bike();
		System.out.println("\nDisplaying bike details(default) : ");
		bike1.displayDetails();

	}

}
