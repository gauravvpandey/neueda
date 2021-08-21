package com.neueda.tinyurl.validation;

public interface Validator<T> {
	
	boolean validate(final T entity);
	
}
