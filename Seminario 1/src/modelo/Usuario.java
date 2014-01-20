package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Usuarios")
public class Usuario {

	@Id
	private int id;
	private String nombre;
	private String password;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public Usuario(){}
	public void setPassword(String password) {
		this.password = password;
	}
	public Usuario(String nombre, String password) {
		this.nombre = nombre;
		this.password = password;
	}
	
}
