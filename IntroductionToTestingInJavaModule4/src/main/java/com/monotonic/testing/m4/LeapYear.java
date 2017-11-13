package com.monotonic.testing.m4;

public class LeapYear {

	public static boolean isLeapYear(int year) {
		return isDivisible(year, 4) && (isNotDivisible(year, 100) || isDivisible(year, 400));
	}

	private static boolean isDivisible(final int year, final int denominator) {
		return year % denominator == 0;
	}
	
	private static boolean isNotDivisible(final int year, final int denominator) {
		return !isDivisible(year, denominator);
	}

}
