package com.litmus7.retail.dto;

public class Response<T> {

	private int statusCode;
	private String errorMessage;
	private T data;
	
	/**
	 * 
	 */
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param statusCode
	 * @param errorMessage
	 * @param data
	 */
	public Response(int statusCode, String errorMessage, T data) {
		super();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
		this.data = data;
	}
	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	
}
