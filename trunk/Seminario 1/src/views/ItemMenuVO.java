package views;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.ItemMenu;

public class ItemMenuVO {
	private int idItemMenu;
	private String nombre;
	private int cantidad;
	private List<String> clientes;
	private MenuVO menu;
	
	public MenuVO getMenu() {
		return menu;
	}

	public void setMenu(MenuVO menu) {
		this.menu = menu;
	}

	public ItemMenuVO(int idItemMenu, String nombre, int cantidad,
			List<String> clientes, MenuVO menu) {
		super();
		this.idItemMenu = idItemMenu;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.clientes = clientes;
		this.menu = menu;
	}

	public ItemMenuVO(ItemMenu itemMenu) {
		List<String> clientes = new ArrayList<String>();
		this.cantidad = itemMenu.getCantidad();
		for (Cliente cliente : itemMenu.getClientes()) {
			clientes.add(cliente.getNombre() + " " + cliente.getApellido());
		}
		this.clientes = clientes; 
		this.idItemMenu = itemMenu.getIdItemMenu();
		this.menu = new MenuVO(itemMenu.getMenu());
		this.nombre = itemMenu.getNombre();
	}

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
