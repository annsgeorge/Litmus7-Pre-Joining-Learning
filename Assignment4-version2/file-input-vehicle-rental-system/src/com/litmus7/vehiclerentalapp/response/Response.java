package com.litmus7.vehiclerentalapp.response;

import java.util.List;

/**
 * This class serves as a standard response wrapper used across the application
 * to convey the outcome of operations such as loading, adding, or searching
 * vehicles.
 * 
 * It contains: - A status code (0 for success, 500 for errors) - An error
 * message (if any) - A list of vehicles relevant to the operation
 */
public class Response<T> {

	// Status code: 0 = success, 500 = error
	private int statusCode;

	// Error message to describe what went wrong, if any
	private String errorMessage;

	// List of vehicles returned by a successful operation
	private List<T> data;

	/**
	 * Gets the status code of the operation.
	 * 
	 * @return statusCode (0 for success, 500 for error)
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets the status code of the operation.
	 * 
	 * @param statusCode the status code to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Gets the error message, if any.
	 * 
	 * @return the error message string
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets an error message to describe the issue.
	 * 
	 * @param errorMessage the error message string
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the data
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * 
	 */
	public void setData(List<T> data) {
		this.data = (List<T>) data;
	}

}
