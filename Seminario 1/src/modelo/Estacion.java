package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstacion;
	private String estacion;

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
