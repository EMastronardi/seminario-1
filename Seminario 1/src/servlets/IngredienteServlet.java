package servlets;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import views.RestriccionVO;
import views.RestriccionVOList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class IngredienteServlet extends Controlador {
	
	public IngredienteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action = request.getParameter("action");
		jspPage = "/Home.jsp";
		
		if ((action == null) || action.length() < 1) {
			jspPage = "/Home.jsp"; 
			super.dispatch(jspPage, request, response);
		}
		if ("default".equals(action)) {
			jspPage = "/Home.jsp";
			super.dispatch(jspPage, request, response);
		}else if("restriccionAjax".equals(action)){
			RestriccionVOList list =  sistema.getRestriccion();
			XStream xstream = new XStream(new DomDriver());
		    xstream.alias("restriccion", RestriccionVO.class);
		    xstream.alias("restricciones", RestriccionVOList.class);
		    xstream.addImplicitCollection(RestriccionVOList.class, "restricciones");

		    String xml = xstream.toXML(list);
		    response.setContentType("text/plain");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(xml);
		}
		
	}
}
