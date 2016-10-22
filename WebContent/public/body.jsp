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
    	<form action="/BuildingManagement/UploadController" method="post" enctype="multipart/form-data">
        	<table class="table" width="100%" align="center" border="0"  cellspacing="0" cellpadding="0">
            	<tr height="40px" style="font-size:24px; color:#900; font-weight:800;">
                	<td>房屋基本信息</td>
                </tr>
            </table>
        	<table class="table" width="100%" align="center" border="0"  cellspacing="0" cellpadding="0">
            	<tr class="tr">
                	<td class="td">面积</td>
                    <td class="td"><input class="text" type="text" name="building_size"/>平方米</td>
                    <td class="td">月租</td>
                    <td class="td"><input class="text" type="text" name="building_cash"/>元/月</td>
                </tr>
                <tr class="tr">
                    <td width="200px" class="td">房屋状态</td>
                    <td colspan="3" class="td"><input class="text" type="text" name="building_state"/></td>
                </tr>
                <tr class="tr">
                	<td class="td">所在位置</td>
                    <td class="td"><input class="text" type="text" name="building_address"/></td>
                    <td class="td">最大容纳人数</td>
                    <td class="td"><input class="text" type="text" name="building_max_hold"/></td>
                </tr>
                <tr class="tr">
                	<td class="td">房屋备注</td>
                    <td colspan="3" class="td"><input class="text" type="text" name="building_note"/></td>
                </tr>
                <tr class="tr">
                    <td class="td">户型</td>
                    <td class="td"><input class="text" type="text" name="building_type"/></td>
                    <td class="td">添加照片</td>
                    <td id="td1" class="td"><input class="text" type="file" name="building_img"/></td>
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