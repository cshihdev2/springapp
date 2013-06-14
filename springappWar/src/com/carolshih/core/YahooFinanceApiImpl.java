package com.carolshih.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;


/**
 * @author carol
 * This is a concrete class that implements FinanceApi. 
 * The class is used to make API to Yahoo Finance 
 */
public class YahooFinanceApiImpl implements FinanceApi{
	
	
	private static YahooFinanceApiImpl instance; 
	private Properties prop;
	private String endpointUrl;
	
	private YahooFinanceApiImpl(Properties prop){
		this.prop=prop; 
	}
	
	public static YahooFinanceApiImpl getInstance(Properties prop, String endpointUrl){
		
		if(instance==null && prop!=null){
			instance = new YahooFinanceApiImpl(prop);
			instance.endpointUrl=endpointUrl;
		}
		return instance;
	}
	

	public Map<String, String> getAvailableReportFields(){
			HashMap<String, String> keyFields = new HashMap<String, String>((Map)this.prop);
			return keyFields;
		
	}
	public Map<String, StockField> getStockSymbol(String symbol, String fields){
		
		TreeMap<String, StockField> result = new TreeMap<String, StockField>();
		BufferedReader reader = null;
		try {
			String qurl = URLDecoder.decode(this.endpointUrl, "UTF-8") + "s="+symbol+"&f="+fields;
			URL url = new URL(qurl);
			String [] keys = fields.split(",");
		    reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		  
		    // each line represent each symbol. For the demo purpose, there is only 1 line
			for (String line; (line = reader.readLine()) != null;) {
			    
			    // provide the list of value from API
			    String[] values = line.split(",");
			    for( int i = 0; i <= keys.length - 1; i++){
			    	// Yahoo Finance API seems to return extra symbol in between fields. Skip to value by using 2*index
			    	StockField fieldIem = new StockField(this.prop.getProperty(keys[i]), keys[i], values[2*i]);
			    	result.put(keys[i], fieldIem);
			    }
			}
			
		}catch (IOException e) {			
			e.printStackTrace();
		} finally {
			if (reader != null){ 
				try { reader.close(); 
				} catch (IOException ignore) {}
			}
		}	
		
		return result;
		
	}

	/**
	 * @return the endpointUrl
	 */
	public String getEndpointUrl() {
		return endpointUrl;
	}

	/**
	 * @param endpointUrl the endpointUrl to set
	 */
	public void setEndpointUrl(String endpointUrl) {
		this.endpointUrl = endpointUrl;
	}
	
	
}
