package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Restriccion;

import org.hibernate.Query;
import org.hibernate.Session;

import utilidades.GlobalsVars;
import views.RestriccionVO;
import views.RestriccionVOList;

public class RestriccionesDAO {
	private static Session s = GlobalsVars.HIBERATE_SESSION;
	
	public static List<Restriccion> obtenerRestricciones() {
		// TODO Auto-generated method stub
		Query query = s.createQuery("from Restriccion");
		List<Restriccion> lista = (ArrayList<Restriccion>) query.list();
		return lista;
	}

	public static void agregarRestriccion(Restriccion r) {
		
		s.persist(r);
	}
	
	public static RestriccionVOList getRestricciones() {
		RestriccionVOList restricciones = new RestriccionVOList();
		ArrayList<Restriccion> rest = (ArrayList<Restriccion>) s.createQuery(
				"from Restriccion").list();
		for (Restriccion restriccion : rest) {
			RestriccionVO restriccionVO = new RestriccionVO(restriccion);
			restricciones.add(restriccionVO);
		}
		return restricciones;
	}
	public static RestriccionVOList getRestriccionesCliente(String idCliente) {
		RestriccionVOList restricciones = new RestriccionVOList();
		ArrayList<Restriccion> rest = (ArrayList<Restriccion>) s.createQuery(
				"select c.restricciones from Cliente c WHERE c.idCliente = "
						+ idCliente).list();
		for (Restriccion restriccion : rest) {
			RestriccionVO restriccionVO = new RestriccionVO(restriccion);
			restricciones.add(restriccionVO);
		}
		return restricciones;
	}

}
