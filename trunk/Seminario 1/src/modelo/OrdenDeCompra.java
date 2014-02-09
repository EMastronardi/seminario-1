package modelo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import views.OrdenDeCompraVO;

@Entity
public class OrdenDeCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrdenDeCompra;
	private Date fechaCreacion;
	private Date fechaInicioPlan;
	private EnumEstado estado;
	@OneToMany
	@JoinColumn(name = "idOrdenDeCompra")
	private Map<Ingrediente, Float> items;

	public OrdenDeCompra() {
		items = new HashMap<Ingrediente, Float>();
	}

	public OrdenDeCompra(Date fechaCreacion, Date fechaInicioPlan,
			EnumEstado estado, Map<Ingrediente, Float> items) {
		this.fechaCreacion = fechaCreacion;
		this.fechaInicioPlan = fechaInicioPlan;
		this.estado = estado;
		this.items = items;
	}

	public int getIdOrdenDeCompra() {
		return idOrdenDeCompra;
	}

	public void setIdOrdenDeCompra(int idOrdenDeCompra) {
		this.idOrdenDeCompra = idOrdenDeCompra;
	}

	public Date getFecha() {
		return fechaCreacion;
	}

	public void setFecha(Date fecha) {
		this.fechaCreacion = fecha;
	}

	public EnumEstado getEstado() {
		return estado;
	}

	public void setEstado(EnumEstado estado) {
		this.estado = estado;
	}

	public Map<Ingrediente, Float> getItems() {
		return items;
	}

	public void setItems(Map<Ingrediente, Float> items) {
		this.items = items;
	}

	public OrdenDeCompraVO toVO() {
		// TODO Implementar la conversión a VO de la OrdenDeCompra
		return null;
	}

}
