package com.litmus7.userregistration.controller;

import java.util.ArrayList;
import java.util.List;

import com.litmus7.userregistration.dto.*;
import com.litmus7.userregistration.exception.*;
import com.litmus7.userregistration.service.*;

/**
 * Controller layer that handles user registration flow. Coordinates between UI
 * and the service layer, and builds the response.
 */
public class UserController {

	// Constants to represent response status codes
	private static final int SUCCESS_STATUS_CODE = 0;
	private static final int ERROR_STATUS_CODE = 500;

	// Service layer object
	UserService userService = new UserService();

	/**
	 * Handles user registration by validating inputs, checking duplicates, and
	 * saving to the database if all validations pass.
	 *
	 * @param username User's username
	 * @param age      User's age
	 * @param email    User's email address
	 * @param password User's password
	 * @return Response<User> containing success status or error messages
	 * @throws InvalidAgeException   for age-related validation issues
	 * @throws InvalidEmailException for invalid email format
	 * @throws WeakPasswordException for weak password
	 */
	public Response<User> registerUser(String username, int age, String email, String password)
			throws InvalidAgeException, InvalidEmailException, WeakPasswordException {

		// Initialize the response object and error list
		Response<User> response = new Response<>();
		List<String> errors = new ArrayList<>();

		// Validate username
		try {
			userService.validUsername(username);
		} catch (Exception e) {
			errors.add(e.getMessage());
		}

		// Validate age
		try {
			userService.validAge(age);
		} catch (InvalidAgeException e) {
			errors.add(e.getMessage());
		}

		// Validate email
		try {
			userService.validEmail(email);
		} catch (InvalidEmailException e) {
			errors.add(e.getMessage());
		}

		// Validate password
		try {
			userService.validPassword(password);
		} catch (WeakPasswordException e) {
			errors.add(e.getMessage());
		}

		// Check for duplicate username/email
		try {
			userService.checkDuplicateEntry(username, email);
		} catch (DuplicateEntryException e) {
			errors.add(e.getMessage());
		}

		// If any validation failed, return error response
		if (!errors.isEmpty()) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(errors);
		} else {
			// Create user object and try saving to the database
			User user = new User(username, password, age, email);
			boolean saved = userService.saveUserToDb(user);

			if (saved) {
				response.setStatusCode(SUCCESS_STATUS_CODE);
				response.setData(user); // Return the successfully created user
			} else {
				errors.add("Failed to save user to database.");
				response.setStatusCode(ERROR_STATUS_CODE);
				response.setErrorMessage(errors);
			}
		}

		// Return final response
		return response;
	}
}
