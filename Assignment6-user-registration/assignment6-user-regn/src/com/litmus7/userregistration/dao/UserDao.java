package com.litmus7.userregistration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.litmus7.userregistration.dto.*;

/**
 * Data Access Object (DAO) for handling database operations related to User.
 * This class connects to a MySQL database and provides methods to: - Check if a
 * user already exists - Save a new user to the database
 */
public class UserDao {

	// Database connection details
	private static final String url = "jdbc:mysql://localhost:3306/user_db";
	private static final String username = "root";
	private static final String password = "password";
 
	/**
	 * Checks if a user already exists in the database based on username or email.
	 *
	 * @param user  The username to check
	 * @param email The email to check
	 * @return true if the user exists, false otherwise
	 */
	public boolean checkUser(String user, String email) {
		try {
			// Establish a connection to the database
			Connection connection = DriverManager.getConnection(url, username, password);

			// SQL query to count users with given username or email
			String sql = "SELECT COUNT(*) FROM users WHERE username = ? OR email = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, email);

			// Execute query and process result
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return count > 0; // Return true if any matching record found
			}

			connection.close(); // Close connection
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Saves a new user to the database.
	 *
	 * @param user The User object containing user details
	 * @return true if insertion was successful, false otherwise
	 */
	public boolean saveToDb(User user) {
		try {
			// Establish a connection to the database
			Connection connection = DriverManager.getConnection(url, username, password);

			// SQL insert statement
			String sql = "INSERT INTO users (username, age, email) VALUES (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setInt(2, user.getAge());
			preparedStatement.setString(3, user.getEmail());

			// Execute insert and check affected rows
			int rows = preparedStatement.executeUpdate();

			connection.close(); // Close connection
			return rows > 0; // Return true if at least one row inserted

		} catch (Exception e) {
			e.printStackTrace(); // Log exception
		}
		return false;
	}
}
