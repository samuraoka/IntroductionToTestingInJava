package com.monotonic.testing.m6;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class SalesRepository {

	private final String fileLocation;
	private List<Sale> sales;

	public SalesRepository(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	private int parseInt(String value) {
		return Integer.parseInt(value.trim());
	}

	public List<Sale> loadSales() {
		if (sales == null) {
			sales = new ArrayList<>();
			final File file = new File(fileLocation);
			if (!file.exists() || !file.canRead() || !file.isFile()) {
				System.err.println("Unable to find readable file: " + file.getAbsolutePath());
			}
			try (CSVReader reader = new CSVReader(new FileReader(file))) {
				String[] nextLine;
				while ((nextLine = reader.readNext()) != null) {
					String product = nextLine[0].trim();
					String store = nextLine[1].trim();
					int number = parseInt(nextLine[2]);
					int pricePerItem = parseInt(nextLine[3]);
					sales.add(new Sale(product, store, number, pricePerItem));
				}
			} catch (Exception e) {
				e.printStackTrace();
				sales = new ArrayList<>();
			}
		}
		return sales;
	}

}
