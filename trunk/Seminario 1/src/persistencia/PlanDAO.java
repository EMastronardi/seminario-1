package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Plan;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

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
	public static List<Plan> getPlanes() {
		Query query = s.createQuery("from Plan p");
		List<Plan> planes = (ArrayList<Plan>)query.list();
		return planes;
	}
	public static boolean existePlanVigente() {
		Query q  = s.createQuery("select count(p) from Plan p where p.estado = 3 "); 
		long cant = ((Long) q.uniqueResult()).longValue();
		if(cant > 0 )
			return true;
		else 
			return false;
	}

}
