<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录选择</title>
	</head>
	<body>
		请选择您要注册的账户类型：<br/>
		<a href="${pageContext.request.contextPath}/public/oridinaryuserregister.jsp">普通用户注册</a><br/>
		<a href="${pageContext.request.contextPath}/registerUI">房主注册</a>
	</body>
</html>