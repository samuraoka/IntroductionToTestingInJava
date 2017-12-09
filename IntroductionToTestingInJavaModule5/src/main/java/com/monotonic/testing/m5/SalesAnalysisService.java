package com.monotonic.testing.m5;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import java.util.Map;
import java.util.function.Function;

import com.google.inject.Inject;

public class SalesAnalysisService {

	private final SalesRepository repo;

	@Inject
	public SalesAnalysisService(SalesRepository repository) {
		this.repo = repository;
	}

	public Map<String, Integer> tallyStoreSales() {
		return tallySalesBy(Sale::getStore);
	}

	public Map<String, Integer> tallyProductSales() {
		return tallySalesBy(Sale::getProduct);
	}

	private Map<String, Integer> tallySalesBy(Function<Sale, String> classifier) {
		return repo.loadSales().stream().collect(groupingBy(classifier, summingInt(Sale::getValue)));
	}

}
