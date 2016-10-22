package WebUI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.holderBean;
import service.feelist2DB_ser;


public class feelistShowUI extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		feelist2DB_ser ser = new feelist2DB_ser();
		holderBean bean = (holderBean) request.getSession(false).getAttribute("user");
		List list = (List) ser.selectlist(bean.getHolder_id());
		request.setAttribute("feelist", list);
		request.getRequestDispatcher("/public/feelistShow.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
