package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Servicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idServicio;
	private String nombre;
	private String descripcion;

	public Servicio() {
	}

	public Servicio(int idServicio, String nombre, String descripcion) {
		this.idServicio = idServicio;
		this.nombre = nombre;
		this.descripcion = descripcion;
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
