<%@ page language="java" pageEncoding="UTF-8"%>

<html>
<body>

<form action="<%=request.getContextPath()%>/mydemo/login" method="POST">
	姓名：<input type="text" name="username"/><br/>
	密码：<input type="text" name="password"/><br/>
	验证：<input type="text" name="verifyCode"/>
		 		 
	<input type="submit" value="确认"/>
</form>

</body>
</html>