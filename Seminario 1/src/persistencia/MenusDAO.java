package persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import utilidades.GlobalsVars;
import modelo.Estacion;
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
	
	/*
	public static Menu buscarMejorMenuPorTag(Tag tag) {
		// TODO Auto-generated method stub
		Query q =  s.createQuery("from Menu m "
				+ " where m.tag.idTag = "+tag.getIdTag()
				+ " order by m.ultimoUso");
		
		Menu menu = (Menu) q.list().get(0);
		return menu;
	}
	*/
	
	public static Menu buscarMejorMenuPorTag(Tag tag, String estacion) {
		// TODO Auto-generated method stub
		Query q =  s.createQuery("from Menu mp "
				+ "where mp.tag.idTag = :s "
				+ "and :e in ("
					+ "select e.estacion "
					+ "from Menu m "
					+ "join m.platos p "
					+ "join p.ingredientes it "
					+ "join it.ingrediente i "
					+ "join i.estaciones e "
					+ "where m.idMenu = mp.idMenu "
					+ "group by e.estacion "
					+ "having count(*) >= ("
						+ "select count(distinct i1) "
						+ "from Menu m1 "
						+ "join m1.platos p1 "
						+ "join p1.ingredientes it1 "
						+ "join it1.ingrediente i1 "
						+ "where m1.idMenu = mp.idMenu"
					+ ")"
				+ ") "
				+ "order by mp.ultimoUso");
		q.setInteger("s", tag.getIdTag());
		q.setString("e", estacion);
		Menu menu = (Menu) q.list().get(0);
		return menu;
	}

	public static List<Menu> buscarMenusPorSegundaPri(Tag t, String estacion) {
		// Menus que cumplan con tag y que ademas esten ordenados por la cantidad de restricciones que cumplen (menor a mayor)
		
		 Query query = s.createQuery("select mp.idMenu,mp.ultimoUso, count(rp.idRestriccion) " 
				+ "from Menu mp join mp.platos pp join pp.restricciones rp "
				+ "where mp.tag.idTag = :x "
				+ "and :e in ("
					+ "select e.estacion "
					+ "from Menu m "
					+ "join m.platos p "
					+ "join p.ingredientes it "
					+ "join it.ingrediente i "
					+ "join i.estaciones e "
					+ "where m.idMenu = mp.idMenu "
					+ "group by e.estacion "
					+ "having count(*) >= ("
						+ "select count(distinct i1) "
						+ "from Menu m1 "
						+ "join m1.platos p1 "
						+ "join p1.ingredientes it1 "
						+ "join it1.ingrediente i1 "
						+ "where m1.idMenu = mp.idMenu"
					+ ")"
				+ ")"
				+ "group by mp.idMenu, mp.ultimoUso "
				+ "order by count(rp.idRestriccion) asc, mp.ultimoUso asc");
		query.setInteger("x", t.getIdTag());
		query.setString("e", estacion);
		List menus = query.list();
		Iterator ite = menus.iterator();
		List<Integer> idsMenus =new ArrayList<Integer>();
		while(ite.hasNext()){
			Object [] objects = (Object []) ite.next();
			idsMenus.add((Integer)objects[0]);
		}
		return getMenusByIds(idsMenus);
	}
	
	public static List<Menu> buscarMejorMenuPorTerceraPri(String estacion) {
		 Query query = s.createQuery("select mp.idMenu, mp.ultimoUso, count(rp.idRestriccion) " +
				"from Menu mp join mp.platos pp join pp.restricciones rp  " +
				"where :e in ("
					+ "select e.estacion "
					+ "from Menu m "
					+ "join m.platos p "
					+ "join p.ingredientes it "
					+ "join it.ingrediente i "
					+ "join i.estaciones e "
					+ "where m.idMenu = mp.idMenu "
					+ "group by e.estacion "
					+ "having count(*) >= ("
						+ "select count(distinct i1) "
						+ "from Menu m1 "
						+ "join m1.platos p1 "
						+ "join p1.ingredientes it1 "
						+ "join it1.ingrediente i1 "
						+ "where m1.idMenu = mp.idMenu"
					+ ")"
				+ ")" +
				"group by mp.idMenu, mp.ultimoUso " +
				"order by count(rp.idRestriccion) asc, mp.ultimoUso asc");
		query.setString("e", estacion);
		List<Integer> menus = (List<Integer>) query.list();
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
	
	public static List<Estacion> getEstacionesDeMenu(int idMenu){
		//Query query = s.createQuery("select distinct user.firstname from User user");
		int cantIngredientes = MenusDAO.getCantidadDeIngredientesDeMenu(idMenu);
		Query query = s.createQuery(
				"select e1 from Estacion e1 where e1.estacion in (" +
				"select e.estacion " +
				"from Menu m " +
				"join m.platos p " +
				"join p.ingredientes it " +
				"join it.ingrediente i " +
				"join i.estaciones e " +
				"where m.idMenu = :x " +
				"group by e.estacion " +
				"having count(*) >= :y" +
				")");
		query.setInteger("x", idMenu);
		query.setInteger("y", cantIngredientes);
		List<Estacion> list = (ArrayList<Estacion>) query.list();
		return list;
	}
	
	public static int getCantidadDeIngredientesDeMenu(int idMenu){
		//Query query = s.createQuery("select distinct user.firstname from User user");
		Query query = s.createQuery(
				"select count(distinct i) " +
				"from Menu m " +
				"join m.platos p " +
				"join p.ingredientes it " +
				"join it.ingrediente i " +
				"where m.idMenu = :x");
		query.setInteger("x", idMenu);
		int cantidad = ((Long) query.uniqueResult()).intValue();
		return cantidad;
	}

}
