package com.monotonic.testing.m5;

public class ReportRunner {

	public static void main(String[] args) {
		System.out.println("user.dir: " + System.getProperty("user.dir"));
		System.out.println("  arg[0]: " + args[0]);
		
		if (args.length < 1) {
			System.err.println("You must provide a commandline argument specifying the file to analyse");
			System.exit(-1);
		}

		SalesReport report = new SalesReport(System.out, args[0]);
		report.report();
	}

}
