package com.litmus7.retail.exception;

public class DAOException extends Exception {

	/**
	 * @param message
	 * @param cause
	 */
	public DAOException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 */
	public DAOException(String message) {
		super(message);
		
	}
	

}
