<%@ page contentType="text/html;charset=gb2312"%>

<%
   ///bookstore/forward.jsp?username=zhangsan&userpass=zhangsan
   // 先获取用户输入的用户名和口令，然后判断是否合法
   String username = request.getParameter("username");

   String userpass = request.getParameter("userpass");
   
   if(username!=null && username.equals("zhangsan") && userpass.equals("zhangsan"))
   {
%>

       <jsp:forward page="success.jsp"/>
<%
   }else{
%>
       <jsp:forward page="index.jsp"/>
<%
   }
%>