package views;

import modelo.ItemOrdenDeCompra;

public class ItemOrdenDeCompraVO {
	private int id;
	private String ingrediente;
	private float cantidad;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public ItemOrdenDeCompraVO(int id, String ingrediente, float cantidad) {
		this.id = id;
		this.ingrediente = ingrediente;
		this.cantidad = cantidad;
	}
	public ItemOrdenDeCompraVO(ItemOrdenDeCompra ioc){
		this.id = ioc.getId();
		this.ingrediente = ioc.getIngrediente().getNombre();
		this.cantidad = ioc.getCantidad();
	}
	
}
