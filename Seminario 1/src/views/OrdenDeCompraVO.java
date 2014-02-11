package views;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import modelo.Ingrediente;
import modelo.OrdenDeCompra;

public class OrdenDeCompraVO {

	private Date fecha;
	private Map<String, Float> items;

	public OrdenDeCompraVO(OrdenDeCompra oc) {
		Map<String,Float> items = new HashMap<String, Float>();
		this.fecha= oc.getFecha();
		for (Entry<Ingrediente,Float> entry : oc.getItems().entrySet()) {
			items.put(entry.getKey().toString(), entry.getValue());
		}
		this.items = items;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Map<String, Float> getItems() {
		return items;
	}

	public void setItems(Map<String, Float> items) {
		this.items = items;
	}

}
