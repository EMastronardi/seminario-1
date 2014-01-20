package modelo;

import java.util.List;

import org.hibernate.Session;

import persistencia.HibernateUtil;

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
        List<Usuario> list = s.createQuery(" from Usuario e where e.nombre = ? and  e.password = ?").setString(0, user).setString(1,password).list();
        if(!list.isEmpty())
                return true;
        else
                return false;
	}
}
