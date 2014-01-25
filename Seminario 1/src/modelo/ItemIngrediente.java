package modelo;

public class ItemIngrediente {
	private Ingrediente ingrediente;
	private float cantidad;
	
	public ItemIngrediente() {
		super();
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
}
