package com.student.student_rest_api.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//Here You Can Handle All The Exceptions.
@RestControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(DataAlreadyExistsException.class)
	public ResponseEntity<HashMap<String, String>>handle(DataAlreadyExistsException exception){
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("message", exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<HashMap<String,String>> handle(DataNotFoundException exception){
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("message", exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		
	}

	

}
