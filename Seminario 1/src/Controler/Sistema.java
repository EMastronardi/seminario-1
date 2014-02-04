package Controler;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.Ingrediente;
import modelo.Usuario;

import org.apache.catalina.Globals;
import org.apache.tomcat.jni.Global;
import org.hibernate.Session;

import auxiliares.Cargador;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import persistencia.HibernateUtil;
import persistencia.InitializeSystems;
import views.ClienteVO;
import views.IngredienteVO;
import Utils.GlobalsVars;
public class Sistema {
	private static Sistema instancia;
	private Session s; 
	private Sistema(){
		s = GlobalsVars.HIBERATE_SESSION;
		new InitializeSystems();
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
		Session s = HibernateUtil.getCurrent();
		
		ArrayList<Ingrediente> ing = (ArrayList<Ingrediente>)s.createQuery("from Ingrediente").list();

		for (Ingrediente ingrediente : ing) {
			IngredienteVO ingVO = new IngredienteVO(ingrediente);
			ingredientes.add(ingVO);
		}
		return ingredientes;
		
	}
	
}
