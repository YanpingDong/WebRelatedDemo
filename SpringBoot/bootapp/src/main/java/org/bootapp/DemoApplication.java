package org.bootapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.utilities.config.EnableApiDoc;

@SpringBootApplication
@EnableApiDoc  //self created annotation for start swagger
public class DemoApplication {
	private static Logger LOG = 
			LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args)  {
		LOG.debug("=============for logback configuration test============");
		SpringApplication.run(DemoApplication.class, args);

		/*EventListenerMethodProcessor emp;
		emp = new EventListenerMethodProcessor();
		emp.afterSingletonsInstantiated();*/
	}
}
