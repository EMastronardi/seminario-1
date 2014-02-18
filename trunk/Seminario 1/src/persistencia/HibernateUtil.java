package persistencia;

import modelo.Cliente;
import modelo.Estacion;
import modelo.Ingrediente;
import modelo.ItemIngrediente;
import modelo.ItemMenu;
import modelo.Menu;
import modelo.Plan;
import modelo.PlanDiario;
import modelo.Plato;
import modelo.Restriccion;
import modelo.Servicio;
import modelo.ServicioCliente;
import modelo.Tag;
import modelo.TipoPago;
import modelo.Usuario;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtil {


	private static SessionFactory sessionFactory = null;

	@SuppressWarnings("deprecation")
	private static SessionFactory configureSessionFactory()
			throws HibernateException {

		AnnotationConfiguration ac = new AnnotationConfiguration();
		ac.addAnnotatedClass(Tag.class);
		ac.addAnnotatedClass(Plan.class);
		ac.addAnnotatedClass(PlanDiario.class);
		ac.addAnnotatedClass(Menu.class);
		ac.addAnnotatedClass(ItemMenu.class);
		ac.addAnnotatedClass(Plato.class);
		ac.addAnnotatedClass(Tag.class);
		//ac.addAnnotatedClass(TipoPlato.class);
		ac.addAnnotatedClass(Restriccion.class);
		ac.addAnnotatedClass(ItemIngrediente.class);
		ac.addAnnotatedClass(Ingrediente.class);
		ac.addAnnotatedClass(Estacion.class);
		ac.addAnnotatedClass(Cliente.class);
		ac.addAnnotatedClass(TipoPago.class);
		ac.addAnnotatedClass(ServicioCliente.class);
		ac.addAnnotatedClass(Servicio.class);
		sessionFactory = ac.buildSessionFactory();
		return sessionFactory;
	}

	private static SessionFactory getSessionFactory() {
		if(sessionFactory == null)
			sessionFactory = configureSessionFactory();
		return sessionFactory;
	}

	public static Session getCurrent() {
		return getSessionFactory().openSession();
	}
}
