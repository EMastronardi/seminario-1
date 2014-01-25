package modelo;

import java.util.ArrayList;

public class Ingrediente {
	private int idInggrediente;
	private String nombre;
	private int cantidadStock;
	private String medida;
	private int diasCaducidad;
	private boolean freezer;
	private ArrayList<Estacion> estaciones;
	private ArrayList<Restriccion> restricciones;
	
}
