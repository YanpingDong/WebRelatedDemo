package com.dyp.test.jms.activemq;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dyp.test.jms.spring.activemq.ProducerServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/SpringContext.xml")
public class TestVariableArgumentsTest {
	@Autowired
	private TestVariableArguments testVariableArguments;
	@Test
	public void test() {
		testVariableArguments.myPrint();
	}

}
