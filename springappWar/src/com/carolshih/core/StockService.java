package com.carolshih.core;

import java.util.Map;
import java.util.TreeMap;

public class StockService {

	
	private FinanceApi financeApiService;
	
	
	public Map<String, String> getStock(String symbol, String fields){
		
		TreeMap<String, String> result = new TreeMap<String, String>();
		TreeMap<String, StockField> apiResult= (TreeMap <String, StockField>) financeApiService.getStockSymbol(symbol, fields);
		for(Map.Entry<String,StockField> entry : apiResult.entrySet()) {
			  StockField value = (StockField) entry.getValue();
			  result.put(value.getDisplayName(), value.getValue());
		}
		
		return result; 
		
	}

	public Map<String, String> getAvailableFields(){
		return financeApiService.getAvailableReportFields();
	}
	
	/**
	 * @return the financeApiService
	 */
	public FinanceApi getFinanceApiService() {
		return financeApiService;
	}

	/**
	 * @param financeApiService the financeApiService to set
	 */
	public void setFinanceApiService(FinanceApi financeApiService) {
		this.financeApiService = financeApiService;
	}
	
	

}
