package views;

import java.util.Date;
import java.util.Map;

public class OrdenDeCompraVO {

	private Date fecha;
	private Map<String, Integer> items;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Map<String, Integer> getItems() {
		return items;
	}

	public void setItems(Map<String, Integer> items) {
		this.items = items;
	}

}
