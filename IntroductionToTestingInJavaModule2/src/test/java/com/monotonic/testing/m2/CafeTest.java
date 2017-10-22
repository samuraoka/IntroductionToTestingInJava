package com.monotonic.testing.m2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CafeTest {

	private static final int NO_BEANS = 0;
	private static final int NO_MILK = 0;
	private static final int ESPRESSO_BEANS = CoffeeType.Espresso.getRequiredBeans();

	private Cafe cafe;

	@Before
	public void setUp() throws Exception {
		cafe = new Cafe();
	}

	@Test
	public void canBrewEspresso() {
		// given
		withBeans();

		// when
		Coffee coffee = cafe.brew(CoffeeType.Espresso);

		// then
		assertEquals("Wrong number of beans", ESPRESSO_BEANS, coffee.getBeans());
		assertEquals("Wrong amount of milk", NO_MILK, coffee.getMilk());
		assertEquals("Wrong coffee type", CoffeeType.Espresso, coffee.getType());
	}

	@Test
	public void brewingEspressoConsumesBeans() {
		withBeans();

		// when
		cafe.brew(CoffeeType.Espresso);

		// then
		assertEquals(NO_BEANS, cafe.getBeansInStock());
	}

	@Test
	public void canBrewLatte() {
		withBeans();
		cafe.restockMilk(CoffeeType.Latte.getRequiredMilk());

		// when
		Coffee coffee = cafe.brew(CoffeeType.Latte);

		// then
		assertEquals("Wrong coffee type", CoffeeType.Latte, coffee.getType());
	}

	@Test(expected = IllegalArgumentException.class)
	public void mustRestockMilk() {
		// when
		cafe.restockMilk(NO_MILK);
	}

	@Test(expected = IllegalArgumentException.class)
	public void mustRestockBeans() {
		// when
		cafe.restockBeans(NO_BEANS);
	}

	@Test(expected = IllegalStateException.class)
	public void latteRequiresMilk() {
		// given
		withBeans();

		// when
		cafe.brew(CoffeeType.Latte);
	}

	private void withBeans() {
		cafe.restockBeans(ESPRESSO_BEANS);
	}

}
