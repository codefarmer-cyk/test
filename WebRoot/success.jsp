<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>登录成功</title>

</head>

<body>
	<%
		request.setCharacterEncoding("utf-8");
		String userid = (String) request.getParameter("userid");
		session.setAttribute("userid", userid);
	%>
	<%=userid%><br>
	<%
		List<String> info = (List<String>) request.getAttribute("info");
		if (info != null) {
			Iterator<String> iter = info.iterator();
			while (iter.hasNext()) {
	%>
	<h1><%=iter.next()%></h1>
	<br>
	<%
		}
		}
	%>
</body>
</html>
