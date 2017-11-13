package com.monotonic.testing.m4;

public class WordWrap {

	public static String wrap(final String inputLine, final int lineLength) {
		final StringBuilder accumulator = new StringBuilder();
		
		accumulator.append(inputLine, 0, Math.min(inputLine.length(), lineLength));
		
		if (inputLine.length() > lineLength) {
			accumulator.append('\n');
			accumulator.append(inputLine, lineLength, inputLine.length());
		}
		
		return accumulator.toString();
	}

}
