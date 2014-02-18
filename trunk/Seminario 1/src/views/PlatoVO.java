package views;

import java.util.ArrayList;
import java.util.List;

import modelo.ItemIngrediente;
import modelo.Plato;
import modelo.Restriccion;
import modelo.Tag;

public class PlatoVO {
	private int idPlato;
	private String nombre;
	private String receta;
	private String tipoPlato;
	private String tag;
	private List<ItemIngredienteVO> ingredientes;
	private List<RestriccionVO> restricciones;

	public int getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public String getTipoPlato() {
		return tipoPlato;
	}

	public void setTipoPlato(String tipoPlato) {
		this.tipoPlato = tipoPlato;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	
	public List<ItemIngredienteVO> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<ItemIngredienteVO> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public List<RestriccionVO> getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(List<RestriccionVO> restricciones) {
		this.restricciones = restricciones;
	}

	public PlatoVO(int idPlato, String nombre, String receta, String tipoPlato,
			String tag, List<ItemIngredienteVO> ingredientes,
			List<RestriccionVO> restricciones) {
		super();
		this.idPlato = idPlato;
		this.nombre = nombre;
		this.receta = receta;
		this.tipoPlato = tipoPlato;
		this.tag = tag;
		this.ingredientes = ingredientes;
		this.restricciones = restricciones;
	}

	public PlatoVO(Plato plato) {

		List<ItemIngredienteVO> ingredientes = new ArrayList<ItemIngredienteVO>();
		List<RestriccionVO> restricciones = new ArrayList<RestriccionVO>();

		for (Restriccion restriccion : plato.getRestricciones()) {
			restricciones.add(new RestriccionVO(restriccion));
		}
		for (ItemIngrediente itemIngrediente : plato.getIngredientes()) {
			ingredientes.add(new ItemIngredienteVO(itemIngrediente));
		}

		this.setIdPlato(plato.getIdPlato());
		this.setNombre(plato.getNombre());
		this.setReceta(plato.getReceta());
		if (plato.getTipoPlato() != null)
			this.setTipoPlato(plato.getTipoPlato().toString());
		else
			this.setTipoPlato("Sin Tipo");
		if (plato.getTag() != null)
			this.setTag(plato.getTag().toString());
		else
			this.setTag("Sin Tag");
		this.setIngredientes(ingredientes);
		this.setRestricciones(restricciones);
	}

}
