package views;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.EnumEstado;
import modelo.Restriccion;
import modelo.ServicioCliente;

public class ClienteVO {
	private int idCliente;
	private String nombre;
	private String apellido;
	private String calle;
	private String telefono;
	private String horaEntrega;// WTF
	private String localidad;
	private String CP;
	private String tipoPago;
	private EnumEstado estado;
	private List<ServicioClienteVO> serviciosCliente;
	private List<RestriccionVO> restricciones;
	private String zona;

	public ClienteVO() {
		serviciosCliente = new ArrayList<ServicioClienteVO>();
		restricciones = new ArrayList<RestriccionVO>();
	}

	public ClienteVO(int idCliente, String nombre, String apellido,
			String calle, String telefono, String horaEntrega,
			String localidad, String cP, String tipoPago, EnumEstado estado,
			ArrayList<ServicioClienteVO> serviciosCliente,
			ArrayList<RestriccionVO> restricciones, String zona) {
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
		this.serviciosCliente = serviciosCliente;
		this.restricciones = restricciones;
		this.zona = zona;
	}

	public ClienteVO(Cliente c) {
		this.idCliente = c.getIdCliente();
		this.nombre = c.getNombre();
		this.apellido = c.getApellido();
		this.calle = c.getCalle();
		this.telefono = c.getTelefono();
		this.horaEntrega = c.getHoraEntrega();
		this.localidad = c.getLocalidad();
		this.CP = c.getCP();
		this.tipoPago = (String) (c == null || (c.getTipoPago() == null) ? "N/A"
				: c.getTipoPago().toString());
		this.estado = c.getEstado();
		this.serviciosCliente = new ArrayList<ServicioClienteVO>();
		if (c.getServiciosCliente() != null) {
			for (ServicioCliente serv : c.getServiciosCliente()) {
				ServicioClienteVO sVO = new ServicioClienteVO(serv);
				this.serviciosCliente.add(sVO);
			}
		}
		this.restricciones = new ArrayList<RestriccionVO>();
		if (c.getRestricciones() != null) {
			for (Restriccion r : c.getRestricciones()) {
				RestriccionVO rVO = new RestriccionVO(r);
				this.restricciones.add(rVO);
			}
		}

		this.zona = c.getZona();

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

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public EnumEstado getEstado() {

		return estado;
	}

	public void setEstado(EnumEstado estado) {
		this.estado = estado;
	}

	public List<ServicioClienteVO> getServiciosContratados() {
		return serviciosCliente;
	}

	public void setServiciosContratados(
			List<ServicioClienteVO> serviciosContratados) {
		this.serviciosCliente = serviciosContratados;
	}

	public List<RestriccionVO> getRestricciones() {
		return restricciones;
	}

	public void setRestricciones(List<RestriccionVO> restricciones) {
		this.restricciones = restricciones;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
}
