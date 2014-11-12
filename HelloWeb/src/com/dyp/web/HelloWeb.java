package com.dyp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWeb
 */
@WebServlet("/HelloWeb")//有了这个注解就不需要在web.xml里配置sevlet和sevlet-mapping
public class HelloWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWeb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>" + request.getContextPath() + "</h1>");
		out.println("<h1>" + request.getSession().getServletContext().getRealPath("/") + "</h1>");
		out.println("<h1>" + request.getParameter("user") + "</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
