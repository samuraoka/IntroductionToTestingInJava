package com.monotonic.testing.m5;

import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVReader;

@Component
public class CsvSalesRepository implements SalesRepository {

	private final String fileLocation;
	private PrintStream error;
	private List<Sale> sales;

	@Autowired
	public CsvSalesRepository(@Qualifier("fileLocation") String fileLocation) {
		this.fileLocation = fileLocation;
		error = System.out;
	}

	public void setError(PrintStream error) {
		this.error = error;
	}

	private int parseInt(String value) {
		return Integer.parseInt(value.trim());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.monotonic.testing.m5.SalesRepository#loadSales()
	 */
	@Override
	public List<Sale> loadSales() {
		if (sales == null) {
			sales = new ArrayList<>();
			try (CSVReader reader = new CSVReader(new FileReader(fileLocation))) {
				String[] nextLine;
				while ((nextLine = reader.readNext()) != null) {
					String product = nextLine[0].trim();
					String store = nextLine[1].trim();
					int number = parseInt(nextLine[2]);
					int pricePerItem = parseInt(nextLine[3]);
					sales.add(new Sale(product, store, number, pricePerItem));
				}
			} catch (Exception e) {
				e.printStackTrace(error);
				sales = new ArrayList<>();
			}
		}
		return sales;
	}

}
