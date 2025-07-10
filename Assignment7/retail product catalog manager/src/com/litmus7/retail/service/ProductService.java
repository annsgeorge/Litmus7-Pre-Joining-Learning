package com.litmus7.retail.service;

import java.util.List;

import com.litmus7.retail.dao.*;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.DAOException;
import com.litmus7.retail.exception.ServiceException;

/**
 * Service layer for handling business logic related to Product operations.
 * 
 * This class mediates between the controller layer and the DAO layer.
 */
public class ProductService {

	ProductDAO dao = new ProductDAOImpl();

	/**
	 * Adds a new product to the database after checking for duplicates by name.
	 *
	 * @param product the product to be added
	 * @return true if the product is successfully added
	 * @throws ServiceException if the product name already exists or if a DAO error
	 *                          occurs
	 */
	public boolean addProduct(Product product) throws ServiceException {
		try {
			if (dao.existsByName(product.getName())) {
				throw new ServiceException("Product with this name already exists.");
			}
			dao.addProduct(product);
			return true;
		} catch (DAOException e) {
			throw new ServiceException("Failed to add product.", e);
		}
	}

	/**
	 * Retrieves a product by its ID.
	 *
	 * @param productId the ID of the product to retrieve
	 * @return the Product object, or null if not found
	 * @throws ServiceException if a DAO error occurs
	 */
	public Product getProductById(int productId) throws ServiceException {
		try {
			return dao.getProductById(productId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Retrieves all products from the database.
	 *
	 * @return a list of all products
	 * @throws ServiceException if a DAO error occurs
	 */
	public List<Product> getAllProducts() throws ServiceException {
		try {
			return dao.getAllProducts();
		} catch (DAOException e) {
			throw new ServiceException("Failed to fetch product list", e);
		}
	}

	/**
	 * Updates an existing product's details in the database.
	 *
	 * @param product the product with updated details
	 * @return true if the product was updated
	 * @throws ServiceException if the product is not found or a DAO error occurs
	 */
	public boolean updateProduct(Product product) throws ServiceException {
		try {
			boolean updated = dao.updateProduct(product);
			if (!updated) {
				throw new ServiceException("Product not found with ID: " + product.getProductId());
			}
			return true;
		} catch (DAOException e) {
			throw new ServiceException("Error while updating product: " + e.getMessage(), e);
		}
	}

	/**
	 * Deletes a product by its ID.
	 *
	 * @param productId the ID of the product to delete
	 * @return true if the product was successfully deleted
	 * @throws ServiceException if deletion fails or a DAO error occurs
	 */
	public boolean deleteProduct(int productId) throws ServiceException {
		try {
			boolean deleted = dao.deleteProduct(productId);
			if (!deleted) {
				throw new ServiceException("Deletion failed. Product may not exist.");
			}
			return true;
		} catch (DAOException e) {
			throw new ServiceException("Failed to delete product", e);
		}
	}
}
