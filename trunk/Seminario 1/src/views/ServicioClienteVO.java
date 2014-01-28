package views;

import modelo.EnumDia;
import modelo.ServicioCliente;

public class ServicioClienteVO {
	private int idServiciocliente;
	private ServicioVO servicio;
	private EnumDia dia;
	private boolean entrega;

	public ServicioClienteVO() {
	}

	public ServicioClienteVO(int idServiciocliente, ServicioVO servicio,
			EnumDia dia, boolean entrega) {
		this.idServiciocliente = idServiciocliente;
		this.servicio = servicio;
		this.dia = dia;
		this.entrega = entrega;
	}
	
	public ServicioClienteVO(ServicioCliente sc){
		this.idServiciocliente = sc.getIdServiciocliente();
		this.servicio = new ServicioVO(sc.getServicio());
		this.dia = sc.getDia();
		this.entrega = sc.isEntrega();
	}

	public int getIdServiciocliente() {
		return idServiciocliente;
	}

	public void setIdServiciocliente(int idServiciocliente) {
		this.idServiciocliente = idServiciocliente;
	}

	public ServicioVO getServicio() {
		return servicio;
	}

	public void setServicio(ServicioVO servicio) {
		this.servicio = servicio;
	}

	public EnumDia getDia() {
		return dia;
	}

	public void setDia(EnumDia dia) {
		this.dia = dia;
	}

	public boolean isEntrega() {
		return entrega;
	}

	public void setEntrega(boolean entrega) {
		this.entrega = entrega;
	}
}
