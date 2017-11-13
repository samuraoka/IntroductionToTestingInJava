package com.monotonic.testing.m4;

public class WordWrap {

	public static String wrap(final String inputLine, final int lineLength) {
		final StringBuilder accumulator = new StringBuilder();
		final int length = inputLine.length();
		
		accumulator.append(inputLine, 0, Math.min(length, lineLength));
		
		if (length > lineLength) {
			accumulator.append('\n');
			accumulator.append(inputLine, lineLength, length);
		}
		
		return accumulator.toString();
	}

}
