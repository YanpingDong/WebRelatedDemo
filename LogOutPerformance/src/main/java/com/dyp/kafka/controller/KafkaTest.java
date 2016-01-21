package com.dyp.kafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KafkaTest {
	private static Logger LOG = 
			LoggerFactory.getLogger(KafkaTest.class);
	@RequestMapping("kafka/log")
	public String kafkawelcome()
	{
        LOG.error("TEST PERFORMENCE, TO KAFKA");
	    return "welcome";//return welcome.jsp to client
	}
}
