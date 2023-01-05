package com.marqueserick.incidentApi.infra.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorsHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity error404() {
		return ResponseEntity.notFound().build();
	}

}
