package com.litmus7.vehiclerentalapp.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import com.litmus7.vehiclerentalapp.dto.Response;
import com.litmus7.vehiclerentalapp.dto.Vehicle;
import com.litmus7.vehiclerentalapp.exception.VehicleDataAccessException;
import com.litmus7.vehiclerentalapp.service.VehicleService;

/**
 * Controller class that acts as a bridge between the main application and the
 * service layer. Handles business logic and exception wrapping.
 */
public class VehicleController {

	// File path used for loading and saving vehicle data
	public static final String VEHICLE_FILE = "src\\vehicles.txt";

	// Constants for response status codes
	private static final int SUCCESS_STATUS_CODE = 0;
	private static final int ERROR_STATUS_CODE = 500;

	// Service class instance that performs core logic and file operations
	private VehicleService vehicleService = new VehicleService();

	/**
	 * Loads vehicle data from a file using the service layer. Validates if file
	 * exists and has content before loading. Catches and handles exceptions during
	 * file access.
	 *
	 * @return Response containing loaded data or appropriate error message.
	 */
	public Response LoadDataFromFile() {
		Response response = new Response();
		File file = new File(VEHICLE_FILE);
		//System.out.println("Checking file at: " + file.getAbsolutePath());

		// Check if the file is missing or empty
		if (!file.exists() || file.length() == 0) {
			System.out.println("File missing or empty.");
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("The file is " + VEHICLE_FILE + " missing or empty.");
			response.setData(new ArrayList<>()); // Return empty list if error
			return response;
		}

		// Attempt to load vehicle data via service
		try {
			System.out.println("File found. Trying to load...");
			List<Vehicle> vehicles;
			vehicles = vehicleService.loadDataFromDao(VEHICLE_FILE);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setData(vehicles);
		} catch (VehicleDataAccessException e) {
			// Handle exception and return error response
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Could not load vehicle data: " + e.getMessage());
			response.setData(new ArrayList<>());
			System.out.println("Exception while loading: " + e.getMessage());
		}

		return response;
	}

	/**
	 * Calculates total rental amount of all rented vehicles using service and
	 * prints it to console.
	 */
	public Response getTotalRentalPrice() {
		double total = vehicleService.calculateTotalRentalPrice();
		Response response=new Response();
		if(total >0 ) {
			response.setData(total);
			response.setStatusCode(SUCCESS_STATUS_CODE);
		}
		else
		{
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("No rental data found ot total rental is zero");
		}
		return response;
	}

	/**
	 * Checks if there are available vehicles to rent. If available, returns them in
	 * the response. If none are available, returns an error response.
	 *
	 * @return Response with available vehicle list or error message.
	 */
	public Response checkAvailability() {
		List<Vehicle> availableVehicleList;
		availableVehicleList = vehicleService.availableVehicleList();

		Response rentResponse = new Response();
		if (availableVehicleList.size() != 0) {
			// Vehicles available to rent
			rentResponse.setStatusCode(SUCCESS_STATUS_CODE);
			rentResponse.setData(availableVehicleList);
		} else {
			// No vehicles available
			rentResponse.setStatusCode(ERROR_STATUS_CODE);
			rentResponse.setErrorMessage("No vehicles are available right now.");
		}
		return rentResponse;
	}

	/**
	 * Adds a new vehicle to the list and saves it to file using service. Handles
	 * duplicate detection and exception reporting.
	 *
	 * @param v Vehicle to add (Car or Bike)
	 * @return Response with updated list or error if vehicle is duplicate
	 */
	public Response addVehicle(Vehicle v) {
		Response addResponse = new Response();
		try {
			List<Vehicle> vehicleList;
			vehicleList = vehicleService.addVehicle(v, VEHICLE_FILE); // Add and save
			addResponse.setStatusCode(SUCCESS_STATUS_CODE);
			addResponse.setData(vehicleList);
		} catch (VehicleDataAccessException e) {
			// Handle duplicate or write error
			addResponse.setStatusCode(ERROR_STATUS_CODE);
			addResponse.setErrorMessage(e.getMessage());
		}
		return addResponse;
	}

	/**
	 * Searches for vehicles by brand or model name. Returns a list of matching
	 * vehicles or error if none found.
	 *
	 * @param searchKey search keyword (brand or model)
	 * @return Response with list of matches or error message
	 */
	public Response searchVehicle(String searchKey) {
		Response searchResponse = new Response<>();
		List<Vehicle> searchResultList;
		searchResultList = vehicleService.searchVehicle(searchKey);

		if (searchResultList.size() != 0) {
			searchResponse.setStatusCode(SUCCESS_STATUS_CODE);
			searchResponse.setData(searchResultList);
		} else {
			searchResponse.setStatusCode(ERROR_STATUS_CODE);
			searchResponse.setErrorMessage(searchKey + " not found");
		}
		return searchResponse;
	}
}
