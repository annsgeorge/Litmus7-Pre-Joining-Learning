package com.litmus7.vehiclerentalapp.exception;

/**
 * Custom exception class to handle service-level errors in the vehicle rental
 * application. This may include data access failures, invalid operations, or
 * business logic violations.
 */
public class VehicleDataAccessException extends Exception {

	/**
	 * Default constructor. Useful when no specific message or cause is provided.
	 */
	public VehicleDataAccessException(String message) {
		super(message);
	}

	/**
	 * Constructor with custom message and root cause.
	 *
	 * @param message Descriptive message about the exception.
	 * @param cause   The underlying cause (another throwable) of this exception.
	 */
	public VehicleDataAccessException(String message, Throwable cause) {
		super(message, cause);
	}
}
