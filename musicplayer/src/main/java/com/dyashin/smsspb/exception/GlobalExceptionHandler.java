package com.dyashin.smsspb.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleResourceNotFoundExcp(ResourceNotFoundException excp) {
		Map<String,Object> response = new HashMap<>();
		response.put("message", excp.getMessage());
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}

}
