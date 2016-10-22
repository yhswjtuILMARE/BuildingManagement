package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.feelist2DB_ser;


public class removeFeelist extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String feelist_id = request.getParameter("feelist_id");
		feelist2DB_ser ser = new feelist2DB_ser();
		if(ser.delete(feelist_id) == 1){
			request.setAttribute("message", "¶©µ¥É¾³ý³É¹¦");
		}else{
			request.setAttribute("message", "¶©µ¥É¾³ýÊ§°Ü");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
