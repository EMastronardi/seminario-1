package modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlan;
	private Date fechaInicio;
	private Date fecaFin;
	private EnumEstado estado;
	@OneToMany
	private List<PlanDiario> items;
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
	public List<PlanDiario> getItems() {
		return items;
	}
	public void setItems(List<PlanDiario> items) {
		this.items = items;
	}
	
	
	
}
