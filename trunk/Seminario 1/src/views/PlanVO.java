package views;

import java.util.Date;
import java.util.List;

import modelo.EnumEstado;

public class PlanVO {
	private int idPlan;
	private Date fechaInicio;
	private Date fecaFin;
	private EnumEstado estado;
	private List<PlanDiarioVO> items;

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

	public Date getFecaFin() {
		return fecaFin;
	}

	public void setFecaFin(Date fecaFin) {
		this.fecaFin = fecaFin;
	}

	public EnumEstado getEstado() {
		return estado;
	}

	public void setEstado(EnumEstado estado) {
		this.estado = estado;
	}

	public List<PlanDiarioVO> getItems() {
		return items;
	}

	public void setItems(List<PlanDiarioVO> items) {
		this.items = items;
	}

}
