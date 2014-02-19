package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		action = request.getParameter("action");
		jspPage = "/Home.jsp";
		boolean dispacher = true;

		if ((action == null) || action.length() < 1) {
			jspPage = "/Home.jsp";
			super.dispatch(jspPage, request, response);
		}
		if ("default".equals(action)) {
			jspPage = "/Home.jsp";

		} else if ("generarPlan".equals(action)) {
			jspPage = "/GenerarPlan.jsp";
			
			//Generar Plan si no existe plan VIGENTE
			
			if(Sistema.getInstance().existePlanvigente()){
				request.setAttribute("planVigente", "Error al generar Plan, existe otro Plan Vigente");
				
			}else{
				List<String> tags = new ArrayList<String>();
				String fechaI = null, fechaF = null;
				if(request.getParameter("fechaInicio") != null)
					fechaI = request.getParameter("fechaInicio");
				else
					fechaI = "";
				if(request.getParameter("fechaInicio") != null)
						fechaF = request.getParameter("fechaFin");
				else
					fechaF = "";
				Date fechaInicio;
				Date fechaFin;
				try {
					fechaInicio = new SimpleDateFormat("dd-MM-yyyy").parse(fechaI);
					fechaFin = new SimpleDateFormat("dd-MM-yyyy").parse(fechaF);
	
					// Id del tag en cada uno de estos
					if (request.getParameter("tagLunesAlm") != null)
						tags.add(request.getParameter("tagLunesAlm"));
					if (request.getParameter("tagLunesCen") != null)
						tags.add(request.getParameter("tagLunesCen"));
					if (request.getParameter("tagMartesAlm") != null)
						tags.add(request.getParameter("tagMartesAlm"));
					if (request.getParameter("tagMartesCen") != null)
						tags.add(request.getParameter("tagMartesCen"));
					if (request.getParameter("tagMiercolesAlm") != null)
						tags.add(request.getParameter("tagMiercolesAlm"));
					if (request.getParameter("tagMiercolesCen") != null)
						tags.add(request.getParameter("tagMiercolesCen"));
					if (request.getParameter("tagJuevesAlm") != null)
						tags.add(request.getParameter("tagJuevesAlm"));
					if (request.getParameter("tagJuevesAlm") != null)
						tags.add(request.getParameter("tagJuevesCen"));
					if (request.getParameter("tagViernesAlm") != null)
						tags.add(request.getParameter("tagViernesAlm"));
					if (request.getParameter("tagViernesCen") != null)
						tags.add(request.getParameter("tagViernesCen"));
	
					int retorno = Sistema.getInstance().generarPlanSemanal(tags,fechaInicio, fechaFin);
					if(retorno > 0){
						jspPage = "/ViewPlanGenerado.jsp";
						request.setAttribute("return", "OK");
						request.setAttribute("idPlan", retorno);
					}else{
						request.setAttribute("return", "NOK");
					}
				
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if ("listarPlanes".equals(action)) {

		}
		if (dispacher)
			super.dispatch(jspPage, request, response);
	}
}
