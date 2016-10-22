package Units;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import domain.rentpersonBean;

public class testListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		
		ServletContext context = arg0.getSession().getServletContext();
		Object obj = arg0.getValue();
		Map map;
		if(obj instanceof rentpersonBean){
			System.out.println("login");
			map = (Map) context.getAttribute("map");
			if(map == null){
				map = new HashMap();
			}
			map.put(((rentpersonBean) obj).getRentperson_name(), arg0.getSession());
			context.setAttribute("map", map);
		}
	}

	
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		

	}

	
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		
	}

}
