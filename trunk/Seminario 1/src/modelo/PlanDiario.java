package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PlanDiario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idItemPlan;
	private Date fecha;
	private boolean feriado;
	@OneToMany
	private List<ItemMenu> items;
	private String estado;

	public PlanDiario(){
		items = new ArrayList<ItemMenu>();
	}
	
	public PlanDiario(List<Tag> tags, List<Cliente> clientes){
		//TODO debo recorrer los clientes para obtener las restricciones que tienen y matchearlas con las restricciones de los platos.
		for (Cliente cliente : clientes) {
			//cliente.obtenerRestricciones();
		}
	}
	
	public int getIdItemPlan() {
		return idItemPlan;
	}

	public void setIdItemPlan(int idItemPlan) {
		this.idItemPlan = idItemPlan;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isFeriado() {
		return feriado;
	}

	public void setFeriado(boolean feriado) {
		this.feriado = feriado;
	}

	public List<ItemMenu> getItems() {
		return items;
	}

	public void setItems(List<ItemMenu> items) {
		this.items = items;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
