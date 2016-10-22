package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.rent2DB_ser;


public class Deleterent extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rent_id = request.getParameter("rent_id");
		rent2DB_ser ser = new rent2DB_ser();
		if(ser.delete(rent_id) == 1){
			request.setAttribute("message", "É¾³ý³É¹¦");
		}else{
			request.setAttribute("message", "É¾³ýÊ§°Ü");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
