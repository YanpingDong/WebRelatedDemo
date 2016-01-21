package com.dyp.buffer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BufferTest {
	private static Logger LOG = 
			LoggerFactory.getLogger(BufferTest.class);
	
	@RequestMapping("buffer/log")
	public String logwelcome()
	{
		//System.out.println("in annotation controller");
        LOG.error("FOR TEST PERFORMENCE BY BUFFER");
	    return "welcome";//return welcome.jsp to client
	}
}
