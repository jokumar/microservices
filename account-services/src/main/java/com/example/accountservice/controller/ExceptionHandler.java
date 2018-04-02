package com.example.accountservice.controller;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.accountservice.entity.ExceptionResponse;

@ControllerAdvice
@RestController
public class ExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
	  {
		ExceptionResponse exp= new ExceptionResponse(ex.getMessage(),ex.getBindingResult().toString(),new Date());
		return new ResponseEntity<Object>(exp,HttpStatus.BAD_REQUEST);
		
	  }
	
}
