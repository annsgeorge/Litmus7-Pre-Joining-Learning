package com.litmus7.retail.util;

/**
 * SQLConstants is a utility class that stores all SQL query strings 
 * used for database operations related to the 'products' table.
 * 
 */
public class SQLConstants {

    /** SQL query to insert a new product into the database */
    public static final String INSERT_PRODUCT =
        "INSERT INTO products(name, category, price, stockQuantity) VALUES (?, ?, ?, ?)";

    /** SQL query to check if a product with a given name already exists */
    public static final String CHECKS_PRODUCT_EXISTS =
        "SELECT COUNT(name) FROM products WHERE name = ?";

    /** SQL query to retrieve a product by its ID */
    public static final String GET_PRODUCT_BY_ID =
        "SELECT productID, name, category, price, stockQuantity FROM products WHERE productID = ?";

    /** SQL query to retrieve all products from the database */
    public static final String GET_ALL_PRODUCTS =
        "SELECT productID, name, category, price, stockQuantity FROM products";

    /** SQL query to delete a product by its ID */
    public static final String DELETE_PRODUCT =
        "DELETE FROM products WHERE productID = ?";

    /** SQL query to update an existing product by its ID */
    public static final String UPDATE_PRODUCT =
        "UPDATE products SET name = ?, category = ?, price = ?, stockQuantity = ? WHERE productID = ?";
}
