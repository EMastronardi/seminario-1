package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

import org.hibernate.Query;
import org.hibernate.Session;

import utilidades.GlobalsVars;
import views.ClienteVO;

public class ClientesDAO {

	private static Session s = GlobalsVars.HIBERATE_SESSION;

	public static void crearCliente(Cliente c) {
		s.persist(c);
	}

	public static List<Cliente> obtenerClientes() {
		// TODO Auto-generated method stub

		Query query = s.createQuery("from Cliente");
		List<Cliente> clientes = (ArrayList<Cliente>) query.list();

		return clientes;
	}
	public static ArrayList<ClienteVO> getClientesVO() {
		ArrayList<ClienteVO> clientes = new ArrayList<ClienteVO>();
		ArrayList<Cliente> clis = (ArrayList<Cliente>) s.createQuery(
				"from Cliente").list();

		for (Cliente c : clis) {
			ClienteVO cvo = new ClienteVO(c);
			clientes.add(cvo);
		}

		return clientes;
	}
}
