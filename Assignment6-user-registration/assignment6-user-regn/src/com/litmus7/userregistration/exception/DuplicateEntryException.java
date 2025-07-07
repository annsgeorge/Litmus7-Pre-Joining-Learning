package com.litmus7.userregistration.exception;

public class DuplicateEntryException extends Exception {

	/**
	 * @param message
	 * @param cause
	 */
	public DuplicateEntryException(String message, Throwable cause) {
		super(message, cause);

	}

	/**
	 * @param message
	 */
	public DuplicateEntryException(String message) {
		super(message);

	}

}
