package modelo;

import java.util.ArrayList;
import java.util.List;

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
	private int cantidadStock;
	@Enumerated(EnumType.STRING)
	private EnumMedida medida;
	private int diasCaducidad;
	private boolean freezer;
	@ManyToMany
	@JoinColumn(name = "idIngrediente")
	private List<Estacion> estaciones;
	@ManyToMany
	@JoinColumn(name = "idIngrediente")
	private List<Restriccion> restricciones;
	
	public Ingrediente(){
		estaciones = new ArrayList<Estacion>();
		restricciones = new ArrayList<Restriccion>();
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
	public int getCantidadStock() {
		return cantidadStock;
	}
	public void setCantidadStock(int cantidadStock) {
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
	public List<Restriccion> getRestricciones() {
		return restricciones;
	}
	public void setRestricciones(ArrayList<Restriccion> restricciones) {
		this.restricciones = restricciones;
	}
	
	
	
}
