package controler;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.EnumMedida;
import modelo.Estacion;
import modelo.Ingrediente;
import modelo.OrdenDeCompra;
import modelo.Plan;
import modelo.Restriccion;
import modelo.Usuario;

import org.hibernate.Session;

import persistencia.EstacionDAO;
import persistencia.HibernateUtil;
import persistencia.IngredienteDAO;
import persistencia.PlanDAO;
import utilidades.GlobalsVars;
import utilidades.InitializeSystems;
import views.ClienteVO;
import views.EstacionVO;
import views.IngredienteVO;
import views.OrdenDeCompraVO;
import views.RestriccionVO;
import views.RestriccionVOList;



public class Sistema {
	private static Sistema instancia;
	private Session s;

	private Sistema() {
		s = GlobalsVars.HIBERATE_SESSION;
		//InitializeSystems.cargador();
		//Cargador.cargarDatos();
	}

	public static Sistema getInstance() {
		if (instancia == null)
			instancia = new Sistema();
		return instancia;
	}

	public boolean validarLogin(String user, String password) {
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
	}

	public ArrayList<ClienteVO> getClientesVO() {
		ArrayList<ClienteVO> clientes = new ArrayList<ClienteVO>();
		Session s = HibernateUtil.getCurrent();

		ArrayList<Cliente> clis = (ArrayList<Cliente>) s.createQuery(
				"from Cliente").list();

		for (Cliente c : clis) {
			ClienteVO cvo = new ClienteVO(c);
			clientes.add(cvo);
		}

		return clientes;
	}

	public ArrayList<IngredienteVO> getIngredientes() {
		ArrayList<IngredienteVO> ingredientes = new ArrayList<IngredienteVO>();

		ArrayList<Ingrediente> ing = (ArrayList<Ingrediente>) s.createQuery(
				"from Ingrediente").list();

		for (Ingrediente ingrediente : ing) {
			IngredienteVO ingVO = new IngredienteVO(ingrediente);
			ingredientes.add(ingVO);
		}
		return ingredientes;

	}

	public RestriccionVOList getRestricciones() {
		RestriccionVOList restricciones = new RestriccionVOList();
		ArrayList<Restriccion> rest = (ArrayList<Restriccion>) s.createQuery(
				"from Restriccion").list();
		for (Restriccion restriccion : rest) {
			RestriccionVO restriccionVO = new RestriccionVO(restriccion);
			restricciones.add(restriccionVO);
		}
		return restricciones;
	}
	public List<EstacionVO> getEstaciones(){
		List<EstacionVO> estacionesVO = new ArrayList<EstacionVO>();
		List<Estacion> estaciones = EstacionDAO.estaciones();
		for (Estacion estacion : estaciones) {
			estacionesVO.add(new EstacionVO(estacion));
		}
		return estacionesVO;
	}
	public boolean altaIngrediente(String name, int cantidadStock, int diasCaducidad, String medida,  boolean freezer, List<String> estaciones){
		try{
			Ingrediente ing = new Ingrediente();
			ing.setNombre(name);
			ing.setCantidadStock(cantidadStock);
			ing.setDiasCaducidad(diasCaducidad);
			ing.setFreezer(freezer);
			//EnumMedida medida;
			List<Estacion> sysEstaciones = EstacionDAO.estaciones();
			
			for (Estacion estacion : sysEstaciones) {
				if(estaciones.contains(estacion.getEstacion())){
					ing.addEstacion(estacion);
				}
			}
			ing.setMedida(EnumMedida.valueOf(medida));
			s.save(ing);	
			return true;
		}catch( Exception e){
			System.out.println("No se ha podido persistir el ingrediente");
			return false;
		}
	}
	public boolean bajaIngrediente(int idIngrediente){
		try{
			Ingrediente ing = IngredienteDAO.getIngredienteById(idIngrediente);
			s.delete(ing);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public OrdenDeCompraVO generarOrdenDeCompra(int idPlan) {

		Plan plan = PlanDAO.obtenerPlanPorId(idPlan);
		OrdenDeCompra oc = Logica.generarOrdenDeCompraPorPlan(plan);
		return oc.toVO();
	}

}
