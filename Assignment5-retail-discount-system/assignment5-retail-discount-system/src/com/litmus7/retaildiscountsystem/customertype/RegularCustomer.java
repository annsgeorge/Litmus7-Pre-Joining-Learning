package com.litmus7.retaildiscountsystem.customertype;

/**
 * RegularCustomer implements the Discountable interface and provides a fixed
 * discount rate for regular customers.
 */
public class RegularCustomer implements Discountable {

	/**
	 * Applies a flat 5% discount on the total purchase amount.
	 *
	 * @param amount Total purchase amount
	 * @return Calculated discount (5% of amount)
	 */
	@Override
	public double applyDiscount(double amount) {
		return amount * 0.05; // 5% discount
	}

	/**
	 * Returns the customer type.
	 *
	 * @return String representing this customer type
	 */
	@Override
	public String getCustomerType() {
		return "Regular Customer";
	}
}
