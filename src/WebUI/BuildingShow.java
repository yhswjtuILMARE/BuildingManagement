package WebUI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.holderBean;
import service.Building2DB_ser;


public class BuildingShow extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Building2DB_ser ser = new Building2DB_ser("dao.Building2DB");
		holderBean bean = (holderBean) request.getSession(false).getAttribute("user");
		List list = ser.selectlist(bean.getHolder_id());
		request.setAttribute("buildingInfo", list);
		request.getRequestDispatcher("/public/BuildingShow.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
