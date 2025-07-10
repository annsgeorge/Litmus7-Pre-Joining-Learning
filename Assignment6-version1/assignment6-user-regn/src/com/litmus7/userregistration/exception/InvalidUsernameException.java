package com.litmus7.userregistration.exception;

/**
 * Custom exception thrown when the username provided by the user is invalid.
 * This could occur if the username is empty, too short, or contains disallowed
 * characters.
 */
public class InvalidUsernameException extends Exception {

	/**
	 * Constructs a new InvalidUsernameException with the specified detail message
	 * and cause.
	 *
	 * @param message Description of the validation issue.
	 * @param cause   The underlying exception that caused this error.
	 */
	public InvalidUsernameException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new InvalidUsernameException with the specified detail message.
	 *
	 * @param message Description of the validation issue.
	 */
	public InvalidUsernameException(String message) {
		super(message);
	}
}
