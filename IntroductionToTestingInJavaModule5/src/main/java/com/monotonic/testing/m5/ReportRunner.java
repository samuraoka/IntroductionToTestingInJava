package com.monotonic.testing.m5;

public class ReportRunner {

	public static void main(String[] args) {
		System.out.println("user.dir: " + System.getProperty("user.dir"));
		System.out.println("  arg[0]: " + args[0]);

		if (args.length < 1) {
			System.err.println("You must provide a commandline argument specifying the file to analyse");
			System.exit(-1);
		}

		SalesRepository repo = new CsvSalesRepository(args[0]);
		SalesAnalysisService analyser = new SalesAnalysisService(repo);
		SalesReport report = new SalesReport(System.out, analyser);
		report.report();
	}

}
