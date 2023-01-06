package com.marqueserick.incidentApi.infra.exception;

import org.springframework.validation.FieldError;

public class InvalidFieldError {
	private String field;
	private String message;
	
	public InvalidFieldError(FieldError error) {
		this.field = error.getField();
		this.message = "should not be null or blank";
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}
	
	

}
