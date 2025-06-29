package com.litmus7.vehiclerentalapp;

import java.util.List;
import java.util.Scanner;

import com.litmus7.vehiclerentalapp.controller.*;
import com.litmus7.vehiclerentalapp.dto.*;
import com.litmus7.vehiclerentalapp.response.Response;

/**
 * Main application class to run the Vehicle Rental App. Handles user
 * interactions through a console-based menu.
 */
public class VehicleApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // For reading user input
		VehicleController vehicleController = new VehicleController(); // Controller object to handle operations

		// Step 1: Load vehicle data from file at startup
		System.out.println("\nLoading Vehicle data:");
		List<Vehicle> vehicles; // List to hold loaded vehicle data
		Response loadResponse = vehicleController.handleDataLoadingFromFile(); // Call controller method to load data

		// Step 2: Check if loading was successful
		if (loadResponse.getStatusCode() != 0) {
			System.out.println("Error: " + loadResponse.getErrorMessage());
			System.out.println("Terminating ...");
			System.exit(1); // Exit program if file load fails
		} else {
			vehicles = loadResponse.getVehicles();
			System.out.println(vehicles); // Print all loaded vehicles
			System.out.println("\nVehicle data loaded successfully:");
		}

		// Step 3: Show total rental amount of rented vehicles
		vehicleController.handleTotalRentalPrice();

		// Step 4: Start interactive console menu
		while (true) {
			System.out.println("\n--- Vehicle Rental App ---\n");
			System.out.println("1. Rent a vehicle");
			System.out.println("2. Add a new vehicle");
			System.out.println("3. Search for a brand or a model");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt(); // Read numeric choice
			scanner.nextLine(); // Clear newline from input buffer

			// Step 5: Handle user menu choice
			switch (choice) {
			case 1:
				// Rent an available vehicle
				vehicleController.checkAvailability();
				break;

			case 2:
				// Add a new car or bike
				Response response = vehicleController.controlAddVehicle();

				// Check if addition was successful
				if (response.getStatusCode() != 0) {
					System.out.println("Error: " + response.getErrorMessage());
				} else {
					System.out.println("\n--- Proceeding to add Vehicle ---");
					List<Vehicle> updatedList = response.getVehicles();
					System.out.println("\n---Displaying updated Vehicle list---");
					System.out.println(updatedList);
				}
				break;

			case 3:
				// Search vehicles by brand or model
				System.out.println("\nEnter the brand or model you need to search:");
				String searchKey = scanner.nextLine();
				vehicleController.controlSearch(searchKey);
				break;

			case 4:
				// Exit the application
				System.out.println("Thank you for using the rental app!");
				scanner.close();
				return;

			default:
				// Invalid menu option
				System.out.println("Invalid choice.");
			}
		}
	}
}
