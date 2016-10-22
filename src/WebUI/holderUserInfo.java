package WebUI;

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
import domain.holderBean;
import service.holder2DB_ser;


public class holderUserInfo extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Enumeration<String> enums = request.getParameterNames();
		holderBean bean = new holderBean();
		while(enums.hasMoreElements()){
			String name = enums.nextElement();
			String value = request.getParameter(name);
			if(name.equals("holder_pwd")){
				value = MD5Code.getToken(value);
			}
			try {
				PropertyDescriptor pd = new PropertyDescriptor(name,holderBean.class);
				Method method = pd.getWriteMethod();
				method.invoke(bean, value);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		holder2DB_ser ser = new holder2DB_ser();
		if(ser.update(bean) != 1){
			request.setAttribute("message", "更新失败");
		}else{
			request.setAttribute("message", "更新成功");
		}
		request.getSession(false).setAttribute("user", bean);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
