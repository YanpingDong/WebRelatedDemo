package com.dyp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CharacterEncodingServlet
 */
@WebServlet("/charTest")
public class CharacterEncodingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String testChar = null;
		testChar = request.getParameter("testChar");
		System.out.println("In doGet, testChar is " + testChar );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String testChar = null;
		testChar = request.getParameter("testChar");
		
		//print at console
		System.out.println("In doPost, testChar is " + testChar );
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>" + "testChar is " + testChar + "</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
