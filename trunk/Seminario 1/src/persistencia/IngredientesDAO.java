package persistencia;

import org.hibernate.Session;

import modelo.Ingrediente;

public class IngredientesDAO {
	static Session s = HibernateUtil.getCurrent();

	public static Ingrediente buscarIngredientePorId(int idIngrediente) {
		Ingrediente ingrediente;
		ingrediente = (Ingrediente) s.load(Ingrediente.class,idIngrediente);
		return ingrediente;
	}
	
}
