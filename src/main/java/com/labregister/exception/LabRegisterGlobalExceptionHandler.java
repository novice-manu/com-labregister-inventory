package com.labregister.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.labregister.util.ApplicationConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class LabRegisterGlobalExceptionHandler {

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> handleDataIntegrationException(SQLIntegrityConstraintViolationException ex) {

		log.info("SQL Exception {}", ex.getLocalizedMessage());

		ErrorResponse error = ErrorResponse.builder().code(1001).details(ApplicationConstants.MANDATORY_FIELD_MISSING)
				.message(ex.getLocalizedMessage()).build();

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCategoryNotFoundException(CategoryNotFoundException ex) {

		log.info("CategoryNotFoundException {}", ex.getLocalizedMessage());
		return new ResponseEntity<>(ErrorResponse.builder().code(ex.getStatusCode()).details(ex.getDetails())
				.message(ex.getErrorMessage()).build(), HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleItemNotFoundException(ItemNotFoundException ex) {

		log.info("CategoryNotFoundException {}", ex.getLocalizedMessage());
		return new ResponseEntity<>(ErrorResponse.builder().code(ex.getStatusCode()).details(ex.getDetails())
				.message(ex.getErrorMessage()).build(), HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

		log.info("SQL Exception {}", ex.getLocalizedMessage());

		ErrorResponse error = ErrorResponse.builder().code(1002).details(ex.getLocalizedMessage())
				.message(ex.getFieldError("name").getDefaultMessage()).build();

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
}
