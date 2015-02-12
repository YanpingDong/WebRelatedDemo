package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.*;
import java.util.ArrayList;

public class UpdateBook extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
        request.setCharacterEncoding("gb2312");
        String bookid = request.getParameter("bookid");
        String bookname = request.getParameter("bookname");
        String price = request.getParameter("price");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
   
        float fPrice = 0f;
        try{
           fPrice = Float.parseFloat(price); 
        }catch(Exception e){
        }

        
        BookBean book = new BookBean();
        book.setBookid(bookid);
        book.setBookname(bookname);
        book.setPrice(fPrice); 
        book.setAuthor(author);
        book.setPublisher(publisher);

        boolean success = book.update();

        String info ;
        if(success)
           info = "update success";
        else
           info = "update fail";

        request.setAttribute("info",info);

        RequestDispatcher rd = request.getRequestDispatcher("success.jsp"); 
        rd.forward(request,response); 

  }

  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
     doGet(request,response);
  }
}