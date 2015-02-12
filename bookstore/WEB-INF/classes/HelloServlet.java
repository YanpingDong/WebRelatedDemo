package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
	    response.setContentType("text/html;charset=utf8");
	    PrintWriter out = response.getWriter();
	    out.println("Welcom to learn JSP");
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
	   doGet(request,response);
	}
}
