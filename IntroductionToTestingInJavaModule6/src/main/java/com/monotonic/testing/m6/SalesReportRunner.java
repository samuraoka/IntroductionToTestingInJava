package com.monotonic.testing.m6;

import java.io.PrintStream;

public class SalesReportRunner 
{
	private final PrintStream out;
	
	public static void main( String[] args )
    {
    	String fileLocation = args[0];
    	new SalesReportRunner(System.out).run(fileLocation);
    }

    public SalesReportRunner(PrintStream out) {
    	this.out = out;
	}

	public void run(String fileLocation) {
		out.println("Hello, world");
	}
}
