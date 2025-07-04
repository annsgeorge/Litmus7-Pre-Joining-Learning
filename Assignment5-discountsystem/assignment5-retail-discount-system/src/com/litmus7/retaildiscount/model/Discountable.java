package com.litmus7.retaildiscount.model;

/**
 * Discountable is an interface that defines the contract for customer types who
 * are eligible for discounts in the retail discount system.
 * 
 * Any customer type (e.g., Regular, Premium, Wholesale) implementing this
 * interface must provide: - A method to calculate the discount based on the
 * purchase amount. - A method to return the type of customer.
 */
public interface Discountable {

	/**
	 * Calculates and returns the discount amount for a given purchase amount.
	 *
	 * @param amount The total purchase amount
	 * @return The discount to be applied
	 */
	double applyDiscount(double amount);

	/**
	 * Returns a string representing the type of customer.
	 *
	 * @return The customer type (e.g., "Regular Customer")
	 */
	String getCustomerType();
}
