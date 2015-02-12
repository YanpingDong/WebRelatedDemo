<%@ page contentType="text/html;charset=gb2312"%>
处理文件的前半部分<br>
<%
   // 先获取用户输入的用户名和口令，然后判断是否合法
   String username = request.getParameter("username");

   String userpass = request.getParameter("userpass");

   if(username != null && username.equals("zhangsan") && userpass.equals("zhangsan"))
   {
%>

       <jsp:include page="hello.jsp"/>
<%
   }else{
%>
       <jsp:include page="index.jsp"/>
<%
   }
%>
<br>处理文件的后半部分