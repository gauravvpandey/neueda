package com.neueda.tinyurl.exceptions;

import org.springframework.http.HttpStatus;

public class ValidationFailedException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final HttpStatus status;
	
	public ValidationFailedException(final HttpStatus status, final String message){
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}


}
