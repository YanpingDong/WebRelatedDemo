package com.dyp.springmvc.annotation.controller;

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

}
