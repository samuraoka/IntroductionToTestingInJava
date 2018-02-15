package com.monotonic.testing.m6;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.junit.Test;

public class SalesReportSystemTest {

	@Test
	public void shouldPrintStoreReportForSampleData() {
		ApplicationRunner runner = new ApplicationRunner();
		
		String report = runner.run("src/main/resources/example-sales.csv");
		
		assertThat(report, containsString("- London          -    235 -"));
	}
}
