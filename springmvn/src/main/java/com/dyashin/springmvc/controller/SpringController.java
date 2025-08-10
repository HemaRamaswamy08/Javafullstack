package com.dyashin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class SpringController {

	@GetMapping("/hello")
	public ModelAndView display() {
		ModelAndView view = new ModelAndView();
		view.setViewName("hello"); // jsp file name
		return view;
	}

	@GetMapping("/check")
	public String checkException() {
		String a= null;
		a.length();
		return "gydyhihuf";
	}
}
