package com.dyp.flume.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FlumeTest {
	private static Logger LOG = 
			LoggerFactory.getLogger(FlumeTest.class);
	@RequestMapping("flume/log")
	public String flumewelcome()
	{
        LOG.error("TEST PERFORMENCE, TO FLUME");
	    return "welcome";//return welcome.jsp to client
	}
}
