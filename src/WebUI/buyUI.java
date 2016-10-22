package WebUI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Utils.UniqueCode;
import domain.BuildingBean;
import domain.holderBean;
import domain.rentpersonBean;
import domain.seebuilding;
import service.Building2DB_ser;
import service.holder2DB_ser;
import service.seebuilding_ser;


public class buyUI extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session == null){
			response.getWriter().write("¼ì²âµ½ÄúÎ´µÇÂ½£¬ÇëÏÈµÇÂ¼<a href='/BuildingManagement/index.jsp'>·µ»ØÊ×Ò³</a>");
			return;
		}
		rentpersonBean bean = (rentpersonBean) session.getAttribute("oridinaryuser");
		if(bean == null){
			response.getWriter().write("¼ì²âµ½ÄúÎ´µÇÂ½£¬ÇëÏÈµÇÂ¼<a href='/BuildingManagement/index.jsp'>·µ»ØÊ×Ò³</a>");
			return;
		}
		String building_id = request.getParameter("building_id");
		Building2DB_ser ser = new Building2DB_ser("dao.Building2DB");
		holder2DB_ser ser1 = new holder2DB_ser();
		seebuilding_ser ser2 = new seebuilding_ser();
		seebuilding seeb = new seebuilding();
		
		BuildingBean build = (BuildingBean) ser.select(building_id);
		holderBean holder= (holderBean) ser1.select(build.getHolder_id());
		
		seeb.setSeebuilding_id(UniqueCode.getUniqueCode());
		seeb.setBuilding_id(building_id);
		seeb.setRentperson_id(bean.getRentperson_id());
		seeb.setSeebuilding_address(holder.getHolder_address());
		
		if(ser2.insert(seeb) != 1){
			response.getWriter().write("³öÏÖ´íÎó£¬<a href='/BuildingManagement/index.jsp'>·µ»ØÊ×Ò³</a>");
			return;
		}
		
		request.setAttribute("buildingbean", build);
		request.setAttribute("holder", holder);
		request.setAttribute("totalsee", ser2.getTotalRecord(building_id));
		request.getRequestDispatcher("/WEB-INF/management/buy.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
