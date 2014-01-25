package persistencia;

import javax.servlet.jsp.tagext.Tag;

import modelo.ItemIngrediente;
import modelo.ItemMenu;
import modelo.Menu;
import modelo.Plato;
import modelo.Restriccion;
import modelo.TipoPlato;
import modelo.Usuario;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {


	private static SessionFactory sessionFactory = null;

	@SuppressWarnings("deprecation")
	private static SessionFactory configureSessionFactory()
			throws HibernateException {

		AnnotationConfiguration ac = new AnnotationConfiguration();
		ac.addAnnotatedClass(Usuario.class);
		ac.addAnnotatedClass(Menu.class);
		ac.addAnnotatedClass(ItemMenu.class);
		ac.addAnnotatedClass(Plato.class);
		ac.addAnnotatedClass(Tag.class);
		ac.addAnnotatedClass(TipoPlato.class);
		ac.addAnnotatedClass(Restriccion.class);
		ac.addAnnotatedClass(ItemIngrediente.class);
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
