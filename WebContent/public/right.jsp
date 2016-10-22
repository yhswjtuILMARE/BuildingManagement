<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://localhost:8088" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
		<title>right</title>
	</head>
	<style>
		body{
			background-color:#F8F8F5;
			}
		.table{
			border:solid #900 2px;
			border-width:18px 2px 0px 2px;
			border-radius:8px;
			text-align:center;
			margin-top:15px;
			}
		.tr{
			height:30px;
			}
		a{
			text-decoration:blink;
			font-size:15px;
			color:#900;
		}
		a:hover{
			text-decoration:underline;
			}
	</style>
    
    <body>
    	<table class="table" width="100%" align="center" border="0"  cellspacing="0" cellpadding="0">
    		
        	<tr class="tr">
            	<td class="td"><a href="/BuildingManagement/public/body.jsp" target="right">录入房屋信息</a></td>
            </tr>
            <tr class="tr">
            	<td class="td"><a href="/BuildingManagement/public/ShowUserInfo.jsp" target="right">查看用户信息</a></td>
            </tr>
            <tr class="tr">
            	<td class="td"><a href="/BuildingManagement/public/userInfo.jsp" target="right">修改房主信息</a></td>
            </tr>
            <tr class="tr">
            	<td class="td"><a href="${pageContext.request.contextPath }/feelistShowUI" target="right">管理所有订单</a></td>
            </tr>
            <tr class="tr">
            	<td class="td"><a href="${pageContext.request.contextPath }/rengInfoShow" target="right">查看所的租住信息</a></td>
            </tr>
            <tr class="tr">
            	<td class="td"><a href="${pageContext.request.contextPath}/BuildingShow" target="right">管理名下所有房屋</a></td>
            </tr>
        </table><br/>
        <table class="table" width="100%" align="center" border="0"  cellspacing="0" cellpadding="0">
        	
            <tr class="tr">
            	<td class="td"><a href="/BuildingManagement/index.jsp" target="_blank">回到主页</a></td>
            </tr>
            <tr class="tr">
            	<td class="td"><a href="/BuildingManagement/RemoveUser" target="_blank">退出登录</a></td>
            </tr>
        </table>
    </body>
</html>