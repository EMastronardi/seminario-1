package views;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.ItemMenu;
import modelo.PlanDiario;

public class PlanDiarioVO {
	private int idItemPlan;
	private Date fecha;
	private boolean feriado;
	private List<ItemMenuVO> items;
	private String estado;
	private String tag;

	public PlanDiarioVO(int idItemPlan, Date fecha, boolean feriado,
			List<ItemMenuVO> items, String estado, String tag) {
		super();
		this.idItemPlan = idItemPlan;
		this.fecha = fecha;
		this.feriado = feriado;
		this.items = items;
		this.estado = estado;
		this.tag = tag;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public PlanDiarioVO(PlanDiario planDiario) {
		List<ItemMenuVO> items = new ArrayList<ItemMenuVO>();
		this.estado = planDiario.getEstado();
		this.fecha=planDiario.getFecha();
		this.feriado = planDiario.isFeriado();
		this.idItemPlan = planDiario.getIdItemPlan();
		for (ItemMenu itemMenu : planDiario.getItems()) {
			items.add(new ItemMenuVO(itemMenu));
		}
		this.items = items;
		this.tag = planDiario.getTag();
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

	@Override
	public String toString() {
		StringBuffer descripcion = new StringBuffer("");
		for (ItemMenuVO item : items) {
			descripcion.append(" - ").append(item.getNombre());
		}
		return descripcion.toString();
	}
	
	

}
