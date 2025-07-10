package com.litmus7.userregistration.exception;

/**
 * Custom exception used to represent validation-related errors during user
 * registration or input checks (e.g., invalid age, email, or password).
 */
public class UserValidationException extends Exception {

	/**
	 * Constructs a new UserValidationException with a specified error message and
	 * cause.
	 *
	 * @param message Detailed description of the validation failure.
	 * @param cause   The underlying exception that caused this error.
	 */
	public UserValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new UserValidationException with only a message.
	 *
	 * @param message Description of the validation failure.
	 */
	public UserValidationException(String message) {
		super(message);
	}
}
