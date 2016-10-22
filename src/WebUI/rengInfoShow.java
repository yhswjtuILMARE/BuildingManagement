package WebUI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.holderBean;
import service.rent2DB_ser;


public class rengInfoShow extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		holderBean bean = (holderBean) request.getSession(false).getAttribute("user");
		rent2DB_ser ser = new rent2DB_ser();
		List list = ser.selectlist(bean.getHolder_id());
		request.setAttribute("rent", list);
		request.getRequestDispatcher("/public/rentShow.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
