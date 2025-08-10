package com.dyashin.springmvc.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(Model model, NullPointerException ex) {
		model.addAttribute("errorMessage", "Null pointer occured:" + ex.getMessage());
		return "errorPage";
	}

	@ExceptionHandler(IllegalStateException.class)
	public String handleIllegalStateException(Model model, IllegalStateException ex) {
		model.addAttribute("errorMessage", "An IllegalStateException  occured:" + ex.getMessage());
		return "errorPage";

	}

	@ExceptionHandler(Exception.class)
	public String handleException(Model model, Exception ex) {
		model.addAttribute("errorMessage", "An error pointer occured:" + ex.getMessage());
		return "errorPage";
	}

}
