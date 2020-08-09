package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

//	add an exception for customer not found 

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc) {

//		create customerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(),
				System.currentTimeMillis());

//		create response entity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}
//	add an exception to catch all exceptions

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc) {

//		create customerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(),
				System.currentTimeMillis());

//		create response entity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
}
