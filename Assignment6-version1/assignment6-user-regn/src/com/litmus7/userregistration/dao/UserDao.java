package com.litmus7.userregistration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.DAOException;
import com.litmus7.userregistration.util.SQLConstants;
import com.litmus7.userregistration.util.DBUtil;

/**
 * Data Access Object (DAO) for handling database operations related to User.
 * <p>
 * This class provides methods to:
 * <ul>
 * <li>Check whether a user already exists based on username or email</li>
 * <li>Insert a new user into the database</li>
 * </ul>
 */
public class UserDao {

	/**
	 * Checks whether a user already exists in the database by comparing the
	 * provided username or email.
	 *
	 * @param user  the username to check
	 * @param email the email address to check
	 * @return true if a user with the given username or email already exists, false
	 *         otherwise
	 * @throws DAOException
	 */
	public boolean checkUser(String user, String email) throws DAOException {
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.CHECK_USER_EXISTS);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, email);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return count > 0;
			}

			connection.close();
		} catch (SQLException e) {
			throw new DAOException("Failed to check user existence");
		}
		return false;
	}

	/**   
	 * Inserts a new user record into the database.
	 *
	 * @param user the {@link User} object containing registration details
	 * @return true if the user was successfully saved, false otherwise
	 * @throws DAOException
	 */
	public boolean saveToDb(User user) throws DAOException {
		try {
			Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.INSERT_USER);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setInt(2, user.getAge());
			preparedStatement.setString(3, user.getEmail());

			int rows = preparedStatement.executeUpdate();

			connection.close();
			return rows > 0;
		} catch (SQLException e) {   
			throw new DAOException("Failed to save user");
		}
	}
}
