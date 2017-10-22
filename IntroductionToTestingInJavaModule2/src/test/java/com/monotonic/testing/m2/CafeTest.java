package com.monotonic.testing.m2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CafeTest {

	private static final int NO_BEANS = 0;
	private static final int NO_MILK = 0;
	private static final int ESPRESSO_BEANS = CoffeeType.Espresso.getRequiredBeans();

	// TODO remove unnecessary methods
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void canBrewEspresso() {
		// given
		Cafe cafe = cafeWithBeans();

		// when
		Coffee coffee = cafe.brew(CoffeeType.Espresso);

		// then
		assertEquals("Wrong number of beans", ESPRESSO_BEANS, coffee.getBeans());
		assertEquals("Wrong amount of milk", NO_MILK, coffee.getMilk());
		assertEquals("Wrong coffee type", CoffeeType.Espresso, coffee.getType());
	}

	@Test
	public void brewingEspressoConsumesBeans() {
		Cafe cafe = cafeWithBeans();

		// when
		cafe.brew(CoffeeType.Espresso);

		// then
		assertEquals(NO_BEANS, cafe.getBeansInStock());
	}

	@Test
	public void canBrewLatte() {
		Cafe cafe = cafeWithBeans();
		cafe.restockMilk(CoffeeType.Latte.getRequiredMilk());

		// when
		Coffee coffee = cafe.brew(CoffeeType.Latte);

		// then
		assertEquals("Wrong coffee type", CoffeeType.Latte, coffee.getType());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void mustRestockMilk() {
		// given
		Cafe cafe = new Cafe();
		
		// when
		cafe.restockMilk(NO_MILK);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void mustRestockBeans() {
		// given
		Cafe cafe = new Cafe();
		
		// when
		cafe.restockBeans(NO_BEANS);
	}

	// then
	@Test(expected = IllegalStateException.class)
	public void latteRequiresMilk() {
		Cafe cafe = cafeWithBeans();

		// when
		cafe.brew(CoffeeType.Latte);
	}

	private Cafe cafeWithBeans() {
		Cafe cafe = new Cafe();
		cafe.restockBeans(ESPRESSO_BEANS);
		return cafe;
	}

}
