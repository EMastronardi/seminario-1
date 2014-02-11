package views;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.EnumEstado;
import modelo.Plan;
import modelo.PlanDiario;

public class PlanVO {
	private int idPlan;
	private Date fechaInicio;
	private Date fechaFin;
	private String estado;
	private List<PlanDiarioVO> items;

	public PlanVO(){
		
	}
	
	
	
	public PlanVO(int idPlan, Date fechaInicio, Date fechaFin,
			String estado, List<PlanDiarioVO> items) {
		super();
		this.idPlan = idPlan;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.items = items;
	}



	public PlanVO(Plan plan) {
		List<PlanDiarioVO> planes = new ArrayList<PlanDiarioVO>();
		
		this.estado = plan.getEstado().toString();
		this.fechaFin = plan.getFechaFin();
		this.fechaInicio = plan.getFechaInicio();
		this.idPlan = plan.getIdPlan();
		for (PlanDiario planDiario : plan.getItems()) {
			planes.add(new PlanDiarioVO(planDiario));
		}
		this.items = planes;
	}



	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<PlanDiarioVO> getItems() {
		return items;
	}

	public void setItems(List<PlanDiarioVO> items) {
		this.items = items;
	}

}
