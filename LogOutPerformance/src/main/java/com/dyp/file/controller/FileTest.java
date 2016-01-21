package com.dyp.file.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileTest {
	private static Logger LOG = 
			LoggerFactory.getLogger(FileTest.class);
	@RequestMapping("file/log")
	public String logwelcome()
	{
		//System.out.println("in annotation controller");
        LOG.error("FOR TEST PERFORMENCE BY FILE");
	    return "welcome";//return welcome.jsp to client
	}
}
