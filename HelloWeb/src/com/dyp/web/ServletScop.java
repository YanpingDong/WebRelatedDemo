package com.dyp.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletScop
 */
@WebServlet("/scop")//有了这个注解就不需要在web.xml里配置sevlet和sevlet-mapping
public class ServletScop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
   //only run once 
   public void init() throws ServletException{
	   System.out.println("init servlet");
   }
   
   /**
    * 系统会默认调用带config的init，如果两个init都存在的话
    */
   @Override
   public void init(ServletConfig config) throws ServletException {
	   
	   if(config.getInitParameterNames().hasMoreElements())
	   {
		   System.out.println("init with config"); 
	   }
	   else
	   {
		   System.out.println("config info is null,so transfor to invoke init() method");
		   init();
	   }
   }
   
   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response)
   			throws ServletException, IOException
   {
	   System.out.println("do service");
   }
   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
   			throws ServletException, IOException
   {
	   System.out.println("do get");
   }
   
   @Override
   public void destroy() {
	// TODO Auto-generated method stub
	System.out.println("destory");
}
}
