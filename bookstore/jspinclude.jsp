<%@ page contentType="text/html;charset=gb2312"%>
�����ļ���ǰ�벿��<br>
<%
   // �Ȼ�ȡ�û�������û����Ϳ��Ȼ���ж��Ƿ�Ϸ�
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
<br>�����ļ��ĺ�벿��