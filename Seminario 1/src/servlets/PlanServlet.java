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
			jspPage = "/Planes.jsp";
			List<String> tags = new ArrayList<String>();
			String fecha = request.getParameter("fecha");
			Date date;
			try {
				date = new SimpleDateFormat("dd mm yyyy").parse(fecha);

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

				Sistema.getInstance().generarPlanSemanal(tags, date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("listarPlanes".equals(action)) {

		}
		if (dispacher)
			super.dispatch(jspPage, request, response);
	}
}