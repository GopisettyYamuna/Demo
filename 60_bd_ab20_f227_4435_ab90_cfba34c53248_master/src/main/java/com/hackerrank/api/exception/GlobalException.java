package com.hackerrank.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hackerrank.api.model.Vulnerability;

@ControllerAdvice
@ResponseStatus
public class GlobalException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = ElementNotFoundException.class)
	public ResponseEntity<Vulnerability> handleElementNotFoundException(ElementNotFoundException ex,WebRequest request){
		Vulnerability vr = new Vulnerability();
		ex.getMessage();
		return new  ResponseEntity<Vulnerability>(vr,HttpStatus.NOT_FOUND);
	}
	
	
	
	

	
}
