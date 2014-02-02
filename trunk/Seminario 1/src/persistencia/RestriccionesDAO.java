package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Restriccion;

import org.hibernate.Query;
import org.hibernate.Session;

public class RestriccionesDAO {

	public static List<Restriccion> obtenerRestricciones() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getCurrent();
		Query query = session.createQuery("from Restriccion");
		List<Restriccion> lista = (ArrayList<Restriccion>) query.list();
		return lista;
	}

	public static void agregarRestriccion(Restriccion r) {
		Session session = HibernateUtil.getCurrent();
		session.persist(r);
	}

}
