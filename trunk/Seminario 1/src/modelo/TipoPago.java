package modelo;

public class TipoPago {
	private int idTipoPago;
	private String nombre;
	private int cantodadDias;
	public int getIdTipoPago() {
		return idTipoPago;
	}
	public void setIdTipoPago(int idTipoPago) {
		this.idTipoPago = idTipoPago;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantodadDias() {
		return cantodadDias;
	}
	public void setCantodadDias(int cantodadDias) {
		this.cantodadDias = cantodadDias;
	}
	public TipoPago() {
	}
	public TipoPago(int idTipoPago, String nombre, int cantodadDias) {
		this.idTipoPago = idTipoPago;
		this.nombre = nombre;
		this.cantodadDias = cantodadDias;
	}
	
}
