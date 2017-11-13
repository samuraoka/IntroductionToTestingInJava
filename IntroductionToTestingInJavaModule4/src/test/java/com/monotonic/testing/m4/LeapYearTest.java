package com.monotonic.testing.m4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LeapYearTest {

	// a year is a leap year if it is divisible by four
	// but, years divisible by 100, are not leap years.
	// except year divisible by 400

	@Test
	public void LeapYearsAreDivisibleByFour() {
		assertTrue(LeapYear.isLeapYear(2020));
	}

	@Test
	public void normalYearsAreNoDivisibleByFour() {
		assertFalse(LeapYear.isLeapYear(2021));
	}
	
	@Test
	public void leapYearsAreNotDivisibleByOneHundred() {
		assertFalse(LeapYear.isLeapYear(2100));
	}

}
