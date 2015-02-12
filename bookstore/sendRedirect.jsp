<%@ page contentType="text/html;charset=gb2312"%>

<%
   // 先获取用户输入的用户名和口令，然后判断是否合法
   String username = request.getParameter("username");

   String userpass = request.getParameter("userpass");

   if(userpass != null && username.equals("zhangsan") && userpass.equals("zhangsan"))
   {
       response.sendRedirect("hello.jsp");
   }else{
       response.sendRedirect("index.jsp");
   }
%>