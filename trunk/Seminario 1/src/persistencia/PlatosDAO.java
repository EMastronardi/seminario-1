package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import modelo.Plato;

public class PlatosDAO {

	public static List<Plato> buscarPlatosPorTag(String tag) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getCurrent();
		Query q =  s.createQuery("from Plato p where p.tag in (:tag)");
		q.setString(":tag", tag);
		ArrayList<Plato> platos = (ArrayList<Plato>) q.list();
		return platos;
	}

}
