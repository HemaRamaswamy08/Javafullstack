package com.dyashin.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("cookies")
public class CookiesController {

	@RequestMapping("/getCookiesPage")
	public String getCookies() {
		return "cookies";

	}

	@RequestMapping("/createCookie")
	public String createCookies(HttpServletResponse res, ModelMap madelMap) {
		Cookie cookies = new Cookie("name", "hema");
		res.addCookie(cookies);
		madelMap.addAttribute("msg", "myCookie added tp response");
		return "cookies";

	}

	@GetMapping("/readCookie")
	public String readCookies(@CookieValue("name") String myCookieValue, ModelMap modelMap) {
		modelMap.addAttribute("msg", myCookieValue);
		return "cookies";

	}

}
