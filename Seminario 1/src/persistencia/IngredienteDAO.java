package persistencia;



import modelo.Ingrediente;

import org.hibernate.Query;
import org.hibernate.Session;

import utilidades.GlobalsVars;

public class IngredienteDAO {
	private static Session s = GlobalsVars.HIBERATE_SESSION;
	
	public static Ingrediente getIngredienteById(int idIngrediente){
		Ingrediente ing = (Ingrediente) s.get( Ingrediente.class, idIngrediente);
		return ing;
	}
	public static boolean deleteIngrediente(int id){
		Query query = s.createQuery("delete Ingrediente  where idIngrediente = :x");
		query.setParameter("x", id);
		int result = query.executeUpdate();
		return true;
	}

}