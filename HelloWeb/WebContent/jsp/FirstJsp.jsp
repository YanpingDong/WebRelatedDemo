<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>First JSP</title>
</head>
<body>
<h1>Hello JSP</h1>
<%--JSP有一些重要的内置对象。 out(PrintWriter),request(HttpServletRequest), sesponse(HttpServletResponse)
    session(HttpSession),application(ServletContest)
 --%>
 <%!
 	int globalint = 10;
 %>
<%
	String str = "hello JSP";
    out.println(str + "<br/>");
    //http://localhost/HelloWeb/jsp/FirstJsp.jsp?test=test jsp
    String parameter = request.getParameter("test");
    out.println(parameter + "<br/>");
    System.out.println(application.getRealPath("/"));
%>
<%=parameter %>
</body>
</html>