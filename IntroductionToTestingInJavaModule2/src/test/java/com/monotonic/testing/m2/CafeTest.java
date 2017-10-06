package com.monotonic.testing.m2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CafeTest {

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
		Cafe cafe = new Cafe();
		cafe.restockBeans(7);
		
		Coffee coffee = cafe.brew(CoffeeType.Espresso);
		
		// it is an espresso!
		// no milk
		// that we've got enough coffee
		assertEquals(CoffeeType.Espresso, coffee.getType());
		assertEquals(0, coffee.getMilk());
		assertEquals(7, coffee.getBeans());
	}

}
