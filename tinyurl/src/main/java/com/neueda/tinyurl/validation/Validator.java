package com.neueda.tinyurl.validation;

public interface Validator<T> {
	
	boolean validate(T entity);
	
}
