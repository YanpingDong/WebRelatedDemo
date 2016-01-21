package com.dyp.async.flume.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AsyncFlumeTest {
	private static Logger LOG = 
			LoggerFactory.getLogger(AsyncFlumeTest.class);
	
	@RequestMapping("async/flume/log")
	public String logwelcome()
	{
        LOG.error("FOR TEST PERFORMENCE, ASYNC FLUME");
	    return "welcome";//return welcome.jsp to client
	}
}
