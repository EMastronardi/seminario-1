package persistencia;

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
