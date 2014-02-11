package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import views.ItemIngredienteVO;
import views.PlatoVO;
import views.RestriccionVO;

@Entity
public class Plato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlato;
	private String nombre;
	@Column(length = 1234)
	private String receta;
	@OneToOne
	private TipoPlato tipoPlato;
	@OneToOne
	private Tag tag;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPlato")
	private List<ItemIngrediente> ingredientes;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPlato")
	private List<Restriccion> restricciones;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPlato")
	private List<Tag> tagsSecundarios;

	public Plato() {
		super();
		this.ingredientes = new ArrayList<ItemIngrediente>();
		this.restricciones = new ArrayList<Restriccion>();
		this.tagsSecundarios = new ArrayList<Tag>();
	}

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

	public TipoPlato getTipoPlato() {
		return tipoPlato;
	}

	public void setTipoPlato(TipoPlato tipoPlato) {
		this.tipoPlato = tipoPlato;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public List<ItemIngrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<ItemIngrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public List<Restriccion> getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(List<Restriccion> restricciones) {
		this.restricciones = restricciones;
	}

	public List<Tag> getTagsSecundarios() {
		return tagsSecundarios;
	}

	public void setTagsSecundarios(List<Tag> tagsSecundarios) {
		this.tagsSecundarios = tagsSecundarios;
	}

	public void descontar() {
		// TODO
	}

	public PlatoVO getVO() {
		
		List<ItemIngredienteVO> ingredientes = new ArrayList<ItemIngredienteVO>();
		List<RestriccionVO> restricciones = new ArrayList<RestriccionVO>();
		for (Restriccion restriccion : this.restricciones) {
			restricciones.add(new RestriccionVO(restriccion));
		}
		for (ItemIngrediente itemIngrediente : this.ingredientes) {
			ingredientes.add(itemIngrediente.getVO());
		}
		PlatoVO plato = new PlatoVO(idPlato,nombre,receta,tipoPlato.toString(),tag.getDescripcion(),ingredientes,restricciones);
		return plato;
	}

}
