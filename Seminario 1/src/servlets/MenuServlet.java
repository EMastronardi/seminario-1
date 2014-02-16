package servlets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import views.EstacionVO;
import views.IngredienteVO;
import views.RestriccionVO;
import views.RestriccionVOList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class MenuServlet extends Controlador {
	public MenuServlet() {
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
			
		}else if("altaMenu".equals(action)){
			jspPage = "/Ingredientes.jsp";
			request.setAttribute("return", "OK");
			
		}else if("eliminarMenu".equals(action)){
			jspPage = "/Ingredientes.jsp";
			request.setAttribute("return", "OK");
		}	
		if(dispacher) super.dispatch(jspPage, request, response);
	}
}
