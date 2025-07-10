package com.litmus7.userregistration.dto;

/**
 * DTO class representing a User with basic details like username, password,
 * age, and email.
 */
public class User {

	private String username;
	private String password;
	private int age;
	private String email;

	/**
	 * Parameterized constructor to create a User with all attributes.
	 * 
	 * @param username the username of the user
	 * @param password the user's password
	 * @param age      the user's age
	 * @param email    the user's email address
	 */
	public User(String username, String password, int age, String email) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.email = email;
	}

	/**
	 * Default no-argument constructor.
	 */
	public User() {
		super();
	}

	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 * 
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the age.
	 * 
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 * 
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns a string representation of the User object excluding the password for
	 * security.
	 * 
	 * @return a formatted string showing user details
	 */
	@Override
	public String toString() {
		return "\nUser Details:\nUsername = " + username + "\nAge = " + age + "\nEmail = " + email;
	}
}
