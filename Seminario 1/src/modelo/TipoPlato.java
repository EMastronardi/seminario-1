package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoPlato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoPlato;
	private String nombre;
	private String descripcion;
	
	public TipoPlato() {
		super();
	}

	public int getIdTipoPlato() {
		return idTipoPlato;
	}

	public void setIdTipoPlato(int idTipoPlato) {
		this.idTipoPlato = idTipoPlato;
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
