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

import domain.BuildingBean;
import service.Building2DB_ser;


public class modifyBuilding extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Enumeration<String> enums = request.getParameterNames();
		Building2DB_ser ser = new Building2DB_ser("dao.Building2DB");
		BuildingBean bean = new BuildingBean();
		while(enums.hasMoreElements()){
			String name = enums.nextElement();
			String value = request.getParameter(name);
			try {
				if(name.equals("building_size") || name.equals("building_max_hold") || name.equals("building_cash")){
					if(name.equals("building_max_hold")){
						int values = Integer.parseInt(value);
						PropertyDescriptor pd = new PropertyDescriptor(name,BuildingBean.class);
						Method method = pd.getWriteMethod();
						pd.getWriteMethod().invoke(bean, values);
					}else{
						double values = Double.parseDouble(value);
						PropertyDescriptor pd = new PropertyDescriptor(name,BuildingBean.class);
						pd.getWriteMethod().invoke(bean, values);
					}
					continue;
				}
				PropertyDescriptor pd = new PropertyDescriptor(name,BuildingBean.class);
				Method method = pd.getWriteMethod();
				method.invoke(bean, value);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ser.update(bean) == 1){
			request.setAttribute("message", "修改成功");
		}else{
			request.setAttribute("message", "修改失败");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
