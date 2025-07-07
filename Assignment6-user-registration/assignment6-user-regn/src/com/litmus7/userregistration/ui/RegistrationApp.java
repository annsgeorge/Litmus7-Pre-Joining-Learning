package com.litmus7.userregistration.ui;

import java.util.List;
import java.util.Scanner;

import com.litmus7.userregistration.controller.UserController;
import com.litmus7.userregistration.dao.UserDao;
import com.litmus7.userregistration.dto.*;
import com.litmus7.userregistration.exception.InvalidAgeException;
import com.litmus7.userregistration.exception.InvalidEmailException;
import com.litmus7.userregistration.exception.WeakPasswordException;
import com.litmus7.userregistration.service.UserService;

public class RegistrationApp {

	public static void main(String[] args) {
		// Scanner is used for reading user input from the console
		Scanner scanner = new Scanner(System.in);

		try {
			// Create an instance of the controller layer
			UserController userController = new UserController();

			// Read username input from the user
			System.out.println("\nEnter Username:");
			String username = scanner.nextLine();

			// Read age input and move to next line to avoid skipping input
			System.out.println("\nEnter age:");
			int age = scanner.nextInt();
			scanner.nextLine(); // Consume newline left-over

			// Read email input
			System.out.println("\nEnter email:");
			String email = scanner.nextLine();

			// Read password input
			System.out.println("\nEnter password:");
			String password = scanner.nextLine();

			// Call controller method to handle user registration and get a response
			Response response = userController.registerUser(username, age, email, password);

			// Check if the registration was successful
			if (response.getStatusCode() == 0) {
				System.out.println("\nRegistration successful!");
				System.out.println(response.getData()); // Print user data or confirmation
			} else {
				// If there were validation errors, display them
				List<String> errors = response.getErrorMessage();
				System.out.println("\nRegistration failed..");
				for (String err : errors) {
					System.out.println("\nError: " + err);
				}
			}

		} catch (Exception e) {
			// Catch any unexpected exceptions and display a generic error message
			System.out.println("\nUnexpected error: " + e.getMessage());
		} finally {
			// Ensure the scanner is always closed to avoid resource leaks
			scanner.close();
		}
	}
}
