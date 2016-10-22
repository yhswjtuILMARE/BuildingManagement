package WebUI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BuildingBean;
import service.Building2DB_ser;


public class removeBuildingUI extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String building_id = request.getParameter("building_id");
		Building2DB_ser ser = new Building2DB_ser("dao.Building2DB");
		BuildingBean bean = (BuildingBean) ser.select(building_id);
		request.setAttribute("building", bean);
		request.getRequestDispatcher("/public/BuildingModify.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
