package views;

import java.util.List;

import modelo.ItemIngrediente;
import modelo.Restriccion;
import modelo.Tag;
import modelo.TipoPlato;

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

}
