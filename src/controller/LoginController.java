package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utils.MD5Code;
import domain.holderBean;
import service.holder2DB_ser;


public class LoginController extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		holder2DB_ser ser = new holder2DB_ser();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		holderBean bean = ser.login(username);
		if(bean == null){
			response.getWriter().write("用户不存在<a href='/BuildingManagement/index.jsp'>返回首页</a>");
			return;
		}
		String pwd = bean.getHolder_pwd();
		String formpwd = MD5Code.getToken(password);
		if(!formpwd.equals(pwd)){
			response.getWriter().write("用户存在但密码错误<a href='/BuildingManagement/index.jsp'>返回首页</a>");
			return;
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", bean);
		response.getWriter().write("登陆成功，将在三秒后跳转");
		response.setHeader("refresh", "3;/BuildingManagement/index.jsp");
		return;
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
