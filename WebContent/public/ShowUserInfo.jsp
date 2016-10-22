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
        	<table class="table" width="100%" align="center" border="0"  cellspacing="0" cellpadding="0">
            	<tr height="40px" style="font-size:24px; color:#900; font-weight:800;">
                	<td>房主基本信息</td>
                </tr>
            </table>
        	<table class="table" width="100%" align="center" border="0"  cellspacing="0" cellpadding="0">
            	<tr class="tr">
                	<td class="td">用户名</td>
                    <td class="td">${user.holder_name }</td>
                </tr>
                <tr class="tr">
                	<td class="td">所在位置</td>
                    <td class="td">${user.holder_address}</td>
                </tr>
                <tr class="tr">
                	<td class="td">联系电话</td>
                    <td class="td">${user.holder_phone }</td>
                </tr>
            </table>
    </body>
</html>