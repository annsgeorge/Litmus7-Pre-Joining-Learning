package com.litmus7.vehiclerentalapp.service;

import com.litmus7.vehiclerentalapp.dao.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.litmus7.vehiclerentalapp.dto.Bike;
import com.litmus7.vehiclerentalapp.dto.Car;
import com.litmus7.vehiclerentalapp.dto.Vehicle;
import com.litmus7.vehiclerentalapp.exception.VehicleServiceException;

/**
 * Service layer class that contains business logic for vehicle rental
 * operations. Handles loading, adding, searching, and renting vehicles.
 */
public class VehicleService {

	// List of all vehicles (loaded from file or newly added)
	private List<Vehicle> vehicleList = new ArrayList<>();

	// List of available (not rented) vehicles for display/renting
	private List<Vehicle> availableList = new ArrayList<>();

	// Scanner object for user input
	Scanner scanner = new Scanner(System.in);

	// DAO object for file operations
	private VehicleDao dao = new VehicleDao();

	/**
	 * Loads vehicle data from a file using DAO.
	 * 
	 * @param filepath path to the file
	 * @return list of loaded vehicles
	 * @throws VehicleServiceException if an error occurs during loading
	 */
	public List<Vehicle> loadDataFromDao(String filepath) throws VehicleServiceException {
		try {
			vehicleList = dao.loadVehiclesFromFile(filepath);
			return vehicleList;
		} catch (VehicleServiceException e) {
			throw new VehicleServiceException("Error while accessing vehicle data", e);
		}
	}

	/**
	 * Adds a new vehicle (Car or Bike) via console input. Also persists updated
	 * list to file.
	 * 
	 * @throws VehicleServiceException if the type is invalid
	 */
	public void addVehicle() throws VehicleServiceException {
		System.out.println("Enter vehicle type to add Car/Bike :");
		String type = scanner.nextLine().trim();
		System.out.println("You entered -> " + type);

		if (type.equalsIgnoreCase("car")) {
			Car car = new Car();
			car.inputDetails(); // takes input from user
			vehicleList.add(car);
			dao.saveVehicleToFile(vehicleList, "vehicles.txt"); // save to file
		} else if (type.equalsIgnoreCase("bike")) {
			Bike bike = new Bike();
			bike.inputDetails();
			vehicleList.add(bike);
			dao.saveVehicleToFile(vehicleList, "vehicles.txt");
		} else {
			throw new VehicleServiceException("Invalid vehicle type entered", null);
		}

		System.out.println("Vehicle added successfully");
	}

	/**
	 * Searches the vehicle list by brand or model and prints matches.
	 * 
	 * @param searchKey the brand/model name to search
	 */
	public void searchVehicle(String searchKey) {
		boolean found = false;
		for (Vehicle v : vehicleList) {
			if (v.getBrand().equalsIgnoreCase(searchKey) || v.getModel().equalsIgnoreCase(searchKey)) {
				System.out.println(v);
				found = true;
			}
		}
		if (!found) {
			System.out.println("\nNo vehicle found for " + searchKey);
		}
	}

	/**
	 * Calculates the total rental price of all rented vehicles.
	 * 
	 * @return the total rental cost
	 */
	public double calculateTotalRentalPrice() {
		double total = 0;
		for (Vehicle v : vehicleList) {
			if (!v.isAvailable()) {
				total += v.getRentalPricePerDay();
			}
		}
		return total;
	}

	/**
	 * Displays all available vehicles and fills availableList.
	 * 
	 * @return true if no vehicles are available (all rented), false otherwise
	 */
	public boolean hasAvailableVehicles() {
		availableList.clear();
		boolean allRented = true;
		System.out.println("\nDetails of available vehicles:\n");
		int i = 1;
		for (Vehicle v : vehicleList) {
			if (v.isAvailable()) {
				availableList.add(v);
				System.out.print("[" + i + "] ");
				System.out.println(v);
				allRented = false;
				i++;
			}
		}
		return allRented;
	}

	/**
	 * Allows the user to rent a vehicle by selecting from the available list. Sets
	 * the selected vehicle as unavailable and calculates rent.
	 */
	public void rentVehicle() {
		try {
			System.out.println("\nChoose the number of the vehicle you want to rent:");
			int option = scanner.nextInt();
			scanner.nextLine(); // Clear buffer

			Vehicle selected = availableList.get(option - 1);

			System.out.println("\nSelect number of days to rent:");
			int days = scanner.nextInt();
			scanner.nextLine(); // Clear buffer

			if (days > 0) {
				selected.setAvailable(false); // mark as rented
				double totalRent = days * selected.getRentalPricePerDay();
				System.out.println(selected);
				System.out.println("Rental Days: " + days);
				System.out.println("Total Rent: ₹" + totalRent);
			} else {
				System.out.println("Invalid number of days.");
			}

		} catch (IndexOutOfBoundsException e) {
			System.out.println("Invalid option selected. Please choose a valid vehicle number.");
		} catch (Exception e) {
			System.out.println("Invalid input. Please enter a valid number.");
			scanner.nextLine(); // clear wrong input
		}
	}

	// Setter for vehicleList (used for external updates)
	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

	// Getter for vehicleList
	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}
}
