package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import views.RestriccionVO;
import views.RestriccionVOList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import controler.Sistema;

public class PlanServlet extends Controlador {
	public PlanServlet() {
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
			
		}else if("generarPlan".equals(action)){
			jspPage = "/Planes.jsp";
			List<String> tags = new ArrayList<String>();
			tags.add(request.getParameter("tagLunes"));
			tags.add(request.getParameter("tagMartes"));
			tags.add(request.getParameter("tagMiercoles"));
			tags.add(request.getParameter("tagJueves"));
			tags.add(request.getParameter("tagViernes"));
			tags.add(request.getParameter("tagSabado"));
			tags.add(request.getParameter("tagDomingo"));
			
			Sistema.getInstance().generarPlanSemanal(tags, new Date());
			
		}else if("listarPlanes".equals(action)){
	
		}
		if(dispacher) super.dispatch(jspPage, request, response);
	}
}
