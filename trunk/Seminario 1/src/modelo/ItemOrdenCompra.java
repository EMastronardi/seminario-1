package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ItemOrdenCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idItemOrdenCompra;
	private float cantidad;
	@OneToOne
	private Ingrediente igrediente;

	public int getIdItemOrdenCompra() {
		return idItemOrdenCompra;
	}

	public void setIdItemOrdenCompra(int idItemOrdenCompra) {
		this.idItemOrdenCompra = idItemOrdenCompra;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public Ingrediente getIgrediente() {
		return igrediente;
	}

	public void setIgrediente(Ingrediente igrediente) {
		this.igrediente = igrediente;
	}

}
