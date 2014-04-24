package persistencia;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Estacion;
import modelo.Plato;

import org.hibernate.Session;

import views.EstacionVO;
import views.PlatoVO;

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
	
	public static Estacion getEstacionPorNombre(String nombreEstacion) {
		Estacion e = (Estacion) s.createQuery(
				"from Estacion e WHERE e.estacion = :x").setParameter("x",nombreEstacion).uniqueResult();
		return e;
	}
	
	public static Estacion getEstacionPorFecha(Date myDate){
		DateFormat df = new SimpleDateFormat("MM");
		String numeroMesStr = df.format(myDate);
		int n = Integer.parseInt(numeroMesStr);
		String nombreEstacion = "";
		
		/*
		* MES                  TABLA
		* 1,2,3                Verano
		* 4,5,6                Otoño
		* 7,8,9                Invierno
		* 10,11,12             Primavera
		*/

		if(n>0&&n<4){
			nombreEstacion = "Verano";
		}
		else if(n>3&&n<7){
			nombreEstacion = "Otoño";
		}
		else if(n>6&&n<10){
			nombreEstacion = "Invierno";
		}
		else if(n>9&&n<13){
			nombreEstacion = "Primavera";
		}
		return EstacionDAO.getEstacionPorNombre(nombreEstacion);
	}
}
