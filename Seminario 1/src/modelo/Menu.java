package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMenu;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idMenu")
	private List<Plato> platos;
	private int calorias;
	private EnumEstado estado;
	private Date ultimoUso;
	
	public Date getUltimoUso() {
		return ultimoUso;
	}

	public void setUltimoUso(Date ultimoUso) {
		this.ultimoUso = ultimoUso;
	}

	public void setRestricciones(List<Restriccion> restricciones) {
		this.restricciones = restricciones;
	}

	@Transient
	private List<Restriccion> restricciones;

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public List<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	public EnumEstado getEstado() {
		return estado;
	}

	public void setEstado(EnumEstado estado) {
		this.estado = estado;
	}

	public boolean cumpleRestricciones(List<Restriccion> restricciones) {

		if (restricciones.size() == 0) {
			return true;
		} else {
			for (Restriccion restriccion : restricciones) {
				if (this.getRestricciones().contains(restriccion)) {
					return false;
				}
			}
		}

		return true;

	}

	private List<Restriccion> getRestricciones() {
		if (this.restricciones == null) {
			restricciones = new ArrayList<Restriccion>();
			for (Plato plato : platos) {
				restricciones.addAll(plato.getRestricciones());
			}
		}

		return restricciones;
	}
}
