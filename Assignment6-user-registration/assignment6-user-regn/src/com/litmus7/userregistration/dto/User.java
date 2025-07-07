package com.litmus7.userregistration.dto;

public class User {

	private String username;
	private String password;
	private int age;
	private String email;

	/**
	 * @param username
	 * @param pasword
	 * @param age
	 * @param email
	 */
	public User(String username, String password, int age, String email) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.email = email;
	}

	/**
	 * default constructor
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the pasword
	 *//*
		 * public String getPassword() { return password; }
		 */

	/**
	 * @param pasword the pasword to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "\n User Details:\n Username=" + username + "\n Age=" + age + "\n Email=" + email + "";
	}

}
