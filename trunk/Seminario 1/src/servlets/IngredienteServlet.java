package servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		}
		if ("default".equals(action)) {
			jspPage = "/Home.jsp";
		}
		super.dispatch(jspPage, request, response);
	}
}
