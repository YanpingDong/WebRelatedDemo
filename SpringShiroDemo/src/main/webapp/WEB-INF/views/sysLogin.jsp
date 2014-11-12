<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
<title> 简单登录页面</title>
</head>

<body>

<form id="loginForm"  class="form login-form" action="login" method="post">
                <legend><span style="color:#08c;">系统登陆</span></legend>
                <div class="body">
					<div class="control-group">
						<div class="controls">
							<input type="text" id="username" name="username" class="required" value="" placeholder="登录名">
						</div>
					</div>
					
					<div class="control-group">
						<div class="controls">
							<input type="password" id="password" name="password" class="required" placeholder="密码"/>
						</div>
					</div>
					<c:if test="${isValidateCodeLogin}"><div class="validateCode">
						<label for="password">密　码：</label>
						<tags:validateCode name="validateCode" inputCssStyle="margin-bottom:0;"/>
					</div></c:if>
                </div>
                <div class="footer">
                    <label class="checkbox inline">
                        <input type="checkbox" id="rememberMe" name="rememberMe"> <span style="color:#08c;">记住我</span>
                    </label>
                    <input class="btn btn-primary" type="submit" value="登 录"/>
                </div>
				
            </form>
</body>

</html>