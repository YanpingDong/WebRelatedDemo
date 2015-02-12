package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;
import java.util.ArrayList;

public class FindBookByID extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
        String bookid = request.getParameter("bookid");
        BookBean book = new BookBean();
        book = book.findBookByID(bookid);

        request.setAttribute("book",book);

        RequestDispatcher rd = request.getRequestDispatcher("updateBook.jsp"); 
        rd.forward(request,response); 

  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     doGet(request,response);
  }

}