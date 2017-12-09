package com.monotonic.testing.m5;

import java.io.PrintStream;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class SalesModule extends AbstractModule {

	private String fileLocation;

	public SalesModule(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	@Override
	protected void configure() {
		bind(String.class).annotatedWith(Names.named("fileLocation")).toInstance(fileLocation);
		bind(PrintStream.class).toInstance(System.out);
		bind(SalesRepository.class).to(CsvSalesRepository.class);
	}

}
