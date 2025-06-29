package com.litmus7.vehiclerentalapp.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerentalapp.response.*;
import com.litmus7.vehiclerentalapp.dto.Vehicle;
import com.litmus7.vehiclerentalapp.exception.VehicleServiceException;
import com.litmus7.vehiclerentalapp.service.VehicleService;

/**
 * Controller class that acts as a bridge between the main application and the
 * service layer. Handles business logic and exception wrapping.
 */
public class VehicleController {

	// File path to load vehicle data
	public static final String VEHICLE_FILE = "src.vehicles.txt";

	// Custom status codes for response
	private static final int SUCCESS_STATUS_CODE = 0;
	private static final int ERROR_STATUS_CODE = 500;

	// Service layer object that does core operations
	VehicleService vehicleService = new VehicleService();

	/**
	 * Loads vehicle data from a file using the service layer. Handles file not
	 * found, empty file, and service exceptions.
	 * 
	 * @return Response object containing status, data or error message.
	 */
	public Response handleDataLoadingFromFile() {
		Response response = new Response();
		File file = new File(VEHICLE_FILE);

		// Check if file exists and is not empty
		if (!file.exists() || file.length() == 0) {
			System.out.println("File missing or empty.");
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("The file is " + VEHICLE_FILE + " missing or empty.");
			response.setVehicles(new ArrayList<>()); // return empty list in response
			return response;
		}

		// Attempt to load vehicle data using service
		try {
			System.out.println("File found. Trying to load...");
			List<Vehicle> vehicles = vehicleService.loadDataFromDao(VEHICLE_FILE);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setVehicles(vehicles);
			System.out.println("Vehicles loaded successfully");
		} catch (VehicleServiceException e) {
			// In case of exception during loading
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Could not load vehicle data: " + e.getMessage());
			response.setVehicles(new ArrayList<>());
			System.out.println("Exception while loading: " + e.getMessage());
		}

		return response;
	}

	/**
	 * Calculates and prints the total rental price for rented vehicles.
	 */
	public void handleTotalRentalPrice() {
		double total = vehicleService.calculateTotalRentalPrice();
		System.out.println("\nTotal Rental Amount: " + total);
	}

	/**
	 * Displays available vehicles and allows user to rent one. If none available,
	 * prints a message.
	 */
	public void checkAvailability() {
		boolean rented = vehicleService.hasAvailableVehicles();
		if (!rented) {
			vehicleService.rentVehicle(); // Let user rent a vehicle
		} else {
			System.out.println("\nOops! Seems like no vehicles are available right now.");
		}
	}

	/**
	 * Adds a new car or bike to the vehicle list. Uses service layer and wraps
	 * response.
	 * 
	 * @return Response object with status and updated vehicle list.
	 */
	public Response controlAddVehicle() {
		Response addResponse = new Response();
		try {
			vehicleService.addVehicle(); // Prompt user and add vehicle
			addResponse.setStatusCode(SUCCESS_STATUS_CODE);
			addResponse.setVehicles(vehicleService.getVehicleList());
		} catch (VehicleServiceException e) {
			addResponse.setStatusCode(ERROR_STATUS_CODE);
			addResponse.setErrorMessage("Invalid vehicle type");
		}
		return addResponse;
	}

	/**
	 * Searches for a vehicle by brand or model name.
	 * 
	 * @param searchKey the string to search
	 */
	public void controlSearch(String searchKey) {
		vehicleService.searchVehicle(searchKey);
	}
}
