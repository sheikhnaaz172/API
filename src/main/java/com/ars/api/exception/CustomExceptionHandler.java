package com.ars.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> resourceNotFoundExceptionById(ResourceNotFoundException e, WebRequest req) {
		ErrorResponse er= new ErrorResponse(e.getMessage(),HttpStatus.NOT_FOUND.value(), req.getDescription(false));
		return new ResponseEntity<>(er , HttpStatus.NOT_FOUND);
		 
		
		
	}
}