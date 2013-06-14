package com.carolshih.core;

import java.util.Map;

public interface FinanceApi {
	public Map<String, StockField> getStockSymbol(String symbol, String fields);
	public Map<String, String> getAvailableReportFields();
}
