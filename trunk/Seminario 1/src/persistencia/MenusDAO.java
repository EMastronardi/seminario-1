package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import modelo.Menu;
import modelo.Plato;

public class MenusDAO {
	
	static Session s = HibernateUtil.getCurrent();

	public static List<Menu> buscarMenusPorTag(String tag) {
		// TODO Auto-generated method stub
		Query q =  s.createQuery("from Menu m where m.tag = :tag");
		q.setString(":tag", tag);
		ArrayList<Menu> menus = (ArrayList<Menu>) q.list();
		return menus;
	}

	public static Menu buscarMejorMenuPorTag(String tag) {
		// TODO Auto-generated method stub
		Query q =  s.createQuery("from Menu m "
				+ " where m.tag = :tag"
				+ " order by m.ultimoUso");
		q.setString(":tag", tag);
		Menu menu = (Menu) q.uniqueResult();
		return menu;
	}

	public static List<Menu> buscarMenusPorTagYRestriccion(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Menu> buscarMenusPorSecundaPri() {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Menu> buscarMejorMenuPorTerceraPri() {
		// TODO Auto-generated method stub
		return null;
	}

}
