package com.litmus7.vehiclerentalapp.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerentalapp.dto.Bike;
import com.litmus7.vehiclerentalapp.dto.Car;
import com.litmus7.vehiclerentalapp.dto.Vehicle;
import com.litmus7.vehiclerentalapp.exception.VehicleServiceException;

/**
 * DAO (Data Access Object) class that handles file operations for reading and
 * writing vehicle data.
 */
public class VehicleDao {

	// List to store vehicles read from the file
	private List<Vehicle> vehicleList = new ArrayList<>();

	/**
	 * Reads vehicle data from a text file and loads it into a list. Each line in
	 * the file represents either a Car or a Bike in CSV format.
	 * 
	 * @param filePath path to the input file
	 * @return list of Vehicle objects parsed from the file
	 * @throws VehicleServiceException if the file doesn't exist or reading fails
	 */
	public List<Vehicle> loadVehiclesFromFile(String filePath) throws VehicleServiceException {
		File file = new File(filePath);

		// Check if file exists
		if (!file.exists()) {
			throw new VehicleServiceException("File not found: " + filePath, null);
		}

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			br.readLine(); // Skip header line if present

			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");

				// Load Car from line
				if (parts.length >= 7 && parts[0].trim().equalsIgnoreCase("Car")) {
					String brand = parts[1].trim();
					String model = parts[2].trim();
					double rentPerDay = Double.parseDouble(parts[3].trim());
					boolean available = Boolean.parseBoolean(parts[4].trim());
					int numberOfDoors = Integer.parseInt(parts[5].trim());
					boolean isAutomatic = Boolean.parseBoolean(parts[6].trim());

					Vehicle car = new Car(brand, model, rentPerDay, available, numberOfDoors, isAutomatic);
					vehicleList.add(car);
				}

				// Load Bike from line
				else if (parts.length >= 7 && parts[0].trim().equalsIgnoreCase("Bike")) {
					String brand = parts[1].trim();
					String model = parts[2].trim();
					double rentPerDay = Double.parseDouble(parts[3].trim());
					boolean available = Boolean.parseBoolean(parts[4].trim());
					boolean hasGear = Boolean.parseBoolean(parts[5].trim());
					int engineCapacity = Integer.parseInt(parts[6].trim());

					Vehicle bike = new Bike(brand, model, rentPerDay, available, hasGear, engineCapacity);
					vehicleList.add(bike);
				}
			}

		} catch (IOException e) {
			throw new VehicleServiceException("Error reading vehicle data file: " + e.getMessage(), e);
		}

		return vehicleList;
	}

	/**
	 * Writes the current list of vehicles to a text file in CSV format. Each line
	 * represents either a Car or a Bike.
	 * 
	 * @param vehicleList list of vehicles to save
	 * @param filePath    path to the file to save
	 */
	public void saveVehicleToFile(List<Vehicle> vehicleList, String filePath) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
			for (Vehicle v : vehicleList) {
				StringBuilder line = new StringBuilder();

				if (v instanceof Car) {
					Car car = (Car) v;
					line.append("Car").append(",").append(car.getBrand()).append(",").append(car.getModel()).append(",")
							.append(car.getRentalPricePerDay()).append(",").append(car.isAvailable()).append(",")
							.append(car.getNumberOfDoors()).append(",").append(car.isAutomatic());
				} else if (v instanceof Bike) {
					Bike bike = (Bike) v;
					line.append("Bike").append(",").append(bike.getBrand()).append(",").append(bike.getModel())
							.append(",").append(bike.getRentalPricePerDay()).append(",").append(bike.isAvailable())
							.append(",").append(bike.isHasGear()).append(",").append(bike.getEngineCapacity());
				}

				bw.write(line.toString()); // Write vehicle data to file
				bw.newLine(); // Move to the next line
			}

		} catch (IOException e) {
			System.out.println("Error saving file: " + e.getMessage());
		}
	}
}
