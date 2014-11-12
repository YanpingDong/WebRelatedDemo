<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dyp.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--客户端端跳转-->
<%--对于 response.sendRedirect,跳转之前会把本业的代码持行完才跳转,如查想测试，可以打开注释代码--%>
<%
    //User user = null;
	response.sendRedirect("../JavaObjectRefer.jsp");
	//response.sendRedirect("ObjectRefer.jsp?username=aaa");
	//为了避免后面的程序执行，加return
	//user.setUserId("111");
%>

</body>
</html>