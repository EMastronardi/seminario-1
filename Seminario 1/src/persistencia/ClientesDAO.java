package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

import org.hibernate.Query;
import org.hibernate.Session;

import utilidades.GlobalsVars;

public class ClientesDAO {

	private static Session session = GlobalsVars.HIBERATE_SESSION;

	public static void crearCliente(Cliente c) {
		session.persist(c);
	}

	public static List<Cliente> obtenerClientes() {
		// TODO Auto-generated method stub

		Query query = session.createQuery("from Cliente");
		List<Cliente> clientes = (ArrayList<Cliente>) query.list();

		return clientes;
	}
}
