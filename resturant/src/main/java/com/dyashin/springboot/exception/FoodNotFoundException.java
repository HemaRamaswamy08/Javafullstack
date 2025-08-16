package com.dyashin.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FoodNotFoundException extends RuntimeException {

	public FoodNotFoundException(String msg) {
		super(msg);
	}

}
