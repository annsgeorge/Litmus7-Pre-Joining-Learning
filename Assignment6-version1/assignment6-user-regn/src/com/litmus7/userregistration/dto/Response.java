package com.litmus7.userregistration.dto;

import java.util.List;

/**
 * Generic Response class to encapsulate API responses across layers
 * 
 * @param <T> the type of the data being returned
 */
public class Response<T> {

	// Status code indicating the result of the operation (e.g., 0 for success, 500
	// for error)
	private int statusCode;

	// A list of error messages in case the operation failed
	private List<String> errorMessage;

	// The actual response data (generic type), populated if the operation is
	// successful
	private T data;

	/**
	 * Default constructor
	 */
	public Response() {
		super();
	}

	/**
	 * Parameterized constructor to initialize all fields at once
	 *
	 * @param statusCode   HTTP-like status code representing success or failure
	 * @param errorMessage list of error messages explaining why the operation
	 *                     failed
	 * @param data         response data of type T (for successful operations)
	 */
	public Response(int statusCode, List<String> errorMessage, T data) {
		super();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
		this.data = data;
	}

	/**
	 * Getter method for statusCode
	 *
	 * @return the current status code
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Setter method for statusCode
	 *
	 * @param statusCode the new status code to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Getter method for errorMessage
	 *
	 * @return the list of error messages
	 */
	public List<String> getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Setter method for errorMessage
	 *
	 * @param errorMessage the list of error messages to set
	 */
	public void setErrorMessage(List<String> errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Getter method for data
	 *
	 * @return the response data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Setter method for data
	 *
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
}
