package com.litmus7.vehiclerentalapp;

import java.util.Scanner;
import com.litmus7.vehicleservices.*;

/**
 * Main application class to run the Vehicle Rental App. Handles user
 * interactions through a console-based menu.
 */
public class VehicleApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Create a service object that handles all vehicle operations
		VehicleService service = new VehicleService();

		// Load initial vehicle data from file
		System.out.println("\nVehicle data loaded from file:");
		service.loadVehiclesFromFile();

		// Display all vehicles from file
		service.printFileData();

		// Display the total rental price
		service.totalRentalPrice();

		// Start the main menu loop
		while (true) {
			System.out.println("\n--- Vehicle Rental App ---\n");
			System.out.println("1. View available vehicles");
			System.out.println("2. Rent a vehicle");
			System.out.println("3. Add a new vehicle");
			System.out.println("4. Search for a brand or a model");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt(); // Read user choice
			scanner.nextLine(); // Clear input buffer

			// Perform action based on user choice
			switch (choice) {
			case 1:
				service.availableVehicles(); // Show not rented vehicles
				break;
			case 2:
				service.rentVehicle(); // Rent a selected vehicle
				break;
			case 3:
				System.out.println("\n--- Proceeding to add Vehicle ---");
				service.addVehicle(); // Add new car or bike
				break;
			case 4:
				service.searchVehicle(); // Search by brand/model name
				break;
			case 5:
				System.out.println("Thank you for using the rental app!");
				return; // Exit the program
			default:
				System.out.println("Invalid choice."); // Handle incorrect input
			}
		}
	}
}
