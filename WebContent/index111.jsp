<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登陆人数</title>
	</head>
	<body>
		<c:forEach var="item" items="${map}">
			${item.key}<a href="${pageContext.request.contextPath}/removeUser?username=${item.key}" >踢出系统</a><br/>
		</c:forEach>
	</body>
</html>