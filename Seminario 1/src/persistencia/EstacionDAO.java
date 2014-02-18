package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Estacion;

import org.hibernate.Session;

import views.EstacionVO;

public class EstacionDAO {

	private static Session s = HibernateUtil.getCurrent();
	
	public static void crearEstacion(Estacion estacion){
		s.save(estacion);
	}
	public static List<Estacion> estaciones(){
		return (ArrayList<Estacion>)s.createQuery("from Estacion").list();
	}
	public static List<EstacionVO> getEstaciones() {
		List<EstacionVO> estacionesVO = new ArrayList<EstacionVO>();
		List<Estacion> estaciones = EstacionDAO.estaciones();
		for (Estacion estacion : estaciones) {
			estacionesVO.add(new EstacionVO(estacion));
		}
		return estacionesVO;
	}
}
