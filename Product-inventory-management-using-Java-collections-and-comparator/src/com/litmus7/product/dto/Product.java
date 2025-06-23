package com.litmus7.product.dto;

/**
 * The product class contains basic product details like
 * productId,productName,category,price,quantityAvailable. It is used in the
 * retail inventory application to store and retrieve product-related data.
 */

public class Product {

	private String productId;
	private String productName;
	private String category;
	private double price;
	private int quantityAvailable;

	/**
	 * @param productId
	 * @param productName
	 * @param category
	 * @param price
	 * @param quantityAvailable
	 */
	public Product(String productId, String productName, String category, double price, int quantityAvailable) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.quantityAvailable = quantityAvailable;
	}

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the quantityAvailable
	 */
	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	/**
	 * Returns a string representation of the product, including ID, name, category,
	 * price, and quantity.
	 */
	@Override
	public String toString() {
		return productId + "- " + productName + "- " + category + " -" + price + "- " + quantityAvailable;
	}

}
