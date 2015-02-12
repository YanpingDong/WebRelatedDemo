package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;
import java.util.ArrayList;

public class FindAllBooks extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {

        BookBean book = new BookBean();
        ArrayList books = book.findAllBooks();

        request.setAttribute("books",books);

        RequestDispatcher rd = request.getRequestDispatcher("books.jsp"); 
        rd.forward(request,response);
  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     doGet(request,response);
  }

}