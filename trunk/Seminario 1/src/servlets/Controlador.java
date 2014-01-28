package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Sistema;

public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected String action = "";
	protected String jspPage = "";

	public Controlador() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		action = request.getParameter("action");
		jspPage = "/Home.jsp";

		if ((action == null) || action.length() < 1) {
			jspPage = "/Home.jsp";

		}

		if ("default".equals(action)) {
			jspPage = "/Home.jsp";
		} /*else if ("validarLogin".equals(action)) {
			String user = request.getParameter("usuario");
			String password = request.getParameter("password");
			boolean usuarioValido = Sistema.getInstance().validarLogin(user,
					password);
			if (usuarioValido) {
				HttpSession s = request.getSession();
				s.setAttribute("usuario", user);
				jspPage = "/Home.jsp";
			}
		}*/
		dispatch(jspPage, request, response);

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void validarSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("usuario") == null
				|| session.getAttribute("usuario").equals("")) {
			jspPage = "/Login.jsp";
			action = "salir";

		}
	}

	protected void dispatch(String jsp, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (jsp != null) {
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		}
	}
}
