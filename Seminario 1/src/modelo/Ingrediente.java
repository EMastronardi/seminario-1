package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Ingrediente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIngrediente;
	private String nombre;
	private float cantidadStock;
	@Enumerated(EnumType.STRING)
	private EnumMedida medida;
	private int diasCaducidad;
	private boolean freezer;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idIngrediente")
	private List<Estacion> estaciones;
	
	public Ingrediente(String nombre, int cantidadStock, EnumMedida medida,
			int diasCaducidad, boolean freezer, List<Estacion> estaciones) {
		this();
		this.nombre = nombre;
		this.cantidadStock = cantidadStock;
		this.medida = medida;
		this.diasCaducidad = diasCaducidad;
		this.freezer = freezer;
		this.estaciones = estaciones;
	}

	public Ingrediente(){
		estaciones = new ArrayList<Estacion>();
	}
	
	public int getIdIngrediente() {
		return idIngrediente;
	}
	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getCantidadStock() {
		return cantidadStock;
	}
	public void setCantidadStock(float cantidadStock) {
		this.cantidadStock = cantidadStock;
	}
	public EnumMedida getMedida() {
		return medida;
	}
	public void setMedida(EnumMedida medida) {
		this.medida = medida;
	}
	public int getDiasCaducidad() {
		return diasCaducidad;
	}
	public void setDiasCaducidad(int diasCaducidad) {
		this.diasCaducidad = diasCaducidad;
	}
	public boolean isFreezer() {
		return freezer;
	}
	public void setFreezer(boolean freezer) {
		this.freezer = freezer;
	}
	public List<Estacion> getEstaciones() {
		return estaciones;
	}
	public void setEstaciones(ArrayList<Estacion> estaciones) {
		this.estaciones = estaciones;
	}	
	public void addEstacion(Estacion estacion){
		this.estaciones.add(estacion);
	}

	@Override
	public boolean equals(Object obj) {
		
		if(Ingrediente.class.isInstance(obj)){
			if (((Ingrediente)obj).getIdIngrediente() == this.idIngrediente){
				return true;
			}
		}	
		return false;
	}
}
