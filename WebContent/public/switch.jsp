<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录选择</title>
	</head>
	<body>
		请选择您要登录的账户：<br/>
		<a href="${pageContext.request.contextPath}/public/oridinaryuserlogin.jsp">普通用户登录</a><br/>
		<a href="${pageContext.request.contextPath}/public/login.jsp">房主登录</a>
	</body>
</html>