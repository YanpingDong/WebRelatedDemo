package com.dyp.springmvc.annotation.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Welcome {
	private static Logger LOG = 
			LoggerFactory.getLogger(Welcome.class);
	
	//@RequestMapping("/**")
	/*public @ResponseBody String map2All()
	{
		System.out.println("match all request URL");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.TEXT_HTML);
		return "map to all";
	}*/
	
	
	@RequestMapping("welcome")
	public String welcome()
	{
		//System.out.println("in annotation controller");
	    return "welcome";//return welcome.jsp to client
	}
	
	@RequestMapping("welcome/log")
	public String logwelcome()
	{
		//System.out.println("in annotation controller");
        LOG.error("FOR TEST PERFORMENCE");
	    return "welcome";//return welcome.jsp to client
	}
	
	@RequestMapping("/404/error")
	public void return404ErrorPage(HttpServletResponse response)
	{
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}

}
