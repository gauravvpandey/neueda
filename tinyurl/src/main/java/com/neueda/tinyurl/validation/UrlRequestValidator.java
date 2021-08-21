package com.neueda.tinyurl.validation;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.http.HttpStatus;

import com.neueda.tinyurl.exceptions.ValidationFailedException;
import com.neueda.tinyurl.model.UrlRequest;
import com.neueda.tinyurl.utils.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UrlRequestValidator implements Validator<UrlRequest> {

	private UrlValidator urlValidator;

	public UrlRequestValidator(UrlValidator urlValidator) {
		this.urlValidator = urlValidator;
	}

	@Override
	public boolean validate(final UrlRequest request) {
		if (request == null || !urlValidator.isValid(request.getNormalUrl())) {
			log.info("Validation failed: {}, UrlRequest: {}",
					UrlRequestValidator.class.getSimpleName(), request);
			throw new ValidationFailedException(HttpStatus.BAD_REQUEST, Constants.INVALID_URL);
		}
		return true;
	}

}
