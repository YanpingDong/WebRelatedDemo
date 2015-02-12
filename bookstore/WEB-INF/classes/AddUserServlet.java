package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;

public class AddUserServlet extends HttpServlet {
	  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	        String username = request.getParameter("username");
	        String userpass = request.getParameter("userpass");

	        UserBean user = new UserBean();
	        user.setUsername(username);
	        user.setUserpass(userpass);
	       
	        boolean b = user.add();

	        if(b)
	            request.setAttribute("info","add action success");
	        else
	            request.setAttribute("info","add action fail");
	        RequestDispatcher rd = request.getRequestDispatcher("success.jsp"); 
	        rd.forward(request,response); 
	  }

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
	   doGet(request,response);
	}
}
