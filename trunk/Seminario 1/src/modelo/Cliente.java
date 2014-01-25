package modelo;

import java.util.ArrayList;

public class Cliente {
	private int idCliente;
	private String nombre;
	private String apellido;
	private String calle;
	private String telefono;
	private String horaEntrega;//WTF
	private String localidad;
	private String CP;
	private TipoPago tipoPago;
	private EnumEstado estado;
	private ArrayList<ServicioCliente> serviciosContratados;
	private ArrayList<Restriccion> restricciones;
	private String zona;
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
	public ArrayList<ServicioCliente> getServiciosContratados() {
		return serviciosContratados;
	}
	public void setServiciosContratados(
			ArrayList<ServicioCliente> serviciosContratados) {
		this.serviciosContratados = serviciosContratados;
	}
	public ArrayList<Restriccion> getRestricciones() {
		return restricciones;
	}
	public void setRestricciones(ArrayList<Restriccion> restricciones) {
		this.restricciones = restricciones;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public Cliente() {
	}
	public Cliente(int idCliente, String nombre, String apellido, String calle,
			String telefono, String horaEntrega, String localidad, String cP,
			TipoPago tipoPago, EnumEstado estado,
			ArrayList<ServicioCliente> serviciosContratados,
			ArrayList<Restriccion> restricciones, String zona) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.calle = calle;
		this.telefono = telefono;
		this.horaEntrega = horaEntrega;
		this.localidad = localidad;
		CP = cP;
		this.tipoPago = tipoPago;
		this.estado = estado;
		this.serviciosContratados = serviciosContratados;
		this.restricciones = restricciones;
		this.zona = zona;
	}
	
	
	

}
