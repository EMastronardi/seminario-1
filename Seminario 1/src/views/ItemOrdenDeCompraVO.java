package views;

import modelo.ItemOrdenDeCompra;

public class ItemOrdenDeCompraVO {
	private int id;
	private String ingrediente;
	private String medida;
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
	public ItemOrdenDeCompraVO(int id, String ingrediente, float cantidad, String medida) {
		this.id = id;
		this.ingrediente = ingrediente;
		this.cantidad = cantidad;
		this.medida = medida;
	}
	public ItemOrdenDeCompraVO(ItemOrdenDeCompra ioc){
		this.id = ioc.getId();
		this.ingrediente = ioc.getIngrediente().getNombre();
		this.medida = ioc.getIngrediente().getMedida().name();
		this.cantidad = ioc.getCantidad();
	}
	public String getMedida() {
		return medida;
	}
	public void setMedida(String medida) {
		this.medida = medida;
	}
	
}
