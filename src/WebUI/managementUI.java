package WebUI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.holderBean;


public class managementUI extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		holderBean bean = (holderBean) session.getAttribute("user");
		if(bean == null){
			response.getWriter().write("¼ì²âµ½ÄúÎ´µÇÂ½£¬ÇëÏÈµÇÂ¼<a href='/BuildingManagement/index.jsp'>·µ»ØÊ×Ò³</a>");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/management/mangage.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
