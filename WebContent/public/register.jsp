<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>注册页面</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css"/>
	</head>
	<body>
    	<div id="container">
        	<div id = "image">
            	<div id="context">房主注册</div><br/><br/>
                <hr/>
        	<form action="${pageContext.request.contextPath}/registerController" method="post">
            	<div id="table">
                	<table border="0" style="border-spacing:10px;">
                    	<tr>
                        	<td width="100px">用户名</td>
                            <td><input id="text1" type="text" placeholder="请输入3-8位英文" name="holder_name"/></td>
                            <td></td>
                        </tr>
                        <tr>
                        	<td>密码</td>
                            <td><input name="holder_pwd" type="password" placeholder="请输入3-8位英文或数字" /></td>
                            <td></td>
                        </tr>
                        <tr>
                        	<td >性别</td>
                            <td>
                            	<input checked style="margin-left:-15px;vertical-align:text-bottom;width:50px;height:15px;" name="holder_gander" type="radio" value="male"/>男
                            	<input style="vertical-align:text-bottom;width:50px;height:15px;" name="holder_gander" type="radio" value="female"/>女
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                        	<td>您的电话</td>
                            <td><input type="text" name="holder_phone"/></td>
                            <td></td>
                        </tr>
                        <tr>
                        	<td>您的地址</td>
                            <td><input type="text" name="holder_address"/></td>
                            <td><input type="hidden" name="token" value="${token}"/></td>
                        </tr>
                        <tr>
                            <td colspan="2" align = "center" style="height:40px;"><br/><br/>
                            	<input style="height:33px;width:110px;" id="button" type="submit" value="提交"/>
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
            </div>
        </div>
	</body>
</html>