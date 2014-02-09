package persistencia;

import org.hibernate.Query;
import org.hibernate.Session;

import modelo.Plan;

public class PlanDAO {

	static Session s = HibernateUtil.getCurrent();
	
	public static Plan obtenerPlanPorId(int idPlan) {
		Query query = s.createQuery("from Plan p where p.idPlan = :idPlan");
		query.setInteger(":idPlan", idPlan);
		return (Plan) query.uniqueResult();
	}

}
