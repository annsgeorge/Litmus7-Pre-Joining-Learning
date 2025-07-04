package com.litmus7.retaildiscount.model.impl;

import com.litmus7.retaildiscount.model.Discountable;

/**
 * PremiumCustomer implements the Discountable interface and provides discount
 * logic specific to premium customers.
 */
public class PremiumCustomer implements Discountable {

	/**
	 * Applies discount based on the purchase amount for premium customers. - If
	 * amount > 5000, a 10% discount is applied. - Otherwise, a 7% discount is
	 * applied.
	 *
	 * @param amount Total purchase amount
	 * @return Calculated discount amount
	 */
	@Override
	public double applyDiscount(double amount) {
		if (amount > 5000)
			return amount * 0.1; // 10% discount for purchases above 5000
		else
			return amount * 0.07; // 7% discount for purchases up to 5000
	}

	/**
	 * Returns the customer type.
	 *
	 * @return String representing this customer type
	 */
	@Override
	public String getCustomerType() {
		return "Premium Customer";
	}
}
