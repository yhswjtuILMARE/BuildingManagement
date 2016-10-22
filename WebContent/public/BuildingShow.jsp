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
                	<td>${user.holder_name}的房子</td>
                </tr>
            </table>
        	<table class="table" width="100%" align="center" border="0"  cellspacing="0" cellpadding="0">
            	<tr class="tr">
                	<td class="td" style="text-align:center;">房屋地址</td>
                    <td class="td" style="text-align:center;">房屋大小</td>
                    <td class="td" style="text-align:center;">合租人数</td>
                    <td class="td" style="text-align:center;">租金</td>
                    <td class="td" style="text-align:center;">房屋类型</td>
                    <td class="td" style="text-align:center;">操作</td>
                </tr>
                <c:forEach var="building" items="${buildingInfo}">
                	<tr class="tr">
	                	<td class="td" style="text-align:center;">${building.building_address}</td>
	                    <td class="td" style="text-align:center;">${building.building_size }</td>
	                    <td class="td" style="text-align:center;">${building.building_max_hold }</td>
	                    <td class="td" style="text-align:center;">${building.building_cash }</td>
	                    <td class="td" style="text-align:center;">${building.building_type }</td>
	                    <td class="td" style="text-align:center;">
	                    	<a href="/BuildingManagement/removeBuildingUI?building_id=${building.building_id}">修改信息</a>
	                    </td>
                	</tr>
                </c:forEach>
            </table>
    </body>
</html>