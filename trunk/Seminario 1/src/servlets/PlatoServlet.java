package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import views.PlatoVO;
import views.RestriccionVO;
import views.RestriccionVOList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import controler.Sistema;

public class PlatoServlet extends Controlador {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PlatoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action = request.getParameter("action");
		jspPage = "/Home.jsp";
		boolean dispacher = true;	
		
		if ((action == null) || action.length() < 1) {
			jspPage = "/Home.jsp"; 
			super.dispatch(jspPage, request, response);
		}
		if ("default".equals(action)) {
			jspPage = "/Home.jsp";
			
		}else if("receta".equals(action)){
			String idPlato = request.getParameter("plato");
			PlatoVO pvo =  sistema.getPlatoVO(idPlato);
			XStream xstream = new XStream(new DomDriver());
		    xstream.alias("plato", PlatoVO.class);

		    String xml = xstream.toXML(pvo);
		    response.setContentType("text/plain");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(xml);
	        dispacher = false;
		}
		
        if(dispacher) super.dispatch(jspPage, request, response);
	}
}