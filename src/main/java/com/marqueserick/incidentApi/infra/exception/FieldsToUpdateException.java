package com.marqueserick.incidentApi.infra.exception;

public class FieldsToUpdateException extends RuntimeException{
	
	private String message;
	
	public FieldsToUpdateException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

}
