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

import Utils.MD5Code;
import Utils.UniqueCode;
import domain.rentpersonBean;
import service.rentperson2DB_ser;


public class OrdinaryUserRegister extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		rentperson2DB_ser ser = new rentperson2DB_ser();
		String username = request.getParameter("rentperson_name");
		if(ser.isExisted(username)){
			response.getWriter().write("用户已存在<a href='/BuildingManagement/index.jsp'>返回首页</a>");
			return;
		}
		Enumeration<String> enums = request.getParameterNames();
		rentpersonBean bean = new rentpersonBean();
		while(enums.hasMoreElements()){
			
			String name = enums.nextElement();
			String value = request.getParameter(name);
			if(name.equals("rentperson_pwd")){
				value = MD5Code.getToken(value);
			}
			try {
				PropertyDescriptor pd = new PropertyDescriptor(name,rentpersonBean.class);
				Method method = pd.getWriteMethod();
				method.invoke(bean,value);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		bean.setRentperson_id(UniqueCode.getUniqueCode());
		request.getSession().setAttribute("oridinaryuser", bean);
		if(ser.insert(bean) == 1){
			response.getWriter().write("注册成功，将在3秒后跳回首页");
			response.setHeader("refresh", "3;/BuildingManagement/IndexUI?page=1");
		}else{
			response.getWriter().write("注册失败，<a href='/BuildingManagement/IndexUI?page=1'>回首页</a>");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
