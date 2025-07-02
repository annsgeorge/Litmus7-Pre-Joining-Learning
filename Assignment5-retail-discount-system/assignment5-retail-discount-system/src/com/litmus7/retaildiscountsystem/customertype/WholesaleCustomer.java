package com.litmus7.retaildiscountsystem.customertype;

/**
 * WholesaleCustomer implements the Discountable interface and provides tiered
 * discount logic for wholesale customers.
 */
public class WholesaleCustomer implements Discountable {

	/**
	 * Applies discount based on the purchase amount for wholesale customers. - If
	 * amount > 10,000, a 15% discount is applied. - Otherwise, a 10% discount is
	 * applied.
	 *
	 * @param amount Total purchase amount
	 * @return Calculated discount amount
	 */
	@Override
	public double applyDiscount(double amount) {
		if (amount > 10000)
			return amount * 0.15; // 15% discount for purchases above 10,000
		else
			return amount * 0.10; // 10% discount for purchases up to 10,000
	}

	/**
	 * Returns the customer type.
	 *
	 * @return String representing this customer type
	 */
	@Override
	public String getCustomerType() {
		return "Wholesale Customer";
	}
}
