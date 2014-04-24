package modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import persistencia.EstacionDAO;

@Entity
public class Estacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstacion;
	private String estacion;

	public Estacion(){
		
	}
	
	public Estacion(String name) {
		// TODO Auto-generated constructor stub
		this.estacion = name;
	}
	
	public int getIdEstacion() {
		return idEstacion;
	}
	
	public void setIdEstacion(int idEstacion) {
		this.idEstacion = idEstacion;
	}

	public String getEstacion() {
		return estacion;
	}

	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(String.class.getInterfaces().equals(obj)){
			if(this.estacion.equals(obj)){
				return true;
			}
		}
		return false;
	}
	
}
