<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>后台管理页面</title>
		<link rel="icon" href="image/img.ico" type="${pageContext.request.contextPath}/image/x-ico" />
	</head>
	<frameset rows="14%,*" frameborder="0" framespacing="0" border="2px">
        <frame src="${pageContext.request.contextPath}/public/top.html" name="top" scrolling="no"/>
        <frameset cols="14%,*" frameborder="0" framespacing="0" border="2px">
        	<frame src="${pageContext.request.contextPath}/public/right.jsp" name="left" scrolling="no"/>
			<frame src="${pageContext.request.contextPath}/public/body.jsp" name="right" scrolling="yes"/>
    	</frameset>
    </frameset><noframes></noframes>
	<body>
	
	</body>
</html>