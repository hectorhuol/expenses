package com.financial.analisys.expenses.rest.api.error.model;

public class ErrorModel {
	
	private String message;
	private String errorURI;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorURI() {
		return errorURI;
	}

	public void setErrorURI(String error) {
		this.errorURI = error;
	}
}
