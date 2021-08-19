package com.neueda.tinyurl.validation;

public interface Validator<T> {
	
	void validate(T entity);
	
}
