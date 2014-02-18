package views;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import modelo.EnumEstado;
import modelo.Ingrediente;
import modelo.ItemOrdenDeCompra;
import modelo.OrdenDeCompra;

public class OrdenDeCompraVO {

	private int idOrdenDecompra;
	private Date fechaCreacion;
	private Date fechaInicioPlan;
	private EnumEstado estado;
	private Map<String, Float> items;

	public OrdenDeCompraVO(OrdenDeCompra oc) {
		Map<String,Float> items = new HashMap<String, Float>();
		this.fechaCreacion= oc.getFecha();
		for (ItemOrdenDeCompra entry : oc.getItems()) {
			items.put(entry.getIngrediente().getNombre(), entry.getCantidad());
		}
		this.items = items;
		this.idOrdenDecompra = oc.getIdOrdenDeCompra();
		this.fechaCreacion = oc.getFechaCreacion();
		this.fechaInicioPlan = oc.getFechaInicioPlan();
		this.estado = oc.getEstado();
		
	}

	public Date getFecha() {
		return fechaCreacion;
	}

	public void setFecha(Date fecha) {
		this.fechaCreacion = fecha;
	}

	public Map<String, Float> getItems() {
		return items;
	}

	public void setItems(Map<String, Float> items) {
		this.items = items;
	}

	public int getIdOrdenDecompra() {
		return idOrdenDecompra;
	}

	public void setIdOrdenDecompra(int idOrdenDecompra) {
		this.idOrdenDecompra = idOrdenDecompra;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaInicioPlan() {
		return fechaInicioPlan;
	}

	public void setFechaInicioPlan(Date fechaInicioPlan) {
		this.fechaInicioPlan = fechaInicioPlan;
	}

	public EnumEstado getEstado() {
		return estado;
	}

	public void setEstado(EnumEstado estado) {
		this.estado = estado;
	}

}
