package com.labregister.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryNotFoundException extends RuntimeException {

	private final String status;

	private final Integer statusCode;
	
	private final String errorMessage;

	private final String details;

	public CategoryNotFoundException(String status, Integer statusCode, String errorMessage, String details, Throwable throwable) {
		
		super(errorMessage,throwable);
		this.status = status;
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
		this.details = details;
	
}
}
