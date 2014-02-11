package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import views.PlanDiarioVO;
import views.PlanVO;

@Entity
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlan;

	private EnumEstado estado;
	@OneToMany
	@JoinColumn(name = "idPlan")
	private List<PlanDiario> items;

	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public Date getFechaInicio() {
		Date fechaInicio = items.get(0).getFecha();
		for (PlanDiario plan : items) {
			if (plan.getFecha().before(fechaInicio)) {
				fechaInicio = plan.getFecha();
			}
		}
		return fechaInicio;
	}

	public Date getFechaFin() {
		Date fechaFin = items.get(0).getFecha();
		for (PlanDiario plan : items) {
			if (plan.getFecha().after(fechaFin)) {
				fechaFin = plan.getFecha();
			}
		}
		return fechaFin;
	}

	public EnumEstado getEstado() {
		return estado;
	}

	public void setEstado(EnumEstado estado) {
		this.estado = estado;
	}

	public List<PlanDiario> getItems() {
		return items;
	}

	public void setItems(List<PlanDiario> items) {
		this.items = items;
	}

	public List<ItemIngrediente> obtenerIngredientesNecesarios() {

		List<ItemIngrediente> ingredientesNecesarios = new ArrayList<ItemIngrediente>();

		for (PlanDiario planDiario : items) {
			ingredientesNecesarios.addAll(planDiario
					.obtenerIngredientesNecesarios());
		}
		return ingredientesNecesarios;
	}



}
