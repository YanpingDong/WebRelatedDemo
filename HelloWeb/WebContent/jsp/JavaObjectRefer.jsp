<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dyp.model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	List<User> users = UserInit.initUser();
%>

<table width="700" align="center" border="1">
<tr>
	<td>用户名</td><td>用户ID</td>
</tr>
<%
    for(User u:users)
    {
%>
		<tr>
    	<td><%=u.getUserName() %></td><td><%=u.getUserId() %></td>
    	</tr>
<% 
    }
%>
</table>
</body>
</html>