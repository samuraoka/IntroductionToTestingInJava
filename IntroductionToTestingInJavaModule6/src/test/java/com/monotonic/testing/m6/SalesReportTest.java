package com.monotonic.testing.m6;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class SalesReportTest {

	private final int TALLY = 235;
	private final String CITY = "London";

	// mockito - mocking framework for unit tests in Java
	// http://site.mockito.org/
	private PrintStream mockOut = mock(PrintStream.class);
	private SalesAnalyser mockAnalyser = mock(SalesAnalyser.class);
	private SalesReport report = new SalesReport(mockAnalyser, mockOut);

	@Test
	public void shouldPrintCityTallies() {
		Map<String, Integer> cityTallies = new HashMap<>();
		cityTallies.put(CITY, TALLY);
		when(mockAnalyser.tallyCitySales()).thenReturn(cityTallies);

		report.run();

		verify(mockOut).printf(anyString(), eq(CITY), eq(TALLY));
	}

}
