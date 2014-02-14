package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import views.ItemMenuVO;
import views.PlanDiarioVO;

@Entity
public class PlanDiario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idItemPlan;
	private Date fecha;
	private String turno;
	private boolean feriado;
	@ManyToMany
	@JoinColumn(name = "idItemPlan")
	private List<ItemMenu> items;
	private String estado;
	private String tag;

	public PlanDiario() {
		items = new ArrayList<ItemMenu>();
	}

	public PlanDiario(Date time) {
		// TODO Verificar que la fecha es feriado
		this();
		this.fecha = time;
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

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
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

	public List<ItemIngrediente> obtenerIngredientesNecesarios() {
		List<ItemIngrediente> ingredientesNecesarios = new ArrayList<ItemIngrediente>();
		for (ItemMenu itemMenu : items) {
			ingredientesNecesarios.addAll(itemMenu
					.obtenerIngredientesNecesarios());
		}
		return ingredientesNecesarios;
	}

	public String getTag() {

		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
