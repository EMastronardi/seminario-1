package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import views.IngredienteVO;
import views.ItemIngredienteVO;

@Entity
public class ItemIngrediente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idItemIngrediente;
	@ManyToOne
	@JoinColumn(name="idIngrediente")
	private Ingrediente ingrediente;
	private float cantidad;
	
	public ItemIngrediente() {
		super();
	}

	public ItemIngrediente(Ingrediente ingrediente, float cantidad) {
		this.ingrediente = ingrediente;
		this.cantidad = cantidad;
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
	
	public void descontarStock(){
		// TODO
	}

	public ItemIngredienteVO getVO() {
		ItemIngredienteVO item = new ItemIngredienteVO(idItemIngrediente,new IngredienteVO(ingrediente),cantidad);
		
		return item;
	}
}
