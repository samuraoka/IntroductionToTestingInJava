package com.monotonic.testing.m5;

import java.io.PrintStream;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReportRunner {

	private static String fileLocation;

	public static void main(String[] args) {
		System.out.println("user.dir: " + System.getProperty("user.dir"));
		System.out.println("  arg[0]: " + args[0]);

		if (args.length < 1) {
			System.err.println("You must provide a commandline argument specifying the file to analyse");
			System.exit(-1);
		}

		fileLocation = args[0];

		// Spring Context
		// http://mvnrepository.com/artifact/org.springframework/spring-context
		try (ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext(
				"com/monotonic/testing/m5/application-context.xml")) {
			SalesReport report = xmlContext.getBean(SalesReport.class);
			report.report();
		}
	}

	public static PrintStream getOutput() {
		return System.out;
	}

	public static String getFileLocation() {
		return fileLocation;
	}

}