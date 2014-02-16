package persistencia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import utilidades.GlobalsVars;
import modelo.Menu;
import modelo.Plato;
import modelo.Tag;

public class MenusDAO {
	
	static Session s = GlobalsVars.HIBERATE_SESSION;

	public static List<Menu> getAllMenus(){
		List<Menu> menus = (ArrayList<Menu>)s.createQuery("from Menu").list();
		return menus;
	}
	
	public static void addMenu(Menu menu) throws Exception{
		s.save(menu);
		s.flush();
	}
	
	public static void editMenu(Menu menu)throws Exception{
		s.merge(menu);
		s.flush();
	}
	
	public static void deleteMenu(int menuId)throws Exception{
		Query query = s.createQuery("delete Menu where idMenu = :x");
		query.setParameter("x", menuId);
		query.executeUpdate();
	}
	
	public static List<Menu> buscarMenusPorTag(String tag) {
		// TODO Auto-generated method stub
		Query q =  s.createQuery("from Menu m where m.tag = :tag");
		q.setString(":tag", tag);
		ArrayList<Menu> menus = (ArrayList<Menu>) q.list();
		return menus;
	}

	public static Menu buscarMejorMenuPorTag(Tag tag) {
		// TODO Auto-generated method stub
		Query q =  s.createQuery("from Menu m "
				+ " where m.tag.idTag = "+tag.getIdTag()
				+ " order by m.ultimoUso");
		
		Menu menu = (Menu) q.list().get(0);
		return menu;
	}

	public static List<Menu> buscarMenusPorSegundaPri(Tag t) {
		// Menus que cumplan con tag y que ademas esten ordenados por la cantidad de restricciones que cumplen (menor a mayor)
		
		List menus = s.createQuery("select m.idMenu,m.ultimoUso, count(r.idRestriccion) from Menu m join m.platos p join p.restricciones r where m.tag.idTag = " + t.getIdTag() + " group by m.idMenu, m.ultimoUso order by count(r.idRestriccion) asc, m.ultimoUso asc").list();
		
		Iterator ite = menus.iterator();
		List<Integer> idsMenus =new ArrayList<Integer>();
		while(ite.hasNext()){
			Object [] objects = (Object []) ite.next();
			idsMenus.add((Integer)objects[0]);
		}
		return getMenusByIds(idsMenus);
	}
	
	public static List<Menu> buscarMejorMenuPorTerceraPri() {
		List<Integer> menus = (List<Integer>)s.createQuery("select m.idMenu, m.ultimoUso, count(r.idRestriccion) from Menu m join m.platos p join p.restricciones r  group by m.idMenu, m.ultimoUso order by count(r.idRestriccion) asc, m.ultimoUso asc").list();
		Iterator ite = menus.iterator();
		List<Integer> idsMenus =new ArrayList<Integer>();
		while(ite.hasNext()){
			Object [] objects = (Object []) ite.next();
			idsMenus.add((Integer)objects[0]);
		}
		return getMenusByIds(idsMenus);

	}
	
	public static List<Menu> getMenusByIds(List<Integer> menusesId){
		List<Menu> menus = (ArrayList<Menu>)s.createCriteria(Menu.class).add( Restrictions.in( "idMenu", menusesId)).list();
		return menus;
	}

}
