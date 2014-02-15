package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Plato;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import utilidades.GlobalsVars;

public class PlatosDAO {

	private static Session s = GlobalsVars.HIBERATE_SESSION;
	
	public static List<Plato> buscarPlatosPorTag(String tag) {
		// TODO Auto-generated method stub
		Query q =  s.createQuery("from Plato p where p.tag in (:tag)");
		q.setString(":tag", tag);
		ArrayList<Plato> platos = (ArrayList<Plato>) q.list();
		return platos;
	}
	public static List<Plato> getPlatosById(List<Integer> platosId){
		List<Plato> platos =	(List<Plato>) s.createCriteria(Plato.class).add(Restrictions.in( "idPlato", platosId));
		return platos;
	}
}
