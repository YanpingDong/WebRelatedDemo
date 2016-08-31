package org.bootapp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.bootapp.exception.handle.MyException;
import org.bootapp.service.ForTestService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class UserInfoControllerByMockitTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;

	@Mock
	private ForTestService fortestService;
	
	@InjectMocks
	private UserInfoController userInfoController;
	
	//miss user gender
	private String missParamReqGender = "/user/123";
	private String nonexistentUserReq = "/user/0?gender=female";
	
	@Before
	public void setupMockMvc() {
		MockitoAnnotations.initMocks(this);
		//Mockito.reset(forTestService);
		/*
         * 如果要使用完全默认Spring Web Context, 例如不需要对Controller注入,
         * 则使用 WebApplicationContext mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
         */
		
		//======================================parting line==============================================
		
		/*
		 * Build a MockMvc instance by registering one or more @Controller instances and configuring Spring MVC infrastructure programmatically. 
		 * This allows full control over the instantiation and initialization of controllers and their dependencies, 
		 * similar to plain unit tests while also making it possible to test one controller at a time. 
		 * When this builder is used, the minimum infrastructure required by the DispatcherServlet to serve requests with annotated controllers 
		 * is created automatically and can be customized, 
		 * resulting in configuration that is equivalent to what MVC Java configuration provides except using builder-style methods.  
		 */
		 mockMvc = MockMvcBuilders.standaloneSetup(userInfoController).build();
	}
	
	@After
	public void releaseMockMvc(){
		mockMvc = null;
	}
	
	public void missParametersQuestTest(MockMvc mockMvc, RequestBuilder requestBuilder) throws Exception {
		mockMvc.perform(requestBuilder)
				.andExpect(status().is4xxClientError())
				.andDo(MockMvcResultHandlers.print())
				.andReturn(); 
	}
	
	
	@Test
	public void getMissedParameterUserInfoTest() {
		try {
			missParametersQuestTest(mockMvc, get(missParamReqGender));
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void getUsrerInfoTest(){
		
		try {
			
			org.mockito.Mockito.when(fortestService.getInfo(0)).thenReturn("get Info from mock");
		} catch (MyException e1) {
			System.out.println("===============");
			e1.printStackTrace();
		}
		try {
			MvcResult mvcResult = mockMvc.perform( get(nonexistentUserReq) )
					.andExpect(status().is2xxSuccessful())
					.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
					.andDo(MockMvcResultHandlers.print())
					.andReturn();
			
			System.out.println(mvcResult.getResponse().getContentAsString() + " you can do more test!");
		} catch (Exception e) {
			//Assert.fail();
			e.printStackTrace();
		}
	}
	
}
