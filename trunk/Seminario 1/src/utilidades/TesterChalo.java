package utilidades;

import java.util.Date;
import java.util.List;

import modelo.Estacion;
import persistencia.EstacionDAO;
import persistencia.MenusDAO;
import persistencia.TagDAO;

public class TesterChalo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public static void prueba1(){
		System.out.println("-------------------------------------------");
		System.out.println("Datos del menu 4:");
		List<Estacion> estaciones = MenusDAO.getEstacionesDeMenu(4);
		for(Estacion e: estaciones){
			System.out.println("Estacion: "+e.getEstacion());
		}
		int cant = MenusDAO.getCantidadDeIngredientesDeMenu(1);
		System.out.println("Cant. de ingredientes: "+cant);
		System.out.println("---");
		System.out.println("Datos del menu 12:");
		estaciones = MenusDAO.getEstacionesDeMenu(12);
		for(Estacion e: estaciones){
			System.out.println("Estacion: "+e.getEstacion());
		}
		cant = MenusDAO.getCantidadDeIngredientesDeMenu(12);
		System.out.println("Cant. de ingredientes: "+cant);
		System.out.println("-------------------------------------------");
		List<modelo.Tag> tags = TagDAO.getAllTags();
		modelo.Tag tag = (modelo.Tag) tags.get(1);
		Estacion estacion = EstacionDAO.getEstacionPorFecha(new Date());
		System.out.println("Comienzo de pruebas: ");
		System.out.println("Tag: "+tag.getDescripcion());
		System.out.println("Estacion: "+estacion.getEstacion());
		System.out.println("-------------------------------------------");
		// primer menu
		modelo.Menu m = MenusDAO.buscarMejorMenuPorTag(tag, estacion.getEstacion());
		System.out.println("Primer menu: "+m.getIdMenu());
		System.out.println("-------------------------------------------");
		// segundo menu
		List<modelo.Menu> menus = MenusDAO.buscarMenusPorSegundaPri(tag, estacion.getEstacion());
		System.out.println("Cantidad de menus recuperados: "+menus.size());
		for(modelo.Menu me: menus){
			System.out.println("Segundo menu: "+me.getIdMenu());
		}
		System.out.println("-------------------------------------------");
		// tercer menu
		List<modelo.Menu> menus2 = MenusDAO.buscarMejorMenuPorTerceraPri(estacion.getEstacion());
		System.out.println("Cantidad de menus recuperados: "+menus2.size());
		for(modelo.Menu me: menus2){
			System.out.println("Tercer menu: "+me.getIdMenu());
		}
		System.out.println("-------------------------------------------");
	}
}
