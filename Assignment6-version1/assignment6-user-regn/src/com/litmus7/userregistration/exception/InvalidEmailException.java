package com.litmus7.userregistration.exception;

/**
 * Custom exception thrown when a user's email address is invalid, such as not
 * matching the expected format (e.g., missing '@' or domain).
 */
public class InvalidEmailException extends Exception {

	/**
	 * Constructs a new InvalidEmailException with a specified message and cause.
	 *
	 * @param message A description of the validation failure.
	 * @param cause   The underlying cause (usually another exception).
	 */
	public InvalidEmailException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new InvalidEmailException with only a message.
	 *
	 * @param message A description of the validation failure.
	 */
	public InvalidEmailException(String message) {
		super(message);
	}
}
