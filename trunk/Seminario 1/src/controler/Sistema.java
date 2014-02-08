package controler;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.Ingrediente;
import modelo.Restriccion;
import modelo.Usuario;

import org.hibernate.Session;

import persistencia.HibernateUtil;
import utilidades.GlobalsVars;
import views.ClienteVO;
import views.IngredienteVO;
import views.RestriccionVO;
import views.RestriccionVOList;
import auxiliares.Cargador;
public class Sistema {
	private static Sistema instancia;
	private Session s; 
	private Sistema(){
		s = GlobalsVars.HIBERATE_SESSION;
		//new InitializeSystems();
		Cargador.cargarDatos();
	}
	
	public static Sistema getInstance(){
		if(instancia == null)
			instancia = new Sistema();
		return instancia;
	}
	public boolean validarLogin(String user, String password) {
		Session s = HibernateUtil.getCurrent();
        List<Usuario> list = s.createQuery(" from Usuario e where e.nombre = :nombre and  e.password = :password").setString("nombre", user).setString("password",password).list();
        if(!list.isEmpty())
                return true;
        else
                return false;
	}
	public ArrayList<ClienteVO> getClientesVO(){
		ArrayList<ClienteVO> clientes = new ArrayList<ClienteVO>();
		Session s = HibernateUtil.getCurrent();
		
		ArrayList<Cliente> clis = (ArrayList<Cliente>)s.createQuery("from Cliente").list();
		
		for (Cliente c : clis) {
			ClienteVO cvo = new ClienteVO(c);
			clientes.add(cvo);
		}
		
		return clientes;
	}
	public ArrayList<IngredienteVO> getIngredientes(){
		ArrayList<IngredienteVO> ingredientes = new ArrayList<IngredienteVO>();
		
		ArrayList<Ingrediente> ing = (ArrayList<Ingrediente>)s.createQuery("from Ingrediente").list();

		for (Ingrediente ingrediente : ing) {
			IngredienteVO ingVO = new IngredienteVO(ingrediente);
			ingredientes.add(ingVO);
		}
		return ingredientes;
		
	}
	public RestriccionVOList getRestriccion(){
		RestriccionVOList restricciones = new RestriccionVOList();
		ArrayList<Restriccion> rest = (ArrayList<Restriccion>)s.createQuery("from Restriccion").list();
		for (Restriccion restriccion : rest) {
			RestriccionVO restriccionVO = new RestriccionVO(restriccion);
			restricciones.add(restriccionVO);
		}
		return restricciones;
	}
}
