<%@ page contentType="text/html;charset=gb2312"%>

<%
   // �Ȼ�ȡ�û�������û����Ϳ��Ȼ���ж��Ƿ�Ϸ�
   String username = request.getParameter("username");

   String userpass = request.getParameter("userpass");

   if(userpass != null && username.equals("zhangsan") && userpass.equals("zhangsan"))
   {
       response.sendRedirect("hello.jsp");
   }else{
       response.sendRedirect("index.jsp");
   }
%>