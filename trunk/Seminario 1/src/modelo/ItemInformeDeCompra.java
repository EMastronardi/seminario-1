package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ItemInformeDeCompra {
	@Id
	private int idItemInformeDeCompra;
	@OneToOne
	private Ingrediente ingrediente;
	private float cantidad;

	public int getIdItemInformeDeCompra() {
		return idItemInformeDeCompra;
	}

	public void setIdItemInformeDeCompra(int idItemInformeDeCompra) {
		this.idItemInformeDeCompra = idItemInformeDeCompra;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

}
