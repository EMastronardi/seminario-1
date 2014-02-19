package persistencia;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import modelo.Plan;

public class PlanDAO {

	static Session s = HibernateUtil.getCurrent();
	
	public static Plan obtenerPlanPorId(int idPlan) {
		Query query = s.createQuery("from Plan p where p.idPlan = :idPlan");
		query.setInteger("idPlan", idPlan);
		Plan plan = (Plan)query.uniqueResult();
		return plan;
	}

	public static Plan obtenerPlanActual() {
		Criteria c = s.createCriteria(Plan.class);
		c.addOrder(Order.desc("idPlan"));
		c.setMaxResults(1);
		return (Plan)c.uniqueResult();
	}

	public static boolean existePlanVigente() {
		Query q  = s.createQuery("select count(p) from Plan p where p.estado = 3 "); 
		long cant  = (long)q.uniqueResult();
		if(cant > 0 )
			return true;
		else 
			return false;
	}

}
