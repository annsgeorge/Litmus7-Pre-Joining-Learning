package com.litmus7.retail.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Utility class for managing database connections.
 * 
 * Loads DB configuration from 'db.properties' file located in the classpath,
 * and provides a static method to get JDBC connections.
 * 
 * This class ensures a single-time loading of DB credentials using a static initializer.
 */
public class DBUtil {

    private static final String url;
    private static final String username;
    private static final String password;

    // Static block to load DB properties
    static {
        try (InputStream input = DBUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties props = new Properties();

            if (input == null) {
                throw new RuntimeException("Unable to find db.properties in classpath");
            }

            props.load(input);
            url = props.getProperty("jdbc.url");
            username = props.getProperty("jdbc.username");
            password = props.getProperty("jdbc.password");

        } catch (Exception e) {
            throw new RuntimeException("Failed to load DB configuration", e);
        }
    }

    /**
     * Returns a new connection to the database using loaded credentials.
     *
     * @return a new JDBC Connection object
     * @throws SQLException if a connection cannot be established
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
