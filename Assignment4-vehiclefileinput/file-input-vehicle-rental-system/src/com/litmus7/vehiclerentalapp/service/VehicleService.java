package com.litmus7.vehiclerentalapp.service;

import com.litmus7.vehiclerentalapp.dao.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.litmus7.vehiclerentalapp.dto.Bike;
import com.litmus7.vehiclerentalapp.dto.Car;
import com.litmus7.vehiclerentalapp.dto.Vehicle;
import com.litmus7.vehiclerentalapp.exception.VehicleDataAccessException;

/**
 * Service layer class that contains business logic for vehicle rental
 * operations. Handles loading, adding, searching, and renting vehicles.
 */
public class VehicleService {

	// Stores all vehicles loaded from file or added manually
	private List<Vehicle> vehicleList = new ArrayList<>();

	// Stores vehicles currently available for rent
	private List<Vehicle> availableVehicleList = new ArrayList<>();

	// Data Access Object for reading/writing to file
	private VehicleDao dao = new VehicleDao();

	/**
	 * Loads vehicle data from the specified file using the DAO.
	 *
	 * @param filepath the path to the data file
	 * @return the list of loaded vehicles
	 * @throws VehicleDataAccessException if the file is not accessible or valid
	 */
	public List<Vehicle> loadDataFromDao(String filepath) throws VehicleDataAccessException {
		try {
			// Delegates loading logic to DAO
			vehicleList = dao.loadVehiclesFromFile(filepath);
			return vehicleList;
		} catch (VehicleDataAccessException e) {
			// Wraps and rethrows exception with meaningful message
			throw new VehicleDataAccessException("Error while accessing vehicle data", e);
		}
	}

	/**
	 * Adds a new vehicle object to the list if not a duplicate, then saves the
	 * updated list to the file.
	 *
	 * @param v        the new vehicle to add
	 * @param filePath file to which list is saved after addition
	 * @return updated vehicle list
	 * @throws VehicleDataAccessException if vehicle is already present
	 */
	public List<Vehicle> addVehicle(Vehicle v, String filePath) throws VehicleDataAccessException {
		if (!vehicleList.contains(v)) {
			vehicleList.add(v); // Add only if not already present
			dao.saveVehicleToFile(vehicleList, filePath); // Save updated list to file
			return vehicleList;
		} else {
			throw new VehicleDataAccessException("Vehicle already present ");
		}
	}

	/**
	 * Searches for vehicles that match the given brand or model.
	 *
	 * @param searchKey keyword to search in brand/model
	 * @return list of matching vehicles
	 */
	public List<Vehicle> searchVehicle(String searchKey) {
		List<Vehicle> searchResultList = new ArrayList<>();
		for (Vehicle v : vehicleList) {
			// Match against both brand and model names (case-insensitive)
			if (v.getBrand().equalsIgnoreCase(searchKey) || v.getModel().equalsIgnoreCase(searchKey)) {
				searchResultList.add(v);
			}
		}
		return searchResultList;
	}

	/**
	 * Calculates the total rental cost of all currently rented vehicles.
	 *
	 * @return total cost of all rented vehicles
	 */
	public double calculateTotalRentalPrice() {
		double total = 0;
		for (Vehicle v : vehicleList) {
			if (!v.isAvailable()) {
				total += v.getRentalPricePerDay(); // Add price if vehicle is rented
			}
		}
		return total;
	}

	/**
	 * Collects and prints all available (not rented) vehicles. Builds a list that
	 * can be used for renting.
	 *
	 * @return list of available vehicles
	 */
	public List<Vehicle> availableVehicleList() {
		boolean rented = true;
		System.out.println("\nDetails of available vehicles:\n");
		int i = 1;
		for (Vehicle v : vehicleList) {
			if (v.isAvailable()) {
				availableVehicleList.add(v); // Only add available vehicles
				System.out.print("[" + i + "] ");
				System.out.println(v); // Print vehicle info
				rented = false;
				i++;
			}
		}
		return availableVehicleList;
	}
}
