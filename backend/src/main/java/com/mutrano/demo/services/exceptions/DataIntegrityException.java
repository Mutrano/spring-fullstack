package com.mutrano.demo.services.exceptions;

public class DataIntegrityException extends Exception{
	private static final long serialVersionUID = 1L;

	public DataIntegrityException() {
		super();
		
	}

	public DataIntegrityException(String message) {
		super(message);
		
	}

}
