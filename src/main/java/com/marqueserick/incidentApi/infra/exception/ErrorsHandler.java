package com.marqueserick.incidentApi.infra.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorsHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity error404(NotFoundException ex) {
		return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity error400(MethodArgumentNotValidException exception) {
		return ResponseEntity.badRequest()
				.body(exception.getFieldErrors()
						.stream().map(InvalidFieldError::new).collect(Collectors.toList()));
	}

}
