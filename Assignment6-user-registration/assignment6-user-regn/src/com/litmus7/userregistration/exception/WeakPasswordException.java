package com.litmus7.userregistration.exception;

public class WeakPasswordException extends Exception {

	/**
	 * @param message
	 * @param cause
	 */
	public WeakPasswordException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 */
	public WeakPasswordException(String message) {
		super(message);
		
	}
	

}
