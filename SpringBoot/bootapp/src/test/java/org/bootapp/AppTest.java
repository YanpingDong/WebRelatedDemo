package org.bootapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebIntegrationTest("server.port:0")
@ActiveProfiles("prd")  
public class AppTest 
{
//	@Value("${for.test.value}")
//    private String forTestValue;
	
	@Value("${spring.application.name}")
	private String appName;
	@Value("${spring.profiles.active}")
	private String springActive;
	
	@Value("${logging.config}")
	private String loggingConfig;
	
	@Test
	public void testSpringBootProfile()
	{
		//System.out.println(forTestValue);
		System.out.println(springActive);
		System.out.println(loggingConfig);
		System.out.println(appName);
	}
  
}
