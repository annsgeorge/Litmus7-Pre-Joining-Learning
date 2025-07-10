package com.litmus7.userregistration.util;

import java.util.regex.*;

import com.litmus7.userregistration.exception.InvalidAgeException;
import com.litmus7.userregistration.exception.InvalidEmailException;
import com.litmus7.userregistration.exception.InvalidUsernameException;
import com.litmus7.userregistration.exception.WeakPasswordException;

/**
 * Utility class providing static methods for validating user input fields. This
 * class ensures user data adheres to specific business rules.
 */
public class InputValidation {

	// Constants defining acceptable age range
	private static final int MINIMUM_AGE = 18;
	private static final int MAXIMUM_AGE = 60;

	/**
	 * Validates the given username based on format rules.
	 * 
	 * @param username the username to validate
	 * @throws InvalidUsernameException if the username is empty or doesn't match
	 *                                  the expected pattern
	 */
	public static void isValidUsername(String username) throws InvalidUsernameException {
		if (username.isEmpty()) {
			throw new InvalidUsernameException("Username cannot be empty");
		}
		String usernameRegularExpression = "^[A-Za-z]\\w{4,}$";
		if (!Pattern.matches(usernameRegularExpression, username)) {
			throw new InvalidUsernameException("Username must start with a letter and be at least 5 characters long");
		}
	}

	/**
	 * Validates the password to ensure it follows a secure pattern.
	 * 
	 * @param password the password to validate
	 * @throws WeakPasswordException if the password is weak or does not meet the
	 *                               format rules
	 */
	public static void isValidPassword(String password) throws WeakPasswordException {
		String passwordRegularExpression = "^[A-Z](?=.*[a-z])[A-Za-z\\d]{5,}$";
		if (!Pattern.matches(passwordRegularExpression, password)) {
			throw new WeakPasswordException(
					"Password must start with an uppercase letter, contain at least one lowercase letter, and be at least 6 characters long with only letters and digits.");
		}
	}

	/**
	 * Validates the format of the provided email address.
	 * 
	 * @param email the email to validate
	 * @throws InvalidEmailException if the email does not match the standard format
	 */
	public static void isValidEmail(String email) throws InvalidEmailException {
		String emailRegularExpression = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
		if (!Pattern.matches(emailRegularExpression, email)) {
			throw new InvalidEmailException("Email should contain '@' and '.'");
		}
	}

	/**
	 * Validates that the age is within the acceptable range (18 to 60).
	 * 
	 * @param age the user's age to validate
	 * @throws InvalidAgeException if the age is less than 18 or greater than 60
	 */
	public static void isValidAge(int age) throws InvalidAgeException {
		if (age < MINIMUM_AGE || age > MAXIMUM_AGE) {
			throw new InvalidAgeException("Age should be between 18 and 60");
		}
	}
}
