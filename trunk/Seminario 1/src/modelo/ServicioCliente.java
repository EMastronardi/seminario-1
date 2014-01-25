package modelo;

public class ServicioCliente {
	private int idServiciocliente;
	private Servicio servicio;
	private EnumDia dia;
	private boolean entrega;
	public int getIdServiciocliente() {
		return idServiciocliente;
	}
	public void setIdServiciocliente(int idServiciocliente) {
		this.idServiciocliente = idServiciocliente;
	}
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
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
	public ServicioCliente() {
	}
	public ServicioCliente(int idServiciocliente, Servicio servicio,
			EnumDia dia, boolean entrega) {
		this.idServiciocliente = idServiciocliente;
		this.servicio = servicio;
		this.dia = dia;
		this.entrega = entrega;
	}
	

}
