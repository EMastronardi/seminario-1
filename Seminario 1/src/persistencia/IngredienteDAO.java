package persistencia;



import modelo.Ingrediente;

import org.hibernate.Query;
import org.hibernate.Session;

import utilidades.GlobalsVars;

public class IngredienteDAO {
	private static Session s = GlobalsVars.HIBERATE_SESSION;
	
	public static Ingrediente getIngredienteById(int idIngrediente){
		Query query = s.createQuery("from Ingrediente i where i.idIngrediente = :id");
		query.setInteger(":id", idIngrediente);
		return (Ingrediente) query.uniqueResult();
	}

}
