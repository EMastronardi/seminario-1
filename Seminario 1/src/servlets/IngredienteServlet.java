package servlets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		boolean dispacher = true;	
		
		if ((action == null) || action.length() < 1) {
			jspPage = "/Home.jsp"; 
			super.dispatch(jspPage, request, response);
		}
		if ("default".equals(action)) {
			jspPage = "/Home.jsp";
			
		}else if("restriccionAjax".equals(action)){
			RestriccionVOList list =  sistema.getRestricciones();
			XStream xstream = new XStream(new DomDriver());
		    xstream.alias("restriccion", RestriccionVO.class);
		    xstream.alias("restricciones", RestriccionVOList.class);
		    xstream.addImplicitCollection(RestriccionVOList.class, "restricciones");

		    String xml = xstream.toXML(list);
		    response.setContentType("text/plain");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(xml);
	        dispacher = false;
		}else if("altaIngrediente".equals(action)){
			jspPage = "/Ingredientes.jsp";
			String name = request.getParameter("nombre");
			int cantidadStock = Integer.parseInt(request.getParameter("stock"));
			int diasCaducidad = Integer.parseInt(request.getParameter("diascaducidad"));
			String medida = request.getParameter("medida");
			boolean freezer = false;
			if(request.getParameter("freezer").equals("ok")){
				freezer = true;
			}
			List<String> estaciones = new ArrayList<String>();
			if(request.getParameter("otonio") != null) estaciones.add(request.getParameter("otonio")); 
			if(request.getParameter("invierno") != null) estaciones.add(request.getParameter("invierno")); 
			if(request.getParameter("primavera") != null) estaciones.add(request.getParameter("primavera")); 
			if(request.getParameter("verano") != null) estaciones.add(request.getParameter("verano")); 
			boolean rslt = sistema.altaIngrediente(name, cantidadStock, diasCaducidad, medida, freezer, estaciones);
			if(rslt){
				request.setAttribute("return", "OK");
			}else{
				request.setAttribute("return", "NOK");
			}
		}
		if(dispacher) super.dispatch(jspPage, request, response);
	}
}
