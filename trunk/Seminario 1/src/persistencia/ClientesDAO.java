package persistencia;

import org.hibernate.Session;

import modelo.Cliente;

public class ClientesDAO {

	public static void crearCliente(Cliente c) {
		Session session = HibernateUtil.getCurrent();
		session.persist(c);
	}

}
