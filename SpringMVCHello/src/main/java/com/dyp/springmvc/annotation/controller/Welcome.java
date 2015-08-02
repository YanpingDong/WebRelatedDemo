package com.dyp.springmvc.annotation.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Welcome {
	
	@RequestMapping("/**")
	public void map2All()
	{
		System.out.println("match all request URL");
	}
	
	
	@RequestMapping("welcome")
	public String welcome()
	{
		System.out.println("in annotation controller");
	    return "welcome";//return welcome.jsp to client
	}
	
	@RequestMapping("/404/error")
	public void return404ErrorPage(HttpServletResponse response)
	{
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}

}
