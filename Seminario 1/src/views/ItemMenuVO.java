package views;

import java.util.List;

public class ItemMenuVO {
	private int idItemMenu;
	private String nombre;
	private int cantidad;
	private List<String> clientes;

	public int getIdItemMenu() {
		return idItemMenu;
	}

	public void setIdItemMenu(int idItemMenu) {
		this.idItemMenu = idItemMenu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public List<String> getClientes() {
		return clientes;
	}

	public void setClientes(List<String> clientes) {
		this.clientes = clientes;
	}

}
