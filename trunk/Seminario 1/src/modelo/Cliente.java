package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	private String nombre;
	private String apellido;
	private String calle;
	private String telefono;
	private String horaEntrega;// WTF
	private String localidad;
	private String CP;
	@OneToOne
	private TipoPago tipoPago;
	private EnumEstado estado;
	@OneToMany
	@JoinColumn(name = "idCliente")
	private List<ServicioCliente> serviciosCliente;
	@ManyToMany
	@JoinColumn(name = "idCliente")
	private List<Restriccion> restricciones;
	private String zona;

	public Cliente() {
		serviciosCliente = new ArrayList<ServicioCliente>();
		restricciones = new ArrayList<Restriccion>();
	}

	public Cliente(String nombre, String apellido, String calle,
			String telefono, String horaEntrega, String localidad, String cP,
			TipoPago tipoPago, EnumEstado estado,
			List<ServicioCliente> serviciosCliente,
			List<Restriccion> restricciones, String zona) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.calle = calle;
		this.telefono = telefono;
		this.horaEntrega = horaEntrega;
		this.localidad = localidad;
		CP = cP;
		this.tipoPago = tipoPago;
		this.estado = estado;
		this.serviciosCliente = serviciosCliente;
		this.restricciones = restricciones;
		this.zona = zona;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getHoraEntrega() {
		return horaEntrega;
	}

	public void setHoraEntrega(String horaEntrega) {
		this.horaEntrega = horaEntrega;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String cP) {
		CP = cP;
	}

	public TipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	public EnumEstado getEstado() {

		return estado;
	}

	public void setEstado(EnumEstado estado) {
		this.estado = estado;
	}

	public List<ServicioCliente> getServiciosCliente() {
		return serviciosCliente;
	}

	public void setServiciosContratados(
			List<ServicioCliente> serviciosCliente) {
		this.serviciosCliente = serviciosCliente;
	}

	public List<Restriccion> getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(List<Restriccion> restricciones) {
		this.restricciones = restricciones;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	@Override
	public boolean equals(Object obj) {
		if (Cliente.class.isInstance(obj)){
			if (((Cliente)obj).getIdCliente() == this.idCliente){
				return true;
			}
		}
		return false;
	}

	
	
}
