package com.litmus7.vehiclerentalapp.exception;

/**
 * Custom exception class to handle service-level errors in the vehicle rental
 * application. This may include data access failures, invalid operations, or
 * business logic violations.
 */
public class VehicleServiceException extends Exception {

	/**
	 * Default constructor. Useful when no specific message or cause is provided.
	 */
	public VehicleServiceException() {
		super();
	}

	/**
	 * Constructor with custom message and root cause.
	 *
	 * @param message Descriptive message about the exception.
	 * @param cause   The underlying cause (another throwable) of this exception.
	 */
	public VehicleServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
