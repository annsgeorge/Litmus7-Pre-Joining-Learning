package com.litmus7.retaildiscountsystem;

import java.util.Scanner;

import com.litmus7.retaildiscountsystem.customertype.Discountable;
import com.litmus7.retaildiscountsystem.customertype.PremiumCustomer;
import com.litmus7.retaildiscountsystem.customertype.RegularCustomer;
import com.litmus7.retaildiscountsystem.customertype.WholesaleCustomer;

/**
 * RetailStoreApp is the main class that simulates a simple retail store
 * discount system based on different types of customers.
 */
public class RetailStoreApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Discountable discountable; // Interface reference for applying discounts
		double discount;
		String customerType;

		// Allow repeated operations until user exits
		while (true) {
			// Display menu
			System.out.println("\nEnter customer type :\n1.Regular\n2.Premium\n3.Wholesale\n4.Exit");
			int choice = scanner.nextInt();

			// Exit condition
			if (choice == 4) {
				System.out.println("Exiting....");
				scanner.close();
				return;
			}

			// Prompt user for total purchase amount
			System.out.println("\nEnter total purchase amount:");
			double totalPurchaseAmount = scanner.nextDouble();

			// Instantiate appropriate customer type based on user input
			switch (choice) {
			case 1:
				discountable = new RegularCustomer();
				break;

			case 2:
				discountable = new PremiumCustomer();
				break;

			case 3:
				discountable = new WholesaleCustomer();
				break;

			default:
				System.out.println("Invalid choice. Please try again.");
				continue; // Repeats the loop
			}

			// Apply discount and fetch customer type
			discount = discountable.applyDiscount(totalPurchaseAmount);
			customerType = discountable.getCustomerType();

			// Display results
			System.out.print("\nCustomer Type : " + customerType);
			System.out.printf("\nOriginal Amount : Rs. %.2f", totalPurchaseAmount);
			System.out.printf("\nDiscount Applied : Rs. %.2f", discount);
			System.out.printf("\nFinal Payable Amount : Rs. %.2f", (totalPurchaseAmount - discount));
		}
	}
}
