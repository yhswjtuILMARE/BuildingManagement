<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录页面</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
		<link rel="icon" href="image/img.ico" type="${pageContext.request.contextPath}/image/x-ico" />
		
	</head>
	<script type="text/javascript">
			function clicks(){
				
				window.location.href="/BuildingManagement/registerUI";
				
			}
		</script>
	<body>
    	<div id="container">
        	<div id="background">
            		<div id="word">房主登录</div><br /><hr />
            	<form action="${pageContext.request.contextPath }/LoginController" method="post">
                    <div id="inputs">
                        <input class="input" type="text" name="username" placeholder="请输入用户名"/><br/>
                        <input class="input" type="password" name="password" placeholder="请输入密码"/>
                    </div>
                    <div id="buttons">
                    	<input class="button" type="submit" value="提交"/>
                        <input class="button" type="button" onclick="clicks()" value="注册"/>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>