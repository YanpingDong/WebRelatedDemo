package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;
import java.util.ArrayList;

public class DeleteBook extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     
        String bookid = request.getParameter("bookid");

        BookBean book = new BookBean();
        boolean success = book.deleteBook(bookid);

        String info;
        if(success)
           info=bookid + " delete success";
        else
           info=bookid + " delete fail";
        request.setAttribute("info",info);

        RequestDispatcher rd = request.getRequestDispatcher("success.jsp"); 
        rd.forward(request,response); 
  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     doGet(request,response);
  }

}