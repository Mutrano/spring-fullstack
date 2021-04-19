package com.mutrano.demo.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mutrano.demo.services.exceptions.DataIntegrityException;
import com.mutrano.demo.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException expn, HttpServletRequest request) {
		String error = "Resource not Found";
		HttpStatus statusCode= HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(),statusCode.value(),error, expn.getMessage(),request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrityException(DataIntegrityException expn, HttpServletRequest request){
		String error = "Data Integrity";
		HttpStatus statusCode= HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(),statusCode.value(),error, expn.getMessage(),request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
}