package com.litmus7.userregistration.exception;

/**
 * Custom exception thrown when a user's password is considered weak. This may
 * include passwords that are too short, lack complexity, or do not meet defined
 * security policies (e.g., missing special characters, digits, etc.).
 */
public class WeakPasswordException extends Exception {

	/**
	 * Constructs a new WeakPasswordException with the specified message and cause.
	 *
	 * @param message A description of why the password is considered weak.
	 * @param cause   The underlying cause of the exception (optional).
	 */
	public WeakPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new WeakPasswordException with only a message.
	 *
	 * @param message A description of why the password is considered weak.
	 */
	public WeakPasswordException(String message) {
		super(message);
	}
}
