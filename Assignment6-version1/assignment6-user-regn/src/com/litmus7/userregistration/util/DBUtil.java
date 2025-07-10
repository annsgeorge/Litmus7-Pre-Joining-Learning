package com.litmus7.userregistration.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Utility class for managing database connectivity.
 * 
 * <p>
 * This class loads DB configuration from a `db.properties` file and provides a
 * method to get a database connection.
 * </p>
 */
public class DBUtil {

	// JDBC connection parameters loaded from properties file
	private static final String url;
	private static final String username;
	private static final String password;

	// Static initializer to load database properties when the class is first loaded
	static {
		try (InputStream input = DBUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
			Properties properties = new Properties();

			if (input == null) {
				throw new RuntimeException("Unable to find db.properties");
			}

			// Load database configuration from properties file
			properties.load(input);
			url = properties.getProperty("jdbc.url");
			username = properties.getProperty("jdbc.username");
			password = properties.getProperty("jdbc.password");

		} catch (Exception e) {
			throw new RuntimeException("Failed to load DB configuration", e);
		}
	}

	/**
	 * Provides a database connection using the loaded properties.
	 *
	 * @return a valid {@link Connection} object
	 * @throws SQLException if the connection fails
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
