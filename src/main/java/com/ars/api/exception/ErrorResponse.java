package com.ars.api.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	public ErrorResponse() {
		// TODO Auto-generated constructor stub
	}
	private String message;
	private Integer statusCode;
	private String errorDetails;
	
	
	
	public ErrorResponse(String message, Integer statusCode,String errorDetails) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.errorDetails=errorDetails;
	}
	public ErrorResponse(String message2, HttpStatus notFound) {
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	

}
