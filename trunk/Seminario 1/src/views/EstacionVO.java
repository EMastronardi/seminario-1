package views;

import modelo.Estacion;

public class EstacionVO {	
	private int idEstacion;
	private String estacion;
	
	public EstacionVO() {
	}
	public EstacionVO(Estacion estacion) {
		super();
		this.idEstacion = estacion.getIdEstacion();
		this.estacion = estacion.getEstacion();
	}

	public int getIdEstacion() {
		return idEstacion;
	}

	public void setIdEstacion(int idEstacion) {
		this.idEstacion = idEstacion;
	}

	public String getEstacion() {
		return estacion;
	}

	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}
}
