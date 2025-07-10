package com.litmus7.userregistration.controller;

import java.util.ArrayList;
import java.util.List;

import com.litmus7.userregistration.dto.*;
import com.litmus7.userregistration.exception.*;
import com.litmus7.userregistration.service.*;

/**
 * Controller layer that handles user registration flow.
 * 
 * <p>
 * This class acts as a bridge between the UI layer and the business logic
 * (service layer). It collects input data, delegates validation and processing
 * to the service, and constructs a unified {@link Response} object to be
 * returned to the client or UI layer.
 * </p>
 */
public class UserController {

	/**
	 * Status code indicating successful operation.
	 */
	private static final int SUCCESS_STATUS_CODE = 0;

	/**
	 * Status code indicating an error during the operation.
	 */
	private static final int ERROR_STATUS_CODE = 500;

	/**
	 * Reference to the business logic layer (service).
	 */
	private final UserService userService = new UserService();

	/**
	 * Handles user registration by performing:
	 * <ul>
	 * <li>Validation (username, email, age, password)</li>
	 * <li>Duplicate check (username or email already exists)</li>
	 * <li>Database persistence on success</li>
	 * </ul>
	 *
	 * @param username the username entered by the user
	 * @param age      the age entered by the user
	 * @param email    the email address entered by the user
	 * @param password the password entered by the user
	 * @return a {@link Response} object with either user data or error messages
	 * @throws InvalidAgeException   if the age is not within allowed range
	 * @throws InvalidEmailException if the email format is invalid
	 * @throws WeakPasswordException if the password does not meet criteria
	 */
	public Response<User> registerUser(String username, int age, String email, String password)
			throws InvalidAgeException, InvalidEmailException, WeakPasswordException {

		// Initialize response object and error list
		Response<User> response = new Response<>();
		List<String> errors = new ArrayList<>();
		User user = new User(username, password, age, email);

		// Step 1: Validate input
		try {
			userService.registerUser(user);
		} catch (UserValidationException e) {
			errors.add(e.getMessage());
		}

		// Step 2: Check duplicates
		try {
			userService.checkDuplicateEntry(username, email);
		} catch (DuplicateEntryException e) {
			errors.add(e.getMessage());
		} catch (DAOException e) {
			errors.add("Database error while checking for duplicates: " + e.getMessage());
		}

		try {
			boolean saved = userService.saveUserToDb(user);
			if (saved) {
				response.setStatusCode(SUCCESS_STATUS_CODE);
				response.setData(user);
			} else {
				errors.add("Failed to save user to database.");
				response.setStatusCode(ERROR_STATUS_CODE);
				response.setErrorMessage(errors);
			}
		} catch (DAOException e) {
			errors.add( e.getMessage());
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(errors);
		}
		return response;
	}
}