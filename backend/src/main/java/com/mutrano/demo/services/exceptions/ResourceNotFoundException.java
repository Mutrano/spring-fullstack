package com.mutrano.demo.services.exceptions;

public class ResourceNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super();
		
	}

	public ResourceNotFoundException(String message) {
		super(message);
		
	}

}
