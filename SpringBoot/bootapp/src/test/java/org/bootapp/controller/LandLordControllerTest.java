package org.bootapp.controller;

import static org.junit.Assert.fail;

import org.bootapp.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebIntegrationTest("server.port:0")
public class LandLordControllerTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
