<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                	<td>${user.holder_name}的租户</td>
                </tr>
            </table>
        	<table class="table" width="100%" align="center" border="0"  cellspacing="0" cellpadding="0">
            	<tr class="tr">
                	<td class="td" style="text-align:center;">租户姓名</td>
                    <td class="td" style="text-align:center;">租户电话</td>
                    <td class="td" style="text-align:center;">房屋地址</td>
                    <td class="td" style="text-align:center;">订单金额</td>
                    <td class="td" style="text-align:center;">操作</td>
                </tr>
                <c:forEach var="building" items="${rent}">
                	<tr class="tr">
	                	<td class="td" style="text-align:center;">${building.rentperson_name}</td>
	                    <td class="td" style="text-align:center;">${building.rentperson_phone }</td>
	                    <td class="td" style="text-align:center;">${building.building_address }</td>
	                    <td class="td" style="text-align:center;">${building.building_cash }</td>
	                    <td class="td" style="text-align:center;">
	                    	<a href="${pageContext.request.contextPath}/Deleterent?rent_id=${building.rent_id}">删除</a>
	                    </td>
                	</tr>
                </c:forEach>
            </table>
    </body>
</html>