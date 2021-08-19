package com.neueda.tinyurl.support;

import org.springframework.http.HttpStatus;

import com.neueda.tinyurl.exceptions.ValidationFailedException;
import com.neueda.tinyurl.model.UrlRequest;
import com.neueda.tinyurl.utils.Constants;
import com.neueda.tinyurl.validation.Validator;

public class MockValidator implements Validator<UrlRequest>{

	public boolean valid;

	@Override
	public void validate(UrlRequest entity) {
		if(!valid)
			throw new ValidationFailedException(HttpStatus.BAD_REQUEST, Constants.INVALID_URL);
	}

}
