package com.litmus7.userregistration.exception;

/**
 * Custom exception thrown when the user's age is invalid, such as being below
 * the minimum required age.
 */
public class InvalidAgeException extends Exception {

	/**
	 * Constructor to create an exception with a custom message and root cause.
	 *
	 * @param message Description of the validation error
	 * @param cause   The underlying cause of this exception (for chaining)
	 */
	public InvalidAgeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor to create an exception with only a message.
	 *
	 * @param message Description of the validation error
	 */
	public InvalidAgeException(String message) {
		super(message);
	}
}
