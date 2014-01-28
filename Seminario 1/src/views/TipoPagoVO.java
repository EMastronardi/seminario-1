package views;

import modelo.TipoPago;

public class TipoPagoVO {
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
	public TipoPagoVO() {
	}
	public TipoPagoVO(int idTipoPago, String nombre, int cantodadDias) {
		this.idTipoPago = idTipoPago;
		this.nombre = nombre;
		this.cantodadDias = cantodadDias;
	}
	public TipoPagoVO(TipoPago tp){
		this.idTipoPago = tp.getIdTipoPago();
		this.nombre = tp.getNombre();
		this.cantodadDias = tp.getCantodadDias();
		
	}
}
