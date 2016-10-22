package WebUI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.page;
import service.Building2DB_ser;


public class IndexUI extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Building2DB_ser ser = new Building2DB_ser("dao.Building2DB");
		String page = request.getParameter("page");
		page p = ser.getHouse(Integer.parseInt(page));
		request.setAttribute("house", p);
		request.getRequestDispatcher("/WEB-INF/index2.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
