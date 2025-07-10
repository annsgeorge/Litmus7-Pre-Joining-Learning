package com.litmus7.retail.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.litmus7.retail.util.DBUtil;
import com.litmus7.retail.util.SQLConstants;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.DAOException;

/**
 * Implementation of the ProductDAO interface that handles all
 * database operations for the Product entity using JDBC.
 * 
 * This class provides CRUD operations such as insert, update,
 * delete, and retrieval of products from the 'products' table.
 * 
 * @author 
 */
public class ProductDAOImpl implements ProductDAO {

    /**
     * Inserts a new product into the database and sets the generated product ID.
     *
     * @param product the Product object to be added
     * @throws DAOException if a database access error occurs
     */
    @Override
    public void addProduct(Product product) throws DAOException {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                SQLConstants.INSERT_PRODUCT,
                PreparedStatement.RETURN_GENERATED_KEYS
            );

            statement.setString(1, product.getName());
            statement.setString(2, product.getCategory());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getStockQuantity());

            statement.executeUpdate();

            ResultSet generatedId = statement.getGeneratedKeys();
            if (generatedId.next()) {
                int productId = generatedId.getInt(1);
                product.setProductId(productId);
            }

            connection.close();
        } catch (SQLException e) {
            throw new DAOException("Error while adding new product", e);
        }
    }

    /**
     * Checks if a product with the given name exists in the database.
     *
     * @param name the name of the product to check
     * @return true if product exists, false otherwise
     * @throws DAOException if a database access error occurs
     */
    @Override
    public boolean existsByName(String name) throws DAOException {
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConstants.CHECKS_PRODUCT_EXISTS);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        } catch (SQLException e) {
            throw new DAOException("Database error during name check.", e);
        }
    }

    /**
     * Retrieves a product from the database using its product ID.
     *
     * @param productId the ID of the product to retrieve
     * @return the Product object if found, or null if not found
     * @throws DAOException if a database access error occurs
     */
    @Override
    public Product getProductById(int productId) throws DAOException {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_PRODUCT_BY_ID)) {

            statement.setInt(1, productId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setCategory(resultSet.getString(3));
                product.setPrice(resultSet.getDouble(4));
                product.setStockQuantity(resultSet.getInt(5));
                return product;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DAOException("Database error while fetching product by ID: " + e.getMessage(), e);
        }
    }

    /**
     * Retrieves all products from the database.
     *
     * @return a List of Product objects
     * @throws DAOException if a database access error occurs
     */
    @Override
    public List<Product> getAllProducts() throws DAOException {
        List<Product> productList = new ArrayList<>();

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_ALL_PRODUCTS);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setCategory(resultSet.getString(3));
                product.setPrice(resultSet.getDouble(4));
                product.setStockQuantity(resultSet.getInt(5));
                productList.add(product);
            }

        } catch (SQLException e) {
            throw new DAOException("Error fetching products: " + e.getMessage(), e);
        }

        return productList;
    }

    /**
     * Updates an existing product's details in the database.
     *
     * @param product the Product object with updated values
     * @return true if the product was updated, false if no such product exists
     * @throws DAOException if a database access error occurs
     */
    @Override
    public boolean updateProduct(Product product) throws DAOException {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLConstants.UPDATE_PRODUCT)) {

            statement.setString(1, product.getName());
            statement.setString(2, product.getCategory());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getStockQuantity());
            statement.setInt(5, product.getProductId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new DAOException("Failed to update product: " + e.getMessage(), e);
        }
    }

    /**
     * Deletes a product from the database using its product ID.
     *
     * @param productId the ID of the product to delete
     * @return true if the product was deleted, false if it did not exist
     * @throws DAOException if a database access error occurs
     */
    @Override
    public boolean deleteProduct(int productId) throws DAOException {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLConstants.DELETE_PRODUCT)) {

            statement.setInt(1, productId);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new DAOException("Database Error: " + e.getMessage(), e);
        }
    }
}
