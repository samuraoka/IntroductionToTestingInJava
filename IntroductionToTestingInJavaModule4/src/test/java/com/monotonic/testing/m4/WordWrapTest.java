package com.monotonic.testing.m4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordWrapTest {

	public static final int LINE_LENGTH = 5;

	// a method that breaks words on specified space with new line. Like a word
	// processor would.

	@Test
	public void lineShouldWrapIfOverLineLength() {
		String result = WordWrap.wrap("The Sleepy", LINE_LENGTH);
		assertEquals("The S\nleepy", result);
	}
}
