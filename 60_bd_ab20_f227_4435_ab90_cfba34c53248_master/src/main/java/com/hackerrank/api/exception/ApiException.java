package com.hackerrank.api.exception;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiException {
	
	private final String message;
	private final  HttpStatus httpStatus;
	
	public ApiException(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	

}
