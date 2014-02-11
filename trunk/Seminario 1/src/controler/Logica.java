package controler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import modelo.Cliente;
import modelo.EnumEstado;
import modelo.Ingrediente;
import modelo.ItemIngrediente;
import modelo.ItemMenu;
import modelo.Menu;
import modelo.OrdenDeCompra;
import modelo.Plan;
import modelo.PlanDiario;
import modelo.Restriccion;
import persistencia.ClientesDAO;
import persistencia.MenusDAO;
import persistencia.RestriccionesDAO;

public class Logica {

	public Plan generarPlanSemanal(List<String> tags, Date fechaComienzo) {
		// TODO armado del plan semanal con los planes diarios // Busco los
		// menús que coinciden con los tags ordenados

		Plan plan = new Plan();

		// Map<Date, PlanDiario> planesDiarios = new HashMap<Date,
		// PlanDiario>();
		List<PlanDiario> planesDiarios = new ArrayList<PlanDiario>();

		for (int i = 0; i <= 7; i++) { // cada día de la semana, empieza el
										// lunes

			List<Cliente> clientes = ClientesDAO.obtenerClientes();
			List<Menu> menus = new ArrayList<Menu>();

			Calendar fecha = Calendar.getInstance();
			fecha.setTime(fechaComienzo);

			PlanDiario planDiario = new PlanDiario(fecha.getTime());

			// Primer búsqueda: Busco solo 1 menu, que cumple con el tag y es el
			// que se uso hace mas tiempo

			// Obtenemos Los menus por prioridades definidas.
			Menu menuPrimeraPrioridad = MenusDAO.buscarMejorMenuPorTag(tags
					.get(i)); // Tag Fecha de uso
			List<Menu> menuSegundaPrioridad = MenusDAO
					.buscarMenusPorSecundaPri(); // Tag Restriccion
			List<Menu> menuTerceraPrioridad = MenusDAO
					.buscarMejorMenuPorTerceraPri(); // Restriccion

			// Agregamos las distintas Listas de menu a nuestra lista de
			// posibles menus para incorporar al plan
			menus.add(menuPrimeraPrioridad);
			menus.addAll(menuSegundaPrioridad);
			menus.addAll(menuTerceraPrioridad);

			Iterator<Menu> iterator = menus.iterator();
			Menu menu;

			while (clientes.size() > 0 && iterator.hasNext()) {
				menu = iterator.next();
				ItemMenu itemMenu = new ItemMenu();
				for (Cliente cliente : clientes) {
					if (menu.cumpleRestricciones(cliente.getRestricciones())) {
						itemMenu.getClientes().add(cliente);
						itemMenu.setCantidad(itemMenu.getCantidad() + 1);
						clientes.remove(cliente);
					}

				}

				if (itemMenu.getClientes().size() > 0) {
					itemMenu.setMenu(menu);
					menu.setUltimoUso(fecha.getTime());
					planDiario.getItems().add(itemMenu);
				}
			}
			/*
			 * COMPROBAMOS QUE NO HAYA QUEDADO NINGUN CLIENTE POR AFUERA DE LOS
			 * MENUS INCORPORADOS A NUESTRO PLAN EN CASO DE QUE TENGAMOS
			 * CLIENTES AFUERA DE NUESTRO PLAN GENERAMOS MENSAJE AL USUARIO
			 */
			if (clientes.size() > 0) {
				System.out
						.println("Los clientes que se listan a continuacion se encuentras sin plan:");
				for (Cliente cliente : clientes) {
					System.out.println(cliente.getNombre() + " "
							+ cliente.getApellido());
				}
			}
			fecha.add(fecha.DATE, 1);
			planesDiarios.add(planDiario);
		}

		plan.setItems(planesDiarios);

		return plan;
	}

	// private Map<Restriccion, Integer> obtenerRestriccionesPlatos(
	// List<Plato> platos) {
	// // TODO Auto-generated method stub
	// Map<Restriccion, Integer> mapaPlatos = new TreeMap<Restriccion,
	// Integer>();
	// // for (Plato plato : platos) {
	// // if mapaPlatos.get(plato.getR)
	// // mapaPlatos.put(key, value);
	// // }
	// return null;
	// }

	/*
	 * Devuelvo la lista de los menús
	 */

	private Map<Restriccion, Integer> obtenerRestriccionesClientes(
			List<Cliente> clientes) {
		Map<Restriccion, Integer> mapaClientes = new TreeMap<Restriccion, Integer>();
		// Cargo todas las restricciones con 0 en la cuenta
		List<Restriccion> restricciones = RestriccionesDAO
				.obtenerRestricciones();
		for (Restriccion restriccion : restricciones) {
			mapaClientes.put(restriccion, 0);
		}
		for (Cliente cliente : clientes) {
			for (Restriccion r : cliente.getRestricciones()) {
				mapaClientes.put(r, mapaClientes.get(r) + 1);
			}
		}
		return mapaClientes;
	}

	public Plan generarPlanSemanal() {
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("carne");
		tags.add("pasta");
		tags.add("pollo");
		tags.add("cerdo");
		tags.add("verduras");
		return generarPlanSemanal(tags, new Date());
	}

	

	public static OrdenDeCompra generarOrdenDeCompraPorPlan(Plan plan) {
		OrdenDeCompra oc;

		Map<Ingrediente, Float> items = new HashMap<Ingrediente, Float>();

		for (ItemIngrediente itemIngrediente : plan
				.obtenerIngredientesNecesarios()) {
			Ingrediente ingrediente = itemIngrediente.getIngrediente();
			Float cantidad = itemIngrediente.getCantidad();

			//TODO verificar el stock antes de agregarlo como algo a comprar!
			
			if (items.get(ingrediente) == null) {
				items.put(ingrediente, cantidad);
			} else {

				items.put(ingrediente, items.get(ingrediente) + cantidad);
			}

		}

		oc = new OrdenDeCompra(new Date(), plan.getFechaInicio(),
				EnumEstado.CREADA, items);

		return oc;
	}
}
