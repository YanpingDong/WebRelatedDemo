package com.dyp.springmvc.annotation.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Welcome {
	
	@RequestMapping("/welcome")
	public String welcome()
	{
		System.out.println("in annotation controller");
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json");
	    return "welcome";
	}
	
	@RequestMapping("/404/error")
	public void return404ErrorPage(HttpServletResponse response)
	{
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}
}
