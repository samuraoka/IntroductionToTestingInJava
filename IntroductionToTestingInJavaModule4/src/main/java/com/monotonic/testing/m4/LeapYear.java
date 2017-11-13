package com.monotonic.testing.m4;

public class LeapYear {

	public static boolean isLeapYear(int year) {
		return year % 4 == 0 && !(year % 100 == 0);
	}

}
