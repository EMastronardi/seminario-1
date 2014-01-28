package views;

import modelo.Restriccion;

public class RestriccionVO {
	private int idRestriccion;
	private String nombre;
	private String descripcion;
	private int severidad;

	public RestriccionVO() {
	}
	public RestriccionVO(Restriccion r){
		this.idRestriccion = r.getIdRestriccion();
		this.nombre = r.getNombre();
		this.descripcion = r.getDescripcion();
		this.severidad = r.getSeveridad();
	}

	public int getIdRestriccion() {
		return idRestriccion;
	}

	public void setIdRestriccion(int idRestriccion) {
		this.idRestriccion = idRestriccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getSeveridad() {
		return severidad;
	}

	public void setSeveridad(int severidad) {
		this.severidad = severidad;
	}

}
