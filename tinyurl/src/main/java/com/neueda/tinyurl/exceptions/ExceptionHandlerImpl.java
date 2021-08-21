package com.neueda.tinyurl.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerImpl {

	@ExceptionHandler(ValidationFailedException.class)
	public ResponseEntity<?> handleException(final ValidationFailedException exception) {
		return new ResponseEntity<String>(exception.getMessage(), new HttpHeaders(), exception.getStatus());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(final Exception exception) {
		log.error("Unhandled exception: {}", exception.getMessage());
		return new ResponseEntity<String>(exception.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

}
