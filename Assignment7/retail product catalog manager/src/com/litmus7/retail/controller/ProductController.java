package com.litmus7.retail.controller;

import java.util.List;

import com.litmus7.retail.dto.*;
import com.litmus7.retail.exception.ServiceException;
import com.litmus7.retail.service.ProductService;

/**
 * Controller class that handles requests from the UI or API layer
 * and delegates them to the ProductService.
 *
 * It also wraps responses in a standard Response<T> object
 * with status codes and error messages if applicable.
 */
public class ProductController {

    private static final int SUCCESS_STATUS_CODE = 0;
    private static final int ERROR_STATUS_CODE = 500;

    ProductService productService=new ProductService();

    

    /**
     * Adds a new product to the system.
     * 
     * @param product The product to be added.
     * @return Response containing the added product or error message.
     */
    public Response addProduct(Product product) {
        Response response = new Response();
        try {
            if (productService.addProduct(product)) {
                response.setStatusCode(SUCCESS_STATUS_CODE);
                response.setData(product);
            }
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setStatusCode(ERROR_STATUS_CODE);
        }
        return response;
    }

    /**
     * Fetches a product by its ID.
     * 
     * @param productId The ID of the product to fetch.
     * @return Response containing the product or an error message.
     */
    public Response<Product> getProductById(int productId) {
        Response<Product> response = new Response<>();
        try {
            Product product = productService.getProductById(productId);
            if (product != null) {
                response.setStatusCode(SUCCESS_STATUS_CODE);
                response.setData(product);
            } else {
                response.setStatusCode(ERROR_STATUS_CODE);
                response.setErrorMessage("Product not found with ID: " + productId);
            }
        } catch (ServiceException e) {
            response.setErrorMessage(e.getMessage());
            response.setStatusCode(ERROR_STATUS_CODE);
        }
        return response;
    }

    /**
     * Retrieves a list of all products.
     * 
     * @return Response containing a list of products or an error message.
     */
    public Response<List<Product>> getAllProducts() {
        Response<List<Product>> response = new Response<>();
        try {
            List<Product> productList = productService.getAllProducts();
            if (productList.isEmpty()) {
                response.setStatusCode(ERROR_STATUS_CODE);
                response.setErrorMessage("No data found");
            } else {
                response.setStatusCode(SUCCESS_STATUS_CODE);
                response.setData(productList);
            }
        } catch (ServiceException e) {
            response.setStatusCode(ERROR_STATUS_CODE);
            response.setErrorMessage(e.getMessage());
        }

        return response;
    }

    /**
     * Updates an existing product.
     * 
     * @param product The product object with updated values.
     * @return Response indicating success or failure message.
     */
    public Response<String> updateProduct(Product product) {
        Response<String> response = new Response<>();

        try {
            boolean success = productService.updateProduct(product);
            if (success) {
                response.setStatusCode(SUCCESS_STATUS_CODE);
                response.setData("Product updated successfully.");
            }
        } catch (ServiceException e) {
            response.setStatusCode(ERROR_STATUS_CODE);
            response.setErrorMessage("Failed to update product: " + e.getMessage());
        }

        return response;
    }

    /**
     * Deletes a product by its ID.
     * 
     * @param productId The ID of the product to be deleted.
     * @return Response indicating success or failure message.
     */
    public Response deleteProduct(int productId) {
        Response response = new Response();
        try {
            boolean deleted = productService.deleteProduct(productId);
            if (deleted) {
                response.setStatusCode(SUCCESS_STATUS_CODE);
            }
        } catch (ServiceException e) {
            response.setStatusCode(ERROR_STATUS_CODE);
            response.setErrorMessage("Unable to delete product");
        }
        return response;
    }
}
