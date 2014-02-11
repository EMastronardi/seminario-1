package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import views.ItemMenuVO;

@Entity
public class ItemMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idItemMenu;
	private String nombre;
	private int cantidad;
	@ManyToOne
	@JoinColumn(name = "idMenu")
	private Menu menu;
	@ManyToMany
	@JoinColumn(name = "idItemMenu")
	private List<Cliente> clientes;

	public ItemMenu() {
		super();
		clientes = new ArrayList<Cliente>();
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

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void agregarItems(List<ItemIngrediente> ingredientes) {

	}

	public void descontar() {
		// TODO
	}

	public List<ItemIngrediente> obtenerIngredientesNecesarios() {
		List<ItemIngrediente> ingredientesNecesarios = new ArrayList<ItemIngrediente>();

		for (Plato plato : menu.getPlatos()) {
			for (ItemIngrediente item : plato.getIngredientes()) {
				for (int i = 0; i <= cantidad; i++) {
					ingredientesNecesarios.add(item);
				}
			}

		}

		return ingredientesNecesarios;
	}

	public ItemMenuVO getVO() {
		//TODO por ahora no se construye el ItemMenu con los clientes a los que se debe servir
		ItemMenuVO item = new ItemMenuVO(idItemMenu, nombre, cantidad, null, menu.getVO());
	
		return item;
	}

}
