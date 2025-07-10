package com.litmus7.userregistration.service;

import com.litmus7.userregistration.dao.UserDao;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.*;
import com.litmus7.userregistration.util.InputValidation;

/**
 * Service layer responsible for business logic and validation. 
 * This layer acts as a bridge between the Controller and DAO layers.
 * It handles user input validation, duplicate checking, and saving data to the database.
 */
public class UserService {

    // DAO to interact with the persistence layer
    private final UserDao dao = new UserDao();

    /**
     * Validates user input fields using utility methods.
     *
     * @param user the user object to be validated
     * @throws UserValidationException if any field is invalid
     */
    public void registerUser(User user) throws UserValidationException {
        // Null check to avoid NullPointerException
        if (user == null) {
            throw new UserValidationException("User object is null");
        }

        try {
            // Perform field-level validations
            InputValidation.isValidUsername(user.getUsername());
            InputValidation.isValidEmail(user.getEmail());
            InputValidation.isValidAge(user.getAge());
            InputValidation.isValidPassword(user.getPassword());
        } catch (InvalidUsernameException e) {
            throw new UserValidationException("Username validation failed: " + e.getMessage(), e);
        } catch (InvalidEmailException e) {
            throw new UserValidationException("Email validation failed: " + e.getMessage(), e);
        } catch (InvalidAgeException e) {
            throw new UserValidationException("Age validation failed: " + e.getMessage(), e);
        } catch (WeakPasswordException e) {
            throw new UserValidationException("Password validation failed: " + e.getMessage(), e);
        }
    }

    /**
     * Checks whether a user with the given username or email already exists.
     *
     * @param username the username to check
     * @param email    the email address to check
     * @throws DuplicateEntryException if user already exists
     * @throws DAOException if there is a database access issue
     */
    public void checkDuplicateEntry(String username, String email) 
            throws DuplicateEntryException, DAOException {
        // Let DAOException bubble up to allow caller to handle DB failures explicitly
        if (dao.checkUser(username, email)) {
            throw new DuplicateEntryException("User already exists with the given username or email.");
        }
    }

    /**
     * Persists a validated user to the database.
     *
     * @param user the user to be saved
     * @return true if successfully saved, false otherwise
     * @throws DAOException if saving to DB fails
     */
    public boolean saveUserToDb(User user) throws DAOException {
        // Save user using DAO and handle DAOException at the controller level
        return dao.saveToDb(user);
    }
 }
