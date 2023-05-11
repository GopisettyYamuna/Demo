package com.hackerrank.api.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice

public class GlobalException {
	
	@ExceptionHandler(value = ElementNotFoundException.class)

	public ResponseEntity<?> handleElementNotFoundException(ElementNotFoundException ex,WebRequest request){
		
		String message = ex.getMessage();
		if(message == null) message=ex.toString();
		 ApiException vr =  new ApiException(message,HttpStatus.NOT_FOUND);
		
		return new  ResponseEntity<>(vr,new HttpHeaders(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = BadRequestException.class)

	public ResponseEntity<?> handleBadRequestException(BadRequestException ex,WebRequest request){
		
		String message = ex.getMessage();
		if(message == null) message=ex.toString();
		 ApiException vr =  new ApiException(message,HttpStatus.NOT_FOUND);
		
		return new  ResponseEntity<>(vr,new HttpHeaders(),HttpStatus.NOT_FOUND);
	}
	
	

	
}
