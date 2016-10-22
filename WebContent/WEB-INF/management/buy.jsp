<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://localhost:8088" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>购买页面</title>
        <link rel="icon" href="image/img.ico" type="image/x-ico" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/buy.css"/>
        <script>
			window.setInterval(function ShowTime(){
				var date = new Date();
				var div = document.getElementById("div2");
				div.innerHTML = date.toLocaleDateString() + date.toLocaleTimeString();
				},500);
			function ToTop(){
				scroll(0,0);
			}
			function change(button){
				button.value=button.value==""?"顶部":"";
			}
			function backtoindex(){
				
				window.location.href="/BuildingManagement/index.jsp";
			}
			function submitform(building_id,rentperson_id,holder_id,feelist_cash){
				
				window.location.href = "/BuildingManagement/rentUI?building_id=" + building_id.value + "&rentperson_id=" + rentperson_id.value + "&holder_id=" + holder_id.value + "&feelist_cash=" + feelist_cash.value;
				
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
                        <c:if test="${oridinaryuser != null}">
                        	<a href="${pageContext.request.contextPath}/RemoveUser">注销</a>&nbsp;|
                        	您好,${oridinaryuser.rentperson_name}
                        </c:if>
                    </div>
                    <div id="div2" style="position:relative;top:50px;font-size:16px;float:right;font-family:黑体; margin-right:-145px;"></div>
            </div>
        </div>
        <div id="top">
        	<input id="topbutton" onmouseover="change(this)" onmouseout="change(this)" type="button" onclick="ToTop()"/>
        </div>
    	<div id="containt" style="height:445px;">
        	<div id="topword" style="margin-left:16px;width:900px;text-align:left;">${buildingbean.building_address}&nbsp;交通便利</div>
          	<div id="deteilimage">
            	<img style="float:left;" src="${fn:URLUtils(pageContext.request.contextPath,buildingbean.building_img) }" width="335" height="253"/>
            	<table class="table">
                	<tr class="tr">
                    	<td>租金：</td>
                        <td class="td"><div style="float:left; color:#F00;">${fn:NumUtil((buildingbean.building_cash * 3)/10000)}</div><div>万元</div></td>
                    </tr>
                    <tr class="tr">
                    	<td>月租：</td>
                        <td class="td">${buildingbean.building_cash}元/月</td>
                    </tr>
                    <tr class="tr">
                    	<td>面积</td>
                        <td class="td">${buildingbean.building_size}平米</td>
                    </tr>
                    <tr class="tr">
                    	<td>合租：</td>
                        <td class="td">${buildingbean.building_max_hold}人</td>
                    </tr>
                    <tr class="tr">
                    	<td>地址：</td>
                        <td class="td">${buildingbean.building_address }</td>
                    </tr>
                    <tr class="tr">
                    	<td>备注：</td>
                        <td class="td">${buildingbean.building_note }</td>
                    </tr>
                    <tr class="tr">
                    	<td>房屋状态：</td>
                        <td class="td">${buildingbean.building_state}</td>
                    </tr>
                    <tr class="tr">
                    	<td>房主电话</td>
                        <td class="td">${holder.holder_phone }</td>
                    </tr>
                </table>
                <table id="table">
                	<tr class="tr">
                    	<td colspan="2" style="font-size:24px;">房主信息</td>
                    </tr>
                    <tr class="tr">
                    	<td class="td">房主姓名：</td>
                        <td class="td">${holder.holder_name}</td>
                    </tr>
                    <tr class="tr">
                    	<td class="td">地址信息：</td>
                        <td class="td">${holder.holder_address}</td>
                    </tr>
                    <tr class="tr">
                    	<td class="td">看房人数：</td>
                        <td class="td">${totalsee}人</td>
                    </tr>
                </table>
            </div>
            <input type="hidden" id="building_id" value="${buildingbean.building_id}" />
            <input type="hidden" id="rentperson_id" value="${oridinaryuser.rentperson_id}" />
            <input type="hidden" id="holder_id" value="${holder.holder_id}" />
            <input type="hidden" id="feelist_cash" value="${buildingbean.building_cash * 3}" />
            <input class="button" style="margin-left:100px;" onclick="submitform(document.getElementById('building_id'),document.getElementById('rentperson_id'),document.getElementById('holder_id'),document.getElementById('feelist_cash'))" type="button" value="立即租房"/>
            <input class="button" onclick="backtoindex()" type="button" value="返回主页"/>
            
        </div>
        <div style="width:100%;height:109px;background-color:#AE1C1C;">
        	<div style="color:#FFF;position:relative;top:20px;margin-left:505px;">陕西师范大学　陕ICP备：05001611　总机：86-29-85308114</div>
            <div style="color:#FFF;position:relative;top:20px;margin-left:505px;"><br/>雁塔校区　地址：西安市雁塔区长安南路199号　邮编：710062</div>
            <div style="color:#FFF;position:relative;top:20px;margin-left:505px;"><br/>长安校区　地址：西安市长安区西长安街620号　邮编：710119</div>
        </div>
    </body>
</html>