package controler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Cliente;
import modelo.EnumEstado;
import modelo.EnumMedida;
import modelo.Estacion;
import modelo.Ingrediente;
import modelo.Menu;
import modelo.OrdenDeCompra;
import modelo.Plan;
import modelo.Plato;
import modelo.Restriccion;
import modelo.Tag;

import org.hibernate.Session;

import persistencia.ClientesDAO;
import persistencia.EstacionDAO;
import persistencia.IngredienteDAO;
import persistencia.ItemMenuDAO;
import persistencia.MenusDAO;
import persistencia.OrdenDeCompraDAO;
import persistencia.PlanDAO;
import persistencia.PlatosDAO;
import persistencia.RestriccionesDAO;
import persistencia.TagDAO;
import utilidades.GlobalsVars;
import views.ClienteVO;
import views.EstacionVO;
import views.IngredienteVO;
import views.ItemOrdenDeCompraVO;
import views.MenuVO;
import views.OrdenDeCompraVO;
import views.PlanVO;
import views.PlatoVO;
import views.RestriccionVO;
import views.RestriccionVOList;

public class Sistema {
	private static Sistema instancia;
	private Session s;

	private Sistema() {
		s = GlobalsVars.HIBERATE_SESSION;
		// InitializeSystems.cargador();
		// Cargador.cargarDatos();
	}

	public static Sistema getInstance() {
		if (instancia == null)
			instancia = new Sistema();
		return instancia;
	}

	/*public boolean validarLogin(String user, String password) {
		Session s = HibernateUtil.getCurrent();
		List<Usuario> list = s
				.createQuery(
						" from Usuario e where e.nombre = :nombre and  e.password = :password")
				.setString("nombre", user).setString("password", password)
				.list();
		if (!list.isEmpty())
			return true;
		else
			return false;
	}*/

	public ArrayList<PlatoVO> getPlatos() {
		return PlatosDAO.getPlatos();
	}
	
	public ArrayList<ClienteVO> getClientesVO() {

		return ClientesDAO.getClientesVO();
	}

	public ArrayList<IngredienteVO> getIngredientes() {
		return IngredienteDAO.getIngredientes();

	}

	public PlanVO obtenerPlanActual() {
		// TODO debo buscar el utimo plan que se genero
		Plan plan = PlanDAO.obtenerPlanActual();
		if (plan != null) {
			return new PlanVO(PlanDAO.obtenerPlanActual());
		}
		return null;

	}

	public RestriccionVOList getRestricciones() {
		return RestriccionesDAO.getRestricciones();
	}

	public RestriccionVOList getRestriccionesCliente(String idCliente) {
		
		return RestriccionesDAO.getRestriccionesCliente(idCliente);
	}

	public PlatoVO getPlatoVO(String idPlato) {
		
		return PlatosDAO.getPlatoVO(idPlato);
	}

	public List<EstacionVO> getEstaciones() {

		return EstacionDAO.getEstaciones();
	}

	public boolean altaIngrediente(String name, int cantidadStock,
			int diasCaducidad, String medida, boolean freezer,
			List<String> estaciones) {
		try {
			Ingrediente ing = new Ingrediente();
			ing.setNombre(name);
			ing.setCantidadStock(cantidadStock);
			ing.setDiasCaducidad(diasCaducidad);
			ing.setFreezer(freezer);
			// EnumMedida medida;
			List<Estacion> sysEstaciones = EstacionDAO.estaciones();

			for (Estacion estacion : sysEstaciones) {
				if (estaciones.contains(estacion.getEstacion())) {
					ing.addEstacion(estacion);
				}
			}
			ing.setMedida(EnumMedida.valueOf(medida));
			IngredienteDAO.addIngrediente(ing);
			return true;
		} catch (Exception e) {
			System.out.println("No se ha podido persistir el ingrediente");
			e.printStackTrace();
			return false;
		}
	}

	public boolean bajaIngrediente(int idIngrediente) {
		try {
			IngredienteDAO.deleteIngrediente(idIngrediente);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Map<Integer, String> getTags() {
		Map<Integer, String> result = new HashMap<Integer, String>();
		List<Tag> tags = TagDAO.getAllTags();
		for (Tag tag : tags) {
			result.put(tag.getIdTag(), tag.getNombre());
		}
		return result;
	}

	public boolean editIngrediente(int id, String name, int cantidadStock,
			int diasCaducidad, String medida, boolean freezer,
			List<String> estaciones) {
		try {
			Ingrediente ing = IngredienteDAO.getIngredienteById(id);
			ing.setIdIngrediente(id);
			ing.setNombre(name);
			ing.setCantidadStock(cantidadStock);
			ing.setDiasCaducidad(diasCaducidad);
			ing.setFreezer(freezer);
			// EnumMedida medida;
			List<Estacion> sysEstaciones = EstacionDAO.estaciones();
			ing.setEstaciones(new ArrayList<Estacion>());
			for (Estacion estacion : sysEstaciones) {
				if (estaciones.contains(estacion.getEstacion())) {
					ing.addEstacion(estacion);
				}
			}
			ing.setMedida(EnumMedida.valueOf(medida));
			IngredienteDAO.editIngrediente(ing);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public OrdenDeCompraVO generarOrdenDeCompra(int idPlan) {
		Plan plan = PlanDAO.obtenerPlanPorId(idPlan);
		OrdenDeCompra oc = Logica.generarOrdenDeCompraPorPlan(plan);
		return new OrdenDeCompraVO(oc);
	}

	public IngredienteVO getIngredienteById(int idIngrediente) {
		IngredienteVO result = null;
		Ingrediente ingaux = IngredienteDAO.getIngredienteById(idIngrediente);
		if (ingaux != null) {
			result = new IngredienteVO(ingaux);
		}
		return result;
	}

	public int generarPlanSemanal(List<String> tags, Date fechaInicio, Date fechaFin) {
		try{
			Plan plan = Logica.generarPlanSemanal(tags, fechaInicio, fechaFin);
			s.save(plan);
			s.flush();
			return plan.getIdPlan();
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}

	public List<MenuVO> getMenus() {
		List<MenuVO> retorno = new ArrayList<MenuVO>();
		List<Menu> menus = MenusDAO.getAllMenus();
		for (Menu menu : menus) {
			MenuVO menuvo = new MenuVO(menu);
			retorno.add(menuvo);
		}
		return retorno;
	}

	public boolean altaMenu(List<Integer> platosId, int idTag, int calorias,
			boolean estado) {
		try {
			Menu menu = new Menu();
			menu.setCalorias(calorias);
			Tag tag = TagDAO.getTagById(idTag);
			menu.setTag(tag);
			EnumEstado status = (estado) ? EnumEstado.ACTIVO
					: EnumEstado.INACTIVO;
			menu.setEstado(status);
			List<Plato> platos = PlatosDAO.getPlatosById(platosId);
			menu.setPlatos(platos);
			DateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
			String startDate = "1900-01-01";
			menu.setUltimoUso(parser.parse(startDate));
			MenusDAO.addMenu(menu);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public ArrayList<OrdenDeCompraVO> getOrdenesDeCompraVO(){
		return OrdenDeCompraDAO.getOrdenesDeCompraVO();
	}

	public boolean bajaMenu(int idMenu) {
		try {
			MenusDAO.deleteMenu(idMenu);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean editMenu(List<Integer> platosId, int idTag, int calorias,
			boolean estado) {
		try {
			Menu menu = new Menu();
			menu.setCalorias(calorias);
			Tag tag = TagDAO.getTagById(idTag);
			menu.setTag(tag);
			EnumEstado status = (estado) ? EnumEstado.ACTIVO
					: EnumEstado.INACTIVO;
			menu.setEstado(status);
			List<Plato> platos = PlatosDAO.getPlatosById(platosId);
			menu.setPlatos(platos);
			MenusDAO.editMenu(menu);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<IngredienteVO> getIngredientesVO() {

		ArrayList<IngredienteVO> ingVOList = new ArrayList<IngredienteVO>();
		ArrayList<Ingrediente> rest = (ArrayList<Ingrediente>) s.createQuery(
				"from Ingrediente").list();
		for (Ingrediente ing : rest) {
			IngredienteVO ingredienteVO = new IngredienteVO(ing);
			ingVOList.add(ingredienteVO);
		}
		return ingVOList;
	}

	public List<RestriccionVO> getRestriccionesVO(String idPlato) {
		ArrayList<RestriccionVO> resVOList = new ArrayList<RestriccionVO>();
		ArrayList<Restriccion> rest = (ArrayList<Restriccion>) s.createQuery("select p.restricciones from Plato p where p.idPlato = "+ idPlato).list();
		for (Restriccion r : rest) {
			RestriccionVO rvo = new RestriccionVO(r);
			resVOList.add(rvo);
		}
		
		return resVOList;
	}
	public PlanVO getPlanById(int idPlan){
		Plan pl = PlanDAO.obtenerPlanPorId(idPlan);
		PlanVO plan = new PlanVO(pl);
		return plan;
	}

	public List<ItemOrdenDeCompraVO> getItemsOrdenDeCompraVO(String idOc) {
		ArrayList<ItemOrdenDeCompraVO> vo = OrdenDeCompraDAO.getItemsOrdenCompraVO(idOc);
		return vo;
	}
	public List<ClienteVO> getClientesItemMenu(int idItemMenu){
		List<ClienteVO> result = new ArrayList<ClienteVO>();
		List<Cliente> clientes = ItemMenuDAO.getClientesByItemId(idItemMenu);
		if(clientes != null){
			for (Cliente cliente : clientes) {
				result.add(new ClienteVO(cliente));
			}
		}
		return result;
	}
	public List<PlanVO> getPlanesHistoricos(){
		List<PlanVO> result = new ArrayList<PlanVO>();
		List<Plan> planes = PlanDAO.getPlanes();
		
		for (Plan plan : planes) {
			PlanVO pvo = new PlanVO(plan);
			result.add(pvo);
		}
		return result;
	}

	public boolean existePlanvigente() {
		
		return PlanDAO.existePlanVigente();
	}
}