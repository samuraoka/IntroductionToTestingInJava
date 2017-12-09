package com.monotonic.testing.m5;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class SalesAnalysisServiceWithHandWrittenStubTest {

	private static final List<Sale> exampleSales = Arrays.asList(new Sale("Apples", "Cardiff", 10, 2),
			new Sale("Oranges", "Cardiff", 3, 5), new Sale("Bananas", "Cardiff", 6, 20),
			new Sale("Oranges", "London", 5, 7));

	private static final Map<String, Integer> expectedStoreSales = new HashMap<>();
	static {
		expectedStoreSales.put("Cardiff", 155);
		expectedStoreSales.put("London", 35);
	}

	@Test
	public void shouldAggregateStoreSales() {
		// given
		//
		// Mockito Mock objects library for java
		// http://mvnrepository.com/artifact/org.mockito/mockito-all/1.10.19
		//
		// Mockito - Official Site
		// http://site.mockito.org/
		SalesRepository mockRepo = mock(SalesRepository.class);
		when(mockRepo.loadSales()).thenReturn(exampleSales);
		SalesAnalysisService analysisService = new SalesAnalysisService(mockRepo);

		// when
		Map<String, Integer> storeSales = analysisService.tallyStoreSales();

		// then
		assertEquals(expectedStoreSales, storeSales);
		verify(mockRepo).loadSales();
	}

}
