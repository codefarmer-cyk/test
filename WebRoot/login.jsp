<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/login_style.css" />
<script type="text/javascript" src="js/login.js"></script>
<title>登录界面</title>
</head>

<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<form id="login" method="post" action="LoginServlet"
		onsubmit="return checkForm()">
		<h1>登录</h1>
		<fieldset id="inputs">
			<input id="username" type="text" name="userid" placeholder="姓名"
				onblur="checkUserid(this.value)"autofocusrequired  "> <br>
			<span id="msg1"></span> <input id="password" type="password"
				name="password" placeholder="密码"
				required" onblur="checkPassword(this.value)"><br> <span
				id="msg2"></span>
		</fieldset>
		<fieldset id="actions">
			<input id="submit" type="submit" value="提交" /> <input id="reset"
				type="reset" value="重置" style="margin-left:50px" /> <a href="#">忘记密码？</a>
			<a href="regist.jsp">注册</a>
		</fieldset>
	</form>
</body>
</html>
