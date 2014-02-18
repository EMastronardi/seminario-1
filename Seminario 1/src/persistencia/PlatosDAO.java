package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Plato;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import utilidades.GlobalsVars;
import views.PlatoVO;

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
	
	public static ArrayList<PlatoVO> getPlatos() {
		ArrayList<PlatoVO> platos = new ArrayList<PlatoVO>();
		ArrayList<Plato> plat = (ArrayList<Plato>) s.createQuery("from Plato")
				.list();
		for (Plato plato : plat) {
			PlatoVO pvo = new PlatoVO(plato);
			platos.add(pvo);
		}
		return platos;
	}
	public static PlatoVO getPlatoVO(String idPlato) {
		Plato p = (Plato) s.createQuery(
				"from Plato p WHERE p.idPlato= " + idPlato).uniqueResult();
		PlatoVO pvo = new PlatoVO(p);
		return pvo;
	}
}
