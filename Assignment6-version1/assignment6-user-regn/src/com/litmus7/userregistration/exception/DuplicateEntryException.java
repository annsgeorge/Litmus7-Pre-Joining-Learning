package com.litmus7.userregistration.exception;

/**
 * Custom exception class to handle duplicate entry scenarios, such as when a
 * user tries to register with an already existing username or email.
 */
public class DuplicateEntryException extends Exception {

	/**
	 * Constructor to create an exception with a specific message and root cause.
	 *
	 * @param message Description of the error scenario
	 * @param cause   The original exception causing this error (used for chaining)
	 */
	public DuplicateEntryException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor to create an exception with only a message.
	 *
	 * @param message Description of the error scenario
	 */
	public DuplicateEntryException(String message) {
		super(message);
	}
}
