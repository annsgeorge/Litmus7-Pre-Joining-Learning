package com.litmus7.vehiclerentalapp.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.litmus7.vehiclerentalapp.controller.*;
import com.litmus7.vehiclerentalapp.dto.*;

/**
 * Main application class to run the Vehicle Rental App. Handles user
 * interactions through a console-based menu.
 */
public class VehicleApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // For reading user input
		VehicleController vehicleController = new VehicleController(); // Controller object to handle operations

		// Step 1: Load vehicle data from file at startup
		List<Vehicle> vehicles; // List to hold loaded vehicle data
		Response<List<Vehicle>> loadResponse = vehicleController.LoadDataFromFile(); // Call controller method to load data

		// Step 2: Check if loading was successful
		if (loadResponse.getStatusCode() != 0) {
			// If file loading failed, print error and exit
			System.out.println("Error: " + loadResponse.getErrorMessage());
			System.out.println("Terminating ...");
			System.exit(1);
		} else {
			// If successful, print the loaded vehicles
			vehicles =loadResponse.getData();
			System.out.println(vehicles);
			System.out.println("\nVehicle data loaded successfully:");
		}

		// Step 3: Display total rental cost of currently rented vehicles
		double total;
		Response<Double> getTotalRentResponse =vehicleController.getTotalRentalPrice();
		if(getTotalRentResponse.getStatusCode() !=0) {
			System.out.println(getTotalRentResponse.getErrorMessage());
		}
		else {
			total=getTotalRentResponse.getData();
			System.out.println("\nTotal Rental Amount: " + total);
		}
		// Step 4: Display interactive menu in a loop
		while (true) {
			System.out.println("\n--- Vehicle Rental App ---\n");
			System.out.println("1. Rent a vehicle");
			System.out.println("2. Add a new vehicle");
			System.out.println("3. Search for a brand or a model");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt(); // Read numeric menu choice
			scanner.nextLine(); // Clear newline from buffer

			// Step 5: Handle user choice
			switch (choice) {
			case 1:
				// Handle renting a vehicle
				Response<List<Vehicle>> rentResponse = vehicleController.checkAvailability();
				if (rentResponse.getStatusCode() != 0) {
					System.out.println("Error :" + rentResponse.getErrorMessage());
				} else {
					// If available vehicles exist, list and prompt user to select
					List<Vehicle> availableVehicleList =rentResponse.getData();
					System.out.println("\nChoose the number of the vehicle you want to rent:");
					int option = scanner.nextInt();
					scanner.nextLine(); // Clear buffer

					if (option > 0 && availableVehicleList.size() >= option) {
						Vehicle selected = availableVehicleList.get(option - 1);

						// Ask for number of rental days
						System.out.println("\nSelect number of days to rent:");
						int days = scanner.nextInt();
						scanner.nextLine(); // Clear buffer

						if (days > 0) {
							// Calculate total rent and display details
							selected.setAvailable(false); // Mark vehicle as rented
							double totalRent = days * selected.getRentalPricePerDay();
							System.out.println(selected);
							System.out.println("Rental Days: " + days);
							System.out.println("Total Rent: Rs " + totalRent);
							System.out.println("Vehicle Rented Successfully");
						} else {
							System.out.println("Invalid number of days.");
						}
					} else {
						System.out.println("Invalid number");
					}
				}
				break;

			case 2:
				Car car = new Car("Kia", "Sonet", 1300.0, true, 4, true);
				Response<List<Vehicle>> response = vehicleController.addVehicle(car);

				// Display status of the operation
				if (response.getStatusCode() != 0) {
					System.out.println("Error: " + response.getErrorMessage());
				} else {
					System.out.println("\n--- Proceeding to add Vehicle ---");
					List<Vehicle> updatedVehicleList ;
					updatedVehicleList=response.getData();
					System.out.println("\nVehicle added successfully");
					System.out.println("\n---Displaying updated Vehicle list---");
					System.out.println(updatedVehicleList);
				}
				break;

			case 3:
				// Search vehicles by brand or model
				System.out.println("\nEnter the brand or model you need to search:");
				String searchKey = scanner.nextLine();
				Response<List<Vehicle>> searchResponse = vehicleController.searchVehicle(searchKey);

				// Show search results or error
				if (searchResponse.getStatusCode() != 0) {
					System.out.println("Error : " + searchResponse.getErrorMessage());
				} else {
					System.out.println("\nYour search list:");
					List<Vehicle> searchResultList =searchResponse.getData();
					System.out.println(searchResultList);
				}
				break;

				
			case 4:
				// Exit the application
				System.out.println("Thank you for using the rental app!");
				scanner.close();
				return;

			default:
				// Handle invalid option
				System.out.println("Invalid choice.");
			}
		}
	}
}
