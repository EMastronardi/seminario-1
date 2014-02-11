package views;

import java.util.Date;
import java.util.List;

public class PlanDiarioVO {
	private int idItemPlan;
	private Date fecha;
	private boolean feriado;
	private List<ItemMenuVO> items;
	private String estado;

	public PlanDiarioVO(int idItemPlan, Date fecha, boolean feriado,
			List<ItemMenuVO> items, String estado) {
		super();
		this.idItemPlan = idItemPlan;
		this.fecha = fecha;
		this.feriado = feriado;
		this.items = items;
		this.estado = estado;
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

	public List<ItemMenuVO> getItems() {
		return items;
	}

	public void setItems(List<ItemMenuVO> items) {
		this.items = items;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
