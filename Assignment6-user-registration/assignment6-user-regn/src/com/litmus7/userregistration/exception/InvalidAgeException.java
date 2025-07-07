package com.litmus7.userregistration.exception;

public class InvalidAgeException extends Exception {

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidAgeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public InvalidAgeException(String message) {
		super(message);
	}

}
