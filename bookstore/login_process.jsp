<%@ page contentType="text/html;charset=gb2312"%>

<%
   ///bookstore/forward.jsp?username=zhangsan&userpass=zhangsan
   // �Ȼ�ȡ�û�������û����Ϳ��Ȼ���ж��Ƿ�Ϸ�
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