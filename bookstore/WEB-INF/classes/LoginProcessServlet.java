package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;

public class LoginProcessServlet extends HttpServlet {
	  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	  {
	        String username = request.getParameter("username");
	        String userpass = request.getParameter("userpass");

	        UserBean user = new UserBean();
	        user.setUsername(username);
	        user.setUserpass(userpass);
	        
	        boolean b = false;
	        b = user.login();
	        if( b )
	        {
	           RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
	           rd.forward(request,response);
	        }else
	        {
	           RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	           rd.forward(request,response); 
	        }
	       /* if( username != null && username.equals("zhangsan") && userpass.equals("zhangsan") )
	        {
	           RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
	           rd.forward(request,response);
	        }else
	        {
	           RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	           rd.forward(request,response); 
	        }*/
	  }

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
	   doGet(request,response);
	}
}
