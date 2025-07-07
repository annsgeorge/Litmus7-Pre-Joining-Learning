package com.litmus7.userregistration.service;

import com.litmus7.userregistration.dao.UserDao;
import com.litmus7.userregistration.dto.*;
import com.litmus7.userregistration.exception.DuplicateEntryException;
import com.litmus7.userregistration.exception.InvalidAgeException;
import com.litmus7.userregistration.exception.InvalidEmailException;
import com.litmus7.userregistration.exception.WeakPasswordException;

import java.util.Scanner;

/**
 * Service layer responsible for business logic and validation. This layer acts
 * as a bridge between the Controller and DAO layers.
 */
public class UserService {

	// UserDao object to access persistence layer
	UserDao dao = new UserDao();

	/**
	 * Validates that the username is not empty.
	 *
	 * @param username The username entered by the user
	 * @throws Exception if the username is empty
	 */
	public void validUsername(String username) throws Exception {
		if (username.isEmpty()) {
			throw new Exception("Username cannot be empty");
		}
	}

	/**
	 * Validates that the age is between 18 and 60.
	 *
	 * @param age The age entered by the user
	 * @throws InvalidAgeException if the age is outside the valid range
	 */
	public void validAge(int age) throws InvalidAgeException {
		if (age < 18 || age > 60) {
			throw new InvalidAgeException("Age should be between 18 and 60");
		}
	}

	/**
	 * Validates the email format to contain '@' and '.' characters.
	 *
	 * @param email The email entered by the user
	 * @throws InvalidEmailException if the format is incorrect
	 */
	public void validEmail(String email) throws InvalidEmailException {
		if (!(email.contains("@") && email.contains("."))) {
			throw new InvalidEmailException("Email must contain '@' and '.'");
		}
	}

	/**
	 * Validates that the password is at least 6 characters long.
	 *
	 * @param password The password entered by the user
	 * @throws WeakPasswordException if the password is too short
	 */
	public void validPassword(String password) throws WeakPasswordException {
		if (password.length() < 6) {
			throw new WeakPasswordException("Password too weak. Must be at least 6 characters.");
		}
	}

	/**
	 * Checks for duplicate user entries based on username and email.
	 *
	 * @param username The username to be checked
	 * @param email    The email to be checked
	 * @throws DuplicateEntryException if a user already exists with the given
	 *                                 details
	 */
	public void checkDuplicateEntry(String username, String email) throws DuplicateEntryException {
		if (dao.checkUser(username, email)) {
			throw new DuplicateEntryException("User already exists with the given username or email.");
		}
	}

	/**
	 * Saves the user data to the database via the DAO layer.
	 *
	 * @param user The user object containing all user details
	 * @return true if saving was successful, false otherwise
	 */
	public boolean saveUserToDb(User user) {
		return dao.saveToDb(user);
	}
}
