package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import views.IngredienteVO;
import views.PlatoVO;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

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
		}else if("ingredientes".equals(action)){
			List<IngredienteVO>ings = sistema.getIngredientesVO();
			XStream xstream = new XStream(new DomDriver());
			xstream.alias("ingrediente", IngredienteVO.class);

		    String xml = xstream.toXML(ings);
		    response.setContentType("text/plain");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(xml);
	        dispacher = false;
			
		}
		
        if(dispacher) super.dispatch(jspPage, request, response);
	}
}
