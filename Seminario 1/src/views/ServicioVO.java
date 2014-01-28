package views;

import modelo.Servicio;

public class ServicioVO {
	private int idServicio;
	private String nombre;
	private String descripcion;

	public ServicioVO() {
	}

	public ServicioVO(int idServicio, String nombre, String descripcion) {
		this.idServicio = idServicio;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public ServicioVO(Servicio s){
		this.idServicio = s.getIdServicio();
		this.nombre = s.getNombre();
		this.descripcion = s.getDescripcion();
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
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

}
