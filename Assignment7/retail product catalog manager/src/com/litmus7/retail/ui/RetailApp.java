package com.litmus7.retail.ui;

import java.util.List;
import java.util.Scanner;

import com.litmus7.retail.controller.ProductController;
import com.litmus7.retail.dao.ProductDAO;
import com.litmus7.retail.dao.ProductDAOImpl;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.dto.Response;
import com.litmus7.retail.service.ProductService;

public class RetailApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ProductController productController = new ProductController();

		// Start user-interactive menu loop
		while (true) {
			System.out.println("\n1. Add product");
			System.out.println("2. Get product by Id");
			System.out.println("3. Get all products");
			System.out.println("4. Update product");
			System.out.println("5. Delete product");
			System.out.println("6. Exit");

			// Get user choice
			int choice = scanner.nextInt();
			scanner.nextLine(); // Clear newline after int input

			switch (choice) {
			case 1:
				// Handle "Add product"
				try {
					Product product = new Product();

					// Take product details from user
					System.out.println("Enter product name:");
					product.setName(scanner.nextLine());

					System.out.println("Enter product category:");
					product.setCategory(scanner.nextLine());

					System.out.println("Enter price:");
					product.setPrice(scanner.nextDouble());

					System.out.println("Enter stock quantity:");
					product.setStockQuantity(scanner.nextInt());

					// Call controller to add product
					Response<Product> addProductResponse = productController.addProduct(product);
					if (addProductResponse.getStatusCode() == 0) {
						System.out.println("Product added successfully.");
						System.out.println(addProductResponse.getData());
					} else {
						System.out.println("Error: " + addProductResponse.getErrorMessage());
					}
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
					scanner.nextLine(); // Clear any remaining input
				}
				break;

			case 2:
				// Handle "Get product by ID"
				System.out.print("Enter the product ID you want to search: ");
				int productId = scanner.nextInt();
				Response<Product> getProductByIdResponse = productController.getProductById(productId);
				if (getProductByIdResponse.getStatusCode() == 0) {
					System.out.println(getProductByIdResponse.getData());
				} else {
					System.out.println("Error: " + getProductByIdResponse.getErrorMessage());
				}
				break;

			case 3:
				// Handle "Get all products"
				Response<List<Product>> getAllProductsResponse = productController.getAllProducts();
				if (getAllProductsResponse.getStatusCode() == 0) {
					List<Product> productList = getAllProductsResponse.getData();
					for (Product product : productList) {
						System.out.println(product);
					}
				} else {
					System.out.println("Error: " + getAllProductsResponse.getErrorMessage());
				}
				break;

			case 4:
				// Handle "Update product"
				System.out.print("Enter Product ID to update: ");
				int id = scanner.nextInt();
				scanner.nextLine(); // Clear newline

				// Take new details
				System.out.print("Enter new name: ");
				String name = scanner.nextLine();

				System.out.print("Enter new category: ");
				String category = scanner.nextLine();

				System.out.print("Enter new price: ");
				double price = scanner.nextDouble();

				System.out.print("Enter new stock quantity: ");
				int stock = scanner.nextInt();

				// Create updated product and send to controller
				Product updatedProduct = new Product();
				updatedProduct.setProductId(id);
				updatedProduct.setName(name);
				updatedProduct.setCategory(category);
				updatedProduct.setPrice(price);
				updatedProduct.setStockQuantity(stock);

				Response<String> updateResponse = productController.updateProduct(updatedProduct);
				if (updateResponse.getStatusCode() == 0) {
					System.out.println(updateResponse.getData());
				} else {
					System.out.println("Error: " + updateResponse.getErrorMessage());
				}
				break;

			case 5:
				// Handle "Delete product"
				System.out.print("Enter product ID to delete: ");
				int idToDelete = scanner.nextInt();
				Response deleteResponse = productController.deleteProduct(idToDelete);
				if (deleteResponse.getStatusCode() == 0) {
					System.out.println("Product with ID " + idToDelete + " deleted.");
				} else {
					System.out.println("Error: " + deleteResponse.getErrorMessage());
				}
				break;

			case 6:
				// Handle "Exit"
				System.out.println("Exiting...");
				scanner.close();
				return;

			default:
				// Handle invalid choices
				System.out.println("Invalid choice.");
			}
		}
	}
}
