package com.monotonic.testing.m5;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ReportRunner {
	private static final Logger LOGGER = Logger.getLogger(ReportRunner.class.getName());

	public static void main(String[] args) {
		LOGGER.log(Level.FINE, "user.dir: {0}", System.getProperty("user.dir"));
		LOGGER.log(Level.FINE, "  arg[0]: {0}", args[0]);

		if (args.length < 1) {
			System.err.println("You must provide a commandline argument specifying the file to analyse");
			System.exit(-1);
		}

		// Google Guice Core Library
		// http://mvnrepository.com/artifact/com.google.inject/guice
		Injector injector = Guice.createInjector(new SalesModule(args[0]));
		SalesReport report = injector.getInstance(SalesReport.class);
		report.report();
	}

}
