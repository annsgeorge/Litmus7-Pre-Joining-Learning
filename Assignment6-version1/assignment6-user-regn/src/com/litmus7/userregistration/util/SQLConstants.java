package com.litmus7.userregistration.util;

/**
 * Utility class that holds SQL query constants used throughout the application.
 * 
 * <p>
 * This class provides a centralized location for SQL statements to avoid
 * duplication and ease future maintenance.
 * </p>
 */
public class SQLConstants {

	/**
	 * SQL query to check if a user exists in the database based on username or
	 * email. Used to prevent duplicate registrations.
	 */
	public static final String CHECK_USER_EXISTS = "SELECT COUNT(username) FROM users WHERE username = ? OR email = ?";

	/**
	 * SQL query to insert a new user into the database.
	 */
	public static final String INSERT_USER = "INSERT INTO users (username, age, email) VALUES (?, ?, ?)";
}
