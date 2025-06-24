package com.litmus7.vehicleservices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.litmus7.rentalvehicle.dto.Bike;
import com.litmus7.rentalvehicle.dto.Car;
import com.litmus7.rentalvehicle.dto.Vehicle;

/**
 * VehicleService handles core functionalities like loading vehicles from file,
 * displaying data, searching, adding, and renting vehicles.
 */
public class VehicleService {
	// Path to input file

	String filePath = "src/vehicles.txt";
	// List of all vehicles
	List<Vehicle> vehicleList = new ArrayList<>();
	// List of available vehicles used during renting
	List<Vehicle> availableList = new ArrayList();
	Scanner scanner = new Scanner(System.in);

	/**
	 * Loads vehicle data from a CSV-style text file. Parses each line and adds
	 * Car/Bike objects to the vehicle list.
	 */
	public void loadVehiclesFromFile() {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			br.readLine();// Skip header line
			while ((line = br.readLine()) != null) {
				String parts[] = line.split(",");
				if (parts.length >= 7 && parts[0].trim().equalsIgnoreCase("Car")) {
					String brand = parts[1].trim();
					String name = parts[2].trim();
					double rentPerDay = Double.parseDouble(parts[3].trim());
					boolean available = Boolean.parseBoolean(parts[4].trim());
					int numberOfDoors = Integer.parseInt(parts[5].trim());
					boolean isAutomatic = Boolean.parseBoolean(parts[6].trim());

					Vehicle vehicle = new Car(brand, name, rentPerDay, available, numberOfDoors, isAutomatic);
					vehicleList.add(vehicle);

				}
				if (parts.length >= 7 && parts[0].trim().equalsIgnoreCase("bike")) {
					String brand = parts[1].trim();
					String name = parts[2].trim();
					double rentPerDay = Double.parseDouble(parts[3].trim());
					boolean available = Boolean.parseBoolean(parts[4].trim());
					boolean hasGear = Boolean.parseBoolean(parts[5].trim());
					int engineCapacity = Integer.parseInt(parts[6].trim());

					Vehicle vehicle = new Bike(brand, name, rentPerDay, available, hasGear, engineCapacity);
					vehicleList.add(vehicle);
				}
			}

		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());

		}

	}

	/**
	 * Displays details of all vehicles loaded.
	 */

	public void printFileData() {
		for (Vehicle v : vehicleList) {
			v.displayDetails();
			System.out.println();

		}

	}

	/**
	 * Adds a new Car or Bike to the list via user input.
	 */

	public void addVehicle() {

		System.out.println("Enter vehicle type to add Car/Bike :");
		String type = scanner.nextLine().trim();
		if (type.equalsIgnoreCase("car")) {
			Car car = new Car();
			car.inputDetails();
			vehicleList.add(car);
			System.out.println("\n---Displaying updated Vehicle list---");
			printFileData();

		} else if (type.equalsIgnoreCase("bike")) {
			Bike bike = new Bike();
			bike.inputDetails();
			vehicleList.add(bike);
		} else
			System.out.println("Error");

	}

	/**
	 * Searches for a vehicle by brand or model name.
	 */

	public void searchVehicle() {
		System.out.println("\n Enter the brand or model you need to search");
		String searchKey = scanner.nextLine();
		boolean found = false;
		for (Vehicle v : vehicleList) {
			if (v.getBrand().equalsIgnoreCase(searchKey)) {
				v.displayDetails();
				System.out.println();
				found = true;
			}

			else if (v.getModel().equalsIgnoreCase(searchKey)) {
				v.displayDetails();
				found = true;
			}

		}
		if (!found) {

			System.out.println("\nNo vehicle found for  " + searchKey);

		}

	}

	/**
	 * Calculates and prints the total rental price of all vehicles.
	 */
	public void totalRentalPrice() {
		double total = 0;
		for (Vehicle v : vehicleList) {
			total += v.getRentalPricePerDay();

		}
		System.out.println("\nTotal Rental Amount " + total);
	}

	/**
	 * Displays all available (not rented) vehicles and fills the availableList.
	 */
	public void availableVehicles() {
		availableList.clear();
		boolean rented = true;
		System.out.println("\nDetails of available vehicles :\n");
		int i = 1;
		for (Vehicle v : vehicleList) {
			if (v.isAvailable()) {
				System.out.print("[" + i + "]");
				v.displayDetails();
				availableList.add(v);
				rented = false;
				i += 1;
			}

		}
		if (rented) {
			System.out.println("\nOops!Seems like no vehicles are available rignt now");
		}
	}

	/**
	 * Allows user to select and rent a vehicle from the available list.
	 *
	 */
	public void rentVehicle() {
		availableVehicles();
		if (availableList.isEmpty())
			return;

		System.out.println("\nChoose the number of the vehicle you want to rent :");

		int option = scanner.nextInt();
		Vehicle selected = availableList.get(option - 1);
		System.out.println("\nSelect number of days to rent :");
		int days = scanner.nextInt();
		double totalRent = days * selected.getRentalPricePerDay();
		selected.setAvailable(false);
		selected.displayDetails();
		System.out.println("Rental Days: " + days);
		System.out.println("Total Rent: ₹" + totalRent);

	}
}
