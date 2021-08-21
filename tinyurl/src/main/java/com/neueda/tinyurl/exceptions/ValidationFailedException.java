package com.neueda.tinyurl.exceptions;

import org.springframework.http.HttpStatus;

public class ValidationFailedException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	
	public ValidationFailedException(final HttpStatus status, final String message){
		super(message);
		this.setStatus(status);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
