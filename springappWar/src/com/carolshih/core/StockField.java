package com.carolshih.core;

public class StockField {
	String displayName;
	String fieldName;
	String value;
	
	public StockField(String dName, String fName, String value){
		this.displayName=dName;
		this.fieldName=fName;
		this.value=value;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
