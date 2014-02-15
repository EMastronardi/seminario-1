package persistencia;



import modelo.Ingrediente;

import org.hibernate.Query;
import org.hibernate.Session;

import utilidades.GlobalsVars;

public class IngredienteDAO {
	private static Session s = GlobalsVars.HIBERATE_SESSION;
	
	public static void addIngrediente(Ingrediente ing) throws Exception{
		s.save(ing);
		s.flush();
	}
	public static Ingrediente getIngredienteById(int idIngrediente){
		Ingrediente ing = (Ingrediente) s.get( Ingrediente.class, idIngrediente);
		return ing;
	}
	public static void deleteIngrediente(int id) throws Exception{
		Query query = s.createQuery("delete Ingrediente  where idIngrediente = :x");
		query.setParameter("x", id);
		query.executeUpdate();
	}
	public static boolean editIngrediente(Ingrediente ing)throws Exception{
		s.merge(ing);
		s.flush();
		return true;
	}
	public static Ingrediente buscarIngredientePorId(int idIngrediente) {
		Ingrediente ingrediente;
		ingrediente = (Ingrediente) s.load(Ingrediente.class,idIngrediente);
		return ingrediente;
	}
}
