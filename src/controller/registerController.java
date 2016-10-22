package controller;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utils.MD5Code;
import Utils.UniqueCode;
import domain.holderBean;
import service.holder2DB_ser;


public class registerController extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String token = request.getParameter("token");
		if(!isToken(token, request)){
			response.getOutputStream().write("请勿重复提交".getBytes());
			return;
		}
		holder2DB_ser ser = new holder2DB_ser();
		String username = request.getParameter("holder_name");
		if(ser.isExisted(username)){
			response.getWriter().write("用户已存在<a href='/BuildingManagement/index.jsp'>返回首页</a>");
			return;
		}
		Enumeration<String> enums = request.getParameterNames();
		holderBean bean = new holderBean();
		
		while(enums.hasMoreElements()){
			String name = enums.nextElement();
			String value = request.getParameter(name);
			if(name.equals("holder_gander") || name.equals("token"))continue;
			if(name.equals("holder_pwd")){
				value = MD5Code.getToken(value);
			}
			try {
				PropertyDescriptor pds = new PropertyDescriptor(name, holderBean.class);
				Method method = pds.getWriteMethod();
				method.invoke(bean, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		bean.setHolder_id(UniqueCode.getUniqueCode());
		request.getSession().setAttribute("user", bean);
		if(ser.insert(bean) == 1){
			response.getWriter().write("注册成功，页面将在三秒后跳转");
			response.setHeader("refresh", "3;/BuildingManagement/index.jsp");
		}else{
			response.getWriter().write("注册失败");
		}
	}
 
	boolean isToken(String token, HttpServletRequest request){
		
		HttpSession session = request.getSession(false);
		if(session == null)return false;
		String value = (String) session.getAttribute("token");
		if(value == null)return false;
		if(!value.equals(token)){
			session.removeAttribute("token");
			return false;
		}else{
			session.removeAttribute("token");
		}
		return true;
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
