package com.monotonic.testing.m6;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class SalesRepositoryTest {

	@Test
	public void shouldLoadSampleData() {
		SalesRepository repository = new SalesRepository("src/main/resources/example-sales.csv");

		List<Sale> sales = repository.loadSales();

		// London, 2, 30
		assertThat(sales, hasItem(allOf(hasProperty("store", equalTo("London")), hasProperty("number", equalTo(2)),
				hasProperty("pricePerItem", equalTo(30)))));

		// London, 1, 15
		assertThat(sales, hasItem(allOf(hasProperty("store", equalTo("London")), hasProperty("number", equalTo(1)),
				hasProperty("pricePerItem", equalTo(15)))));

		// London, 4, 40
		assertThat(sales, hasItem(allOf(hasProperty("store", equalTo("London")), hasProperty("number", equalTo(4)),
				hasProperty("pricePerItem", equalTo(40)))));

		// Cardiff, 10, 25
		assertThat(sales, hasItem(allOf(hasProperty("store", equalTo("Cardiff")), hasProperty("number", equalTo(10)),
				hasProperty("pricePerItem", equalTo(25)))));
	}

}
