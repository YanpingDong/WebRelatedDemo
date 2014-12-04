package com.dyp.springmvc.annotation.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/spring/applicationContext.xml",
		"file:D:\\DevelopmentEnv\\keplerWorkspace\\SpringWebRelateDemo\\SpringMVCHello\\src\\main\\webapp\\WEB-INF\\spring\\webmvc-config.xml"})
public class WelcomeTest {

	@Autowired
	private AnnotationMethodHandlerAdapter handlerAdapter;
	
	@Autowired
	private Welcome welcomeCtr;
	
	private MockHttpServletRequest mockRequest;
	private MockHttpServletResponse mockResponse;
	
	@Before
	public void setUp() throws Exception {
		mockRequest = new MockHttpServletRequest();
		mockRequest.setCharacterEncoding("UTF-8");
		mockResponse = new MockHttpServletResponse();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWelcome() throws Exception {
		mockRequest.setRequestURI("/welcome");
		ModelAndView returnValue = handlerAdapter.handle(mockRequest, mockResponse, welcomeCtr);
		System.out.println(returnValue.getViewName());
		System.out.println(returnValue.getModel());
	}

}
