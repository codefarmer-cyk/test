<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>注册界面</title>
<!--
	<link rel="stylesheet" type="text/css" href="css/regist_style.css">
	-->
<script type="text/javascript" src="js/regist.js"></script>
<%
	request.setCharacterEncoding("utf-8");
%>
</head>

<body>
	<form method="post" action="RegistServlet"
		onsubmit="return checkForm()">
		<input type="text" id="userid" name="userid" placeholder="用户id"
			autofocus required onblur="checkUserid(this.value)"> <span
			id="msg1"></span> <br> <input type="password" id="password"
			name="password" placeholder="密码" required
			onblur="checkPassword(this.value)"> <span id="msg2"></span><br>
		<input type="password" id="reppassword" name="reppassword"
			placeholder="再次输入密码" required
			onblur="checkReppassword(password.value,this.value)"> <span
			id="msg3"></span><br> <input id="submit" type="submit"
			value="提交"> <input id="reset" type="reset" value="重置">
	</form>
</body>
</html>
