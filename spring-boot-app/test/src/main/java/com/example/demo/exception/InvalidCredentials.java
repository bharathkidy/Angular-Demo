package com.example.demo.exception;

public class InvalidCredentials extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCredentials(String exception) {
		super(exception);
	}
}
