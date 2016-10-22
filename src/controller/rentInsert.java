package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utils.UniqueCode;
import domain.rentBean;
import service.feelist2DB_ser;
import service.rent2DB_ser;


public class rentInsert extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String building_id = request.getParameter("building_id");
		String rentperson_id = request.getParameter("rentperson_id");
		String feelist_id = request.getParameter("feelist_id");
		rentBean bean = new rentBean();
		bean.setBuilding_id(building_id);
		bean.setRentperson_id(rentperson_id);
		bean.setRent_id(UniqueCode.getUniqueCode());
		rent2DB_ser ser = new rent2DB_ser();
		feelist2DB_ser ser1 = new feelist2DB_ser();
		if(ser.insert(bean) == 1){
			if(ser1.delete(feelist_id) == 1){
				request.setAttribute("message", "������ȷ��");
			}else{
				request.setAttribute("message", "����ȷ��ʧ��");
			}
		}else{
			request.setAttribute("message", "����ȷ��ʧ��");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
