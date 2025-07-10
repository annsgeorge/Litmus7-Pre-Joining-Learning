package com.litmus7.retail.dao;

import java.util.List;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.DAOException;

/**
 * ProductDAO defines the contract for data access operations
 * related to the Product entity. It provides methods to add,
 * retrieve, update, and delete products from the data source.
 *
 * Implementations of this interface handle interaction with
 * the underlying database and encapsulate all SQL-related logic.
 *
 * @author 
 */
public interface ProductDAO {

    /**
     * Adds a new product to the database.
     *
     * @param product the product to be added
     * @throws DAOException if any database access error occurs
     */
    void addProduct(Product product) throws DAOException;

    /**
     * Checks if a product with the given name already exists.
     *
     * @param name the name of the product to check
     * @return true if the product exists, false otherwise
     * @throws DAOException if any database access error occurs
     */
    boolean existsByName(String name) throws DAOException;

    /**
     * Retrieves a product by its ID.
     *
     * @param productId the ID of the product to retrieve
     * @return the product if found, or null if not found
     * @throws DAOException if any database access error occurs
     */
    Product getProductById(int productId) throws DAOException;

    /**
     * Retrieves all products from the database.
     *
     * @return a list of all products
     * @throws DAOException if any database access error occurs
     */
    List<Product> getAllProducts() throws DAOException;

    /**
     * Updates the details of an existing product.
     *
     * @param product the product with updated information
     * @return true if the product was successfully updated, false if the product does not exist
     * @throws DAOException if any database access error occurs
     */
    boolean updateProduct(Product product) throws DAOException;

    /**
     * Deletes a product by its ID.
     *
     * @param productId the ID of the product to delete
     * @return true if the product was deleted, false if no such product exists
     * @throws DAOException if any database access error occurs
     */
    boolean deleteProduct(int productId) throws DAOException;
}
