package com.litmus7.userregistration.dto;

import java.util.List;

/**
 * Generic Response class to encapsulate API responses across layers
 * 
 * @param <T> the type of the data being returned
 */
public class Response<T> {
	
	// Indicates whether the request was successful or not
	private int statusCode;
	
	// Stores a list of error messages if the request failed
	private List<String> errorMessage;
	
	// Holds the actual data returned in case of a successful request
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
	 * @param statusCode 
	 * @param errorMessage 
	 * @param data 
	 */
	public Response(int statusCode, List<String> errorMessage, T data) {
		super();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
		this.data = data;
	}

	/**
	 * Getter for statusCode
	 *
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Setter for statusCode
	 *
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Getter for errorMessage
	 *
	 * @return the errorMessage list
	 */
	public List<String> getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Setter for errorMessage
	 *
	 * @param errorMessage the errorMessage list to set
	 */
	public void setErrorMessage(List<String> errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Getter for data
	 *
	 * @return the data (of generic type T)
	 */
	public T getData() {
		return data;
	}

	/**
	 * Setter for data
	 *
	 * @param data the data to set (of generic type T)
	 */
	public void setData(T data) {
		this.data = data;
	}
}
