package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class OrdenDeCompra {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOrdenDeCompra;
	private Date fecha;
	private EnumEstado estado;
	@OneToMany
	@JoinColumn(name = "idOrdenDeCompra")
	private List<ItemOrdenCompra> items;

	public OrdenDeCompra(){
		items = new ArrayList<ItemOrdenCompra>();
	}
	
	public int getIdOrdenDeCompra() {
		return idOrdenDeCompra;
	}

	public void setIdOrdenDeCompra(int idOrdenDeCompra) {
		this.idOrdenDeCompra = idOrdenDeCompra;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public EnumEstado getEstado() {
		return estado;
	}

	public void setEstado(EnumEstado estado) {
		this.estado = estado;
	}

	public List<ItemOrdenCompra> getItems() {
		return items;
	}

	public void setItems(List<ItemOrdenCompra> items) {
		this.items = items;
	}

}
