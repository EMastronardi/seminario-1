package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//public class Restriccion implements Comparable<Restriccion> {
public class Restriccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRestriccion;
	private String nombre;
	private String descripcion;
	private int severidad;

	public Restriccion() {
		super();
	}

	public Restriccion(String nombre, String descripcion, int severidad) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.severidad = severidad;
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

//	@Override
//	public int compareTo(Restriccion restriccion) {
//		if (restriccion.getIdRestriccion() == this.idRestriccion){
//			return 0;
//		}
//		else {
//			return 1;
//		}
//	}

	@Override
	public boolean equals(Object obj) {
		if (Restriccion.class.isInstance(obj)){
			if (((Restriccion)obj).getIdRestriccion() == this.idRestriccion){
				return true;
			}
		}
		return false;
	}

	
	
}
