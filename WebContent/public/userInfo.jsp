<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>BODY</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/body.css"/>
		<link rel="icon" href="image/img.ico" type="${pageContext.request.contextPath}/image/x-ico" />
	</head>
	<body>
    	<hr/>
    	<form action="${pageContext.request.contextPath}/holderUserInfo" method="post">
        	<table class="table" width="100%" align="center" border="0"  cellspacing="0" cellpadding="0">
            	<tr height="40px" style="font-size:24px; color:#900; font-weight:800;">
                	<td>房主基本信息修改</td>
                </tr>
            </table>
        	<table class="table" width="100%" align="center" border="0"  cellspacing="0" cellpadding="0">
            	<tr class="tr">
                	<td class="td">用户名</td>
                    <td class="td"><input class="text" type="text" name="holder_name" value="${user.holder_name }"/></td>
                </tr>
                <tr class="tr">
                    <td width="200px" class="td">密码</td>
                    <td colspan="3" class="td"><input class="text" type="password" name="holder_pwd"/></td>
                </tr>
                <tr class="tr">
                	<td class="td">所在位置</td>
                    <td class="td"><input class="text" type="text" name="holder_address" value="${user.holder_address}"/></td>
                </tr>
                <tr class="tr">
                	<td class="td">联系电话</td>
                    <td colspan="3" class="td"><input class="text" type="text" name="holder_phone" value="${user.holder_phone }"/></td>
                </tr>
                <input type="hidden" name="holder_id" value="${user.holder_id}"/>
                <tr class="tr" >
                	<td class="td" style="text-align:right;" colspan="4">
                    	<input id="submit" type="submit" value="提交"/>
                    </td>
                </tr>
            </table>
            
        </form>
    </body>
</html>