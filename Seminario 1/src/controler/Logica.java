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
import modelo.ItemOrdenDeCompra;
import modelo.Menu;
import modelo.OrdenDeCompra;
import modelo.Plan;
import modelo.PlanDiario;
import modelo.Plato;
import modelo.Restriccion;
import modelo.Tag;
import persistencia.ClientesDAO;
import persistencia.IngredienteDAO;
import persistencia.MenusDAO;
import persistencia.OrdenDeCompraDAO;
import persistencia.RestriccionesDAO;
import persistencia.TagDAO;
import utilidades.GlobalsVars;

public class Logica {

	public static Plan generarPlanSemanal(List<String> tags,
			Date fechaComienzo, Date FechaFin) throws Exception {
		// TODO armado del plan semanal con los planes diarios // Busco los
		// menús que coinciden con los tags ordenados

		Plan plan = new Plan();
		plan.setEstado(EnumEstado.ACTIVO);
		// Map<Date, PlanDiario> planesDiarios = new HashMap<Date,
		// PlanDiario>();
		Map<Date, ArrayList<Tag>> mapaPlan = new HashMap<Date, ArrayList<Tag>>();

		Calendar start = Calendar.getInstance();
		start.setTime(fechaComienzo);
		Calendar end = Calendar.getInstance();
		end.setTime(FechaFin);
		int j = 0;
		for (Date date = start.getTime(); !start.after(end); start.add(
				Calendar.DATE, 1), date = start.getTime()) {
			ArrayList<Tag> tagsDiarios = new ArrayList<Tag>();
			Tag a = TagDAO.getTagById(Integer.parseInt(tags.get(j)));
			Tag b = TagDAO.getTagById(Integer.parseInt(tags.get(++j)));
			tagsDiarios.add(a);
			tagsDiarios.add(b);
			mapaPlan.put(date, tagsDiarios);
			j++;
		}

		List<PlanDiario> planesDiarios = new ArrayList<PlanDiario>();
		Iterator itera = mapaPlan.entrySet().iterator();
		int i = 0;
		while (itera.hasNext()) {
			Map.Entry me = (Map.Entry) itera.next();
			// me.getKey() -- FECHA
			// me.getValue() --ArrayList<Tag>
			// for (int i = 0; i <= 7; i++) { // cada día de la semana, empieza
			// el
			// lunes
			int turno = 0;
			for (Tag t : (ArrayList<Tag>) me.getValue()) {

				List<Cliente> clientes = ClientesDAO.obtenerClientes();
				List<Menu> menus = new ArrayList<Menu>();

				Calendar fecha = Calendar.getInstance();
				fecha.setTime((Date) me.getKey());

				PlanDiario planDiario = new PlanDiario(fecha.getTime());
				planDiario.setEstado(EnumEstado.ACTIVO);
				if (turno == 0) {
					planDiario.setTurno("almuerzo");
					turno++;
				} else {
					planDiario.setTurno("cena");
				}

				planDiario.setTag(t.getNombre());

				// Primer búsqueda: Busco solo 1 menu, que cumple con el tag y
				// es el
				// que se uso hace mas tiempo

				// Obtenemos Los menus por prioridades definidas.
				Menu menuPrimeraPrioridad = MenusDAO.buscarMejorMenuPorTag(t); // Tag
																				// Fecha
																				// de
																				// uso
				List<Menu> menuSegundaPrioridad = MenusDAO
						.buscarMenusPorSegundaPri(t); // Tag Restriccion
				List<Menu> menuTerceraPrioridad = MenusDAO
						.buscarMejorMenuPorTerceraPri(); // Restriccion

				// Agregamos las distintas Listas de menu a nuestra lista de
				// posibles menus para incorporar al plan
				if (menuPrimeraPrioridad != null)
					menus.add(menuPrimeraPrioridad);
				if (menuSegundaPrioridad != null)
					menus.addAll(menuSegundaPrioridad);
				if (menuTerceraPrioridad != null)
					menus.addAll(menuTerceraPrioridad);

				Iterator<Menu> iterator = menus.iterator();
				Menu menu;

				while (clientes.size() > 0 && iterator.hasNext()) {
					menu = iterator.next();
					ItemMenu itemMenu = new ItemMenu();
					List<Cliente> clientesAux = new ArrayList<Cliente>();
					clientesAux.addAll(clientes);
					for (Cliente cliente : clientes) {
						if (menu.cumpleRestricciones(cliente.getRestricciones())) {
							itemMenu.getClientes().add(cliente);
							itemMenu.setCantidad(itemMenu.getCantidad() + 1);
							clientesAux.remove(cliente);
						}

					}
					clientes = clientesAux;

					if (itemMenu.getClientes().size() > 0) {
						itemMenu.setMenu(menu);
						menu.setUltimoUso(fecha.getTime());
						planDiario.getItems().add(itemMenu);
					}
				}
				/*
				 * COMPROBAMOS QUE NO HAYA QUEDADO NINGUN CLIENTE POR AFUERA DE
				 * LOS MENUS INCORPORADOS A NUESTRO PLAN EN CASO DE QUE TENGAMOS
				 * CLIENTES AFUERA DE NUESTRO PLAN GENERAMOS MENSAJE AL USUARIO
				 */
				if (clientes.size() > 0) {
					System.out.println("----------------///////------------");
					System.out.println("planDiario:");
					System.out.println("Fecha: "
							+ planDiario.getFecha().toString());
					System.out.println("Tag: " + planDiario.getTag());
					System.out.println("Turno: " + planDiario.getTurno());
					System.out.println("Items usados en el del plan: ");
					int count = 0;
					for (ItemMenu itemMenu : planDiario.getItems()) {
						System.out.println("=======");
						System.out.println("itemMenu nro:" + ++i);

						System.out.println("Platos:");
						for (Plato p : itemMenu.getMenu().getPlatos()) {
							System.out.println(p.getNombre());
						}
						System.out.println("/-/-/-/-/-/-/-/");

					}
					System.out
							.println("====================*=====================");
					System.out
							.println("Los clientes que se listan a continuacion se encuentras sin plan:");
					for (Cliente cliente : clientes) {
						System.out.println(cliente.getNombre() + " "
								+ cliente.getApellido());
					}
				}

				planesDiarios.add(planDiario);
			}
		}
		plan.setItems(planesDiarios);
		OrdenDeCompra oc = generarOrdenDeCompraPorPlan(plan);
		if(oc!= null)
			OrdenDeCompraDAO.guardarOC(oc);
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

	/*
	 * public Plan generarPlanSemanal() { ArrayList<String> tags = new
	 * ArrayList<String>(); tags.add("carne"); tags.add("pasta");
	 * tags.add("pollo"); tags.add("cerdo"); tags.add("verduras"); return
	 * generarPlanSemanal(tags, new Date(), new Date()); }
	 */
	// backup generarOrdenDeCompraPorPlan
	// public static OrdenDeCompra generarOrdenDeCompraPorPlan(Plan plan) {
	// OrdenDeCompra oc;
	//
	// Map<Ingrediente, Float> items = new HashMap<Ingrediente, Float>();
	//
	// for (ItemIngrediente itemIngrediente : plan
	// .obtenerIngredientesNecesarios()) {
	// Ingrediente ingrediente = itemIngrediente.getIngrediente();
	// Ingrediente stockDeIngrediente = IngredienteDAO
	// .buscarIngredientePorId(ingrediente.getIdIngrediente());
	// Float cantidad = itemIngrediente.getCantidad()
	// - stockDeIngrediente.getCantidadStock();
	//
	// if (items.get(ingrediente) == null) {
	// items.put(ingrediente, cantidad);
	// } else {
	//
	// items.put(ingrediente, items.get(ingrediente) + cantidad);
	// }
	//
	// }
	//
	// oc = new OrdenDeCompra(new Date(), plan.getFechaInicio(),
	// EnumEstado.CREADA, items);
	//
	// return oc;
	// }

	public static OrdenDeCompra generarOrdenDeCompraPorPlan(Plan plan) {
		OrdenDeCompra oc;
		ArrayList<ItemOrdenDeCompra> items = new ArrayList<ItemOrdenDeCompra>();

		for (ItemIngrediente itemIngrediente : plan.obtenerIngredientesNecesarios()) {
			Ingrediente ingrediente = itemIngrediente.getIngrediente();
			Ingrediente stockDeIngrediente = IngredienteDAO .buscarIngredientePorId(ingrediente.getIdIngrediente());
			Float cantidad = stockDeIngrediente.getCantidadStock() - itemIngrediente.getCantidad();

			if (cantidad > 0) { // no compro, pero actualizo el stock del
								// ingrediente
				ingrediente.setCantidadStock(cantidad);
				GlobalsVars.HIBERATE_SESSION.update(ingrediente);
			}else{
				boolean encontrado = false;
				for (ItemOrdenDeCompra itm : items) {
					if (itm.getIngrediente().getIdIngrediente() == ingrediente
							.getIdIngrediente()) {
						encontrado = true;
						itm.setCantidad(itm.getCantidad() + (cantidad*-1));
					}
				}
				if (!encontrado) {
					ItemOrdenDeCompra itmOD = new ItemOrdenDeCompra();
					itmOD.setIngrediente(ingrediente);
					itmOD.setCantidad(cantidad);
					items.add(itmOD);
				}
			}

		}

		if(items.size()>0){
			oc = new OrdenDeCompra(new Date(), plan.getFechaInicio(),
				EnumEstado.CREADA, items);
		
		return oc;
		}else 
			return null;
	}
}
