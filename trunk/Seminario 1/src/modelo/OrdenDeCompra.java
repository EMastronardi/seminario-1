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
import javax.persistence.OneToMany;

@Entity
public class OrdenDeCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrdenDeCompra;
	private Date fechaCreacion;
	private Date fechaInicioPlan;
	private EnumEstado estado;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="idOrdenDeCompra")
	private List<ItemOrdenDeCompra> items;
	
	
	
	public OrdenDeCompra() {
		items = new ArrayList<ItemOrdenDeCompra>();
	}

	public OrdenDeCompra(Date fechaCreacion, Date fechaInicioPlan,
			EnumEstado estado, ArrayList<ItemOrdenDeCompra> items) {
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

	
	public List<ItemOrdenDeCompra> getItems() {
		return items;
	}

	public void setItems(List<ItemOrdenDeCompra> items) {
		this.items = items;
	}

	public void setItems(ArrayList<ItemOrdenDeCompra> items) {
		this.items = items;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaInicioPlan() {
		return fechaInicioPlan;
	}

	public void setFechaInicioPlan(Date fechaInicioPlan) {
		this.fechaInicioPlan = fechaInicioPlan;
	}
}
