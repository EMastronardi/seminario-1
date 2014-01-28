package modelo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import persistencia.HibernateUtil;
import views.ClienteVO;

public class Sistema {
	private static Sistema instancia;
	private Sistema(){
		
	}
	
	public static Sistema getInstance(){
		if(instancia == null)
			instancia = new Sistema();
		return instancia;
	}
//public static void main(String[] args) {
//	Session s = HibernateUtil.getCurrent();
//    List<Usuario> list = s.createQuery(" from Usuario e where e.nombre = ? and  e.password = ?").setString(0, "test").setString(1,"test").list();
//    if(!list.isEmpty())
//    	System.out.println("La lista no esta empty");
//}
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
}
