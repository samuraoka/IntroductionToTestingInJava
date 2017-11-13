package com.monotonic.testing.m4;

public class LeapYear {

	public static boolean isLeapYear(int year) {
		return isDivisible(year, 4) && isNotDivisible(year, 100);
	}

	private static boolean isDivisible(int year, int denominator) {
		return year % denominator == 0;
	}
	
	private static boolean isNotDivisible(int year, int denominator) {
		return !isDivisible(year, denominator);
	}

}
