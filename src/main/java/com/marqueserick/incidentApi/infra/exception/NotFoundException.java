package com.marqueserick.incidentApi.infra.exception;

public class NotFoundException extends RuntimeException {
	private String message;
	
	public NotFoundException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
