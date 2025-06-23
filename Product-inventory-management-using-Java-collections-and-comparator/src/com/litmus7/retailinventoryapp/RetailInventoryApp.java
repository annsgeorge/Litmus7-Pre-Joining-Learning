package com.litmus7.retailinventoryapp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.litmus7.product.dto.Product;

/**
 * The {@code RetailInventoryApp} demonstrates basic operations using a list of
 * {@code Product} objects.
 * 
 * {@author anns george}
 */
public class RetailInventoryApp {

	public static void main(String[] args) {

		// Create and add input to the product list
		List<Product> productList = new ArrayList<>();
		productList.add(new Product("P101", "Keyboard", "Electronics", 1200.14, 45));
		productList.add(new Product("P102", "Mouse", "Electronics", 499.50, 40));
		productList.add(new Product("P103", "Notebook", "Stationery", 59.99, 150));
		productList.add(new Product("P104", "Pen", "Stationery", 9.99, 300));
		productList.add(new Product("P105", "Monitor", "Electronics", 5999.00, 10));

		// Display all products
		System.out.println("\n--All Products--");
		for (Product product : productList) {
			System.out.println(product);

		}

		// Sort by price and display
		System.out.println("\n--Products sorted by price");

		productList.sort(Comparator.comparingDouble(Product::getPrice));
		for (Product product : productList) {
			System.out.println(product);
		}

		// Sort by name and display
		System.out.println("\n--Products sorted by name");

		productList.sort(Comparator.comparing(Product::getProductName));
		for (Product product : productList) {
			System.out.println(product.getProductName());
		}

		// Filter products with price less than 30
		System.out.println("\n--Products with price less than 30");

		for (Product product : productList) {
			if (product.getPrice() < 30) {
				System.out.println(product);
			}
		}

		// Calculate total inventory value for each product
		System.out.println("\n--Total Inventory Value");

		for (Product product : productList) {
			double total = product.getPrice() * product.getQuantityAvailable();
			System.out.println(product.getProductId() + "- " + product.getProductName() + "- " + total);
		}
	}

}
