package com.litmus7.userregistration.exception;

public class InvalidEmailException extends Exception {

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidEmailException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 */
	public InvalidEmailException(String message) {
		super(message);
		
	}

	
}
