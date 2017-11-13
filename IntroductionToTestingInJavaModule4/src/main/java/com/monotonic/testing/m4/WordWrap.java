package com.monotonic.testing.m4;

public class WordWrap {

	public static String wrap(final String inputLine, final int lineLength) {
		final StringBuilder accumulator = new StringBuilder();
		final int length = inputLine.length();
		
		for (int i = 0; i < length; i += lineLength) {
			int split = i + lineLength;
			accumulator.append(inputLine, i, Math.min(length, split));
			if (length > split) {
				accumulator.append('\n');
			}
		}
		
		return accumulator.toString();
	}

}
