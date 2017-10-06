package com.monotonic.testing.m2;

/**
 * A coffee shop that can brew coffee and maintains an internal stock of beans
 * and milk.
 *
 */
public class Cafe {

	private int beansInStock = 0;
	private int milkInStock = 0;

	// TODO add constructor here

	public Coffee brew(CoffeeType coffeeType) { // TODO modify this methods parameter
		int requiredBeans = coffeeType.getRequiredBeans();
		int requiredMilk = coffeeType.getRequiredMilk();
		if (requiredBeans > beansInStock || requiredMilk > milkInStock) {
			throw new IllegalStateException("Insufficient beans or milk");
		}

		beansInStock -= requiredBeans;
		milkInStock -= requiredMilk;
		return new Coffee(coffeeType, requiredBeans, requiredMilk);
	}

	public void restockBeans(int weightInGrams) {
		requirePositive(weightInGrams);
		beansInStock += weightInGrams;
	}

	// TODO add methods here

	private void requirePositive(int value) {
		if (value < 1) {
			throw new IllegalArgumentException();
		}
	}

	public int getBeansInStock() {
		return beansInStock;
	}

	// TODO add methods here

}
