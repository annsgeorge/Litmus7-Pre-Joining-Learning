package com.litmus7.retail.exception;

public class ServiceException extends Exception {

	/**
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
	}
	
	

}
