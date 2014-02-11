package views;

import modelo.Ingrediente;

public class ItemIngredienteVO {
	private int idItemIngrediente;
	private IngredienteVO ingrediente;
	private float cantidad;

	public int getIdItemIngrediente() {
		return idItemIngrediente;
	}

	public void setIdItemIngrediente(int idItemIngrediente) {
		this.idItemIngrediente = idItemIngrediente;
	}

	public IngredienteVO getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(IngredienteVO ingrediente) {
		this.ingrediente = ingrediente;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public ItemIngredienteVO(int idItemIngrediente, IngredienteVO ingredienteVO,
			float cantidad) {
		super();
		this.idItemIngrediente = idItemIngrediente;
		this.ingrediente = ingredienteVO;
		this.cantidad = cantidad;
	}

}
