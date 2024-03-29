package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import views.MenuVO;
import views.PlatoVO;

@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMenu;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idMenu")
	private List<Plato> platos;
	@OneToOne
	private Tag tag;
	private int calorias;
	@Transient
	private List<Restriccion> restricciones;
	private EnumEstado estado;
	private Date ultimoUso;

	public Menu() {
		platos = new ArrayList<Plato>();
		restricciones = new ArrayList<Restriccion>();
	}

	public Menu(List<Plato> platos, Tag tag, int calorias) {
		restricciones = new ArrayList<Restriccion>();
		this.platos = platos;
		this.tag = tag;
		this.calorias = calorias;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Date getUltimoUso() {
		return ultimoUso;
	}

	public void setUltimoUso(Date ultimoUso) {
		this.ultimoUso = ultimoUso;
	}

	public void setRestricciones(List<Restriccion> restricciones) {
		this.restricciones = restricciones;
	}

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

	public boolean cumpleRestricciones(List<Restriccion> restriccionesCliente) {

		if (restriccionesCliente != null) {
			if (restriccionesCliente.size() == 0) {
				return true;
			} else {
				for (Restriccion restriccionCliente : restriccionesCliente) {
					for (Restriccion restriccionMenu : this.getRestricciones()) {
						if (restriccionMenu.getIdRestriccion() == restriccionCliente
								.getIdRestriccion()) {
							return false;
						}
					}
				}
			}
		}

		return true;

	}

	private List<Restriccion> getRestricciones() {
		if (this.restricciones == null || this.restricciones.size() == 0) {
			restricciones = new ArrayList<Restriccion>();
			for (Plato plato : platos) {
				for (Restriccion r : plato.getRestricciones()) {
					if (!restricciones.contains(r))
						restricciones.add(r);
				}
			}
		}

		return restricciones;
	}
	
	public Set<Estacion> getEstaciones(){
		Set<Estacion> estaciones = new HashSet<Estacion>();
		for(Plato p: platos){
			estaciones.addAll(p.getEstaciones());
		}
		return estaciones;
	}

}
