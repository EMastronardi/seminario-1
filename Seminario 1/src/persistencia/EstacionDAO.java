package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Estacion;

import org.hibernate.Session;

public class EstacionDAO {

	private static Session s = HibernateUtil.getCurrent();
	
	public static void crearEstacion(Estacion estacion){
		s.save(estacion);
	}
	public static List<Estacion> estaciones(){
		return (ArrayList<Estacion>)s.createQuery("from Estacion").list();
	}
}
