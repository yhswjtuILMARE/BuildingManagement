package WebUI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.UniqueCode;
import domain.feelistBean;
import domain.rentBean;
import service.feelist2DB_ser;
import service.rent2DB_ser;


public class rentUI extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		feelist2DB_ser ser1 = new feelist2DB_ser();
		feelistBean feelist = new feelistBean();
		String holder_id = request.getParameter("holder_id");
		String rentperson_id = request.getParameter("rentperson_id");
		String feelist_cash = request.getParameter("feelist_cash");
		String building_id = request.getParameter("building_id");
		feelist.setBuilding_id(building_id);
		feelist.setFeelist_cash(feelist_cash);
		feelist.setFeelist_id(UniqueCode.getUniqueCode());
		feelist.setHolder_id(holder_id);
		feelist.setRentperson_id(rentperson_id);
		if(ser1.insert(feelist) != 1){
			response.getWriter().write("�����ύʧ��<a href='/BuildingManagement/index.jsp'>������ҳ</a>");
			return;
		}
		response.getWriter().write("��ϲ�������������ɹ�������������ϵ������������Ȩɾ������<a href='/BuildingManagement/index.jsp'>������ҳ</a>");
		return;
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
