<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://localhost:8088" prefix="fn" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>首页</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
		<link rel="icon" href="image/img.ico" type="${pageContext.request.contextPath}/image/x-ico" />
		<script>
		window.setInterval(function ShowTime(){
			var date = new Date();
			var div = document.getElementById("div2");
			div.innerHTML = date.toLocaleDateString() + date.toLocaleTimeString();
			},500);
		function borderShow(button){
			var name = "/BuildingManagement/buyUI?building_id=" + button.value;
			window.open(name);
		}
		function ToTop(){
			scroll(0,0);
		}
		function change(button){
			button.value=button.value==""?"顶部":"";
		}
		</script>
	</head>
	<body onload="ShowTime(document.getElementById('load')">
    	<div style="background-color:#F8F8F6;height:120px;">
            <div style="margin-top:-10px;">
                    <div style="vertical-align:middle;float:left; margin-right:315px;"><img style="margin-top:15px;margin-left:20px;" src="${pageContext.request.contextPath}/image/logo.png"/></div>
                    <div style="position:relative;top:50px;font-size:24px;color:#900;font-weight:900;">师大房产信息</div>
                    <div style="position:relative;top:25px; font-size:15px;float:right; margin-right:80px;font-family:黑体;">
                        <c:if test="${user == null && oridinaryuser == null}">
                        	<a href="${pageContext.request.contextPath}/managementUI">后台</a>&nbsp;|
                        	<a href="${pageContext.request.contextPath}/public/switchregis.jsp">注册</a>&nbsp;|
                        	<a href="${pageContext.request.contextPath}/public/switch.jsp">登录</a>
                        </c:if>
                        <c:if test="${user != null }">
                        	<a href="${pageContext.request.contextPath}/managementUI">后台</a>&nbsp;|
                        	您好,${user.holder_name}
                        </c:if>
                        <c:if test="${oridinaryuser != null }">
                        	<a href="${pageContext.request.contextPath}/RemoveUser">注销</a>&nbsp;|
                        	您好,${oridinaryuser.rentperson_name}
                        </c:if>
                    </div>
                    <div id="div2" style="position:relative;top:50px;font-size:16px;float:right;font-family:黑体; margin-right:-153px;"></div>
            </div>
        </div>
        <div id="top">
        	<input id="topbutton" onmouseover="change(this)" onmouseout="change(this)" type="button" onclick="ToTop()"/>
        </div>
        <div style="position:fixed;bottom:109px;left:0px;"><img src="${pageContext.request.contextPath }/image/left.png"/></div>
    	<div id="containt">
          	<div id="div1" style="float:left;margin-top:55px;margin-left:20px;">
            	<img style="float:left;margin-top:-36px;" src="${pageContext.request.contextPath}/image/button.png">
            	<div style="margin-top:-33px;font-size:18px;float:left;margin-left:20px;color:#333;font-family:黑体;">&nbsp;户型图模式</div>
                <div style="float:right;margin-top:-33px;font-size:14px;font-weight:900;margin-right:50px;">
                	<div style="float:left;">共有</div>
                	<div style="float:left; color:#F00; margin-top:-7px;font-size:24px">${house.totalRecord}</div>
                	<div style="float:left;">套房子</div>
                </div>
            </div>
            <div id="div3">
            	<table class="table" align="center" border="0" cellpadding="0" cellspacing="0">
            		<c:forEach var="building" items="${house.list}">
	                	<tr class="tr">
	                    	<td class="td" width="220"><img class="img" src="${fn:URLUtils(pageContext.request.contextPath,building.building_img) }" width="180" height="130"/></td>
	                        <td class="td" width="400">
	                        	<div class="content">
	                        		<div class="title">${building.building_address}</div><br/>
	                                <div class="second">${building.building_type}&nbsp;${building.building_size}平方米&nbsp;${building.building_max_hold}人租</div><br/>
	                                <div class="third">${building.building_state}</div><br/>
	                                <div class="forth">${building.building_note}</div>
	                            </div>
	                        </td>
	                        <td class="td" width="150">
	                        	<div class="content1">
	                        		<div class="total">${fn:NumUtil((building.building_cash * 3)/10000)}</div>
	                                <div style="float:left;margin-top:18px;color:#F00">万元</div><br/><br/>
	                                <div class="per">${building.building_cash}元/月</div><br/>
	                            </div>
	                        </td>
	                        <input type="hidden" id="${building.building_id}" value="${building.building_id}"/>
	                        <td class="td"><input class="button" type="button" value="我要看房" onclick="borderShow(document.getElementById('${building.building_id}'))"></td>
	                    </tr>
                    </c:forEach>
                </table><br/><br/>
                <div style="font-size:16px;">
                    <%@ include file="/WEB-INF/page.jsp" %>
                </div><br/><br/><br/>
            </div>
        </div>
        <div style="width:100%;height:109px;background-color:#AE1C1C;">
        	<div style="color:#FFF;position:relative;top:20px;margin-left:505px;">陕西师范大学　陕ICP备：05001611　总机：86-29-85308114</div>
            <div style="color:#FFF;position:relative;top:20px;margin-left:505px;"><br/>雁塔校区　地址：西安市雁塔区长安南路199号　邮编：710062</div>
            <div style="color:#FFF;position:relative;top:20px;margin-left:505px;"><br/>长安校区　地址：西安市长安区西长安街620号　邮编：710119</div>
        </div>
    </body>
</html>