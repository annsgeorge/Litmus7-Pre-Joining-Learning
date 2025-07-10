package com.litmus7.userregistration.exception;

/**
 * Custom exception class used to represent database access errors in the DAO
 * layer.
 * <p>
 * This exception is thrown when any SQL-related issue occurs while accessing
 * the database, allowing it to be handled gracefully in the service or
 * controller layers.
 */
public class DAOException extends Exception {

	/**
	 * Constructs a new DAOException with a specified error message and cause.
	 *
	 * @param message the detail message explaining the reason for the exception
	 * @param cause   the underlying cause of the exception (typically a
	 *                SQLException)
	 */
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new DAOException with a specified error message.
	 *
	 * @param message the detail message explaining the reason for the exception
	 */
	public DAOException(String message) {
		super(message);
	}
}
