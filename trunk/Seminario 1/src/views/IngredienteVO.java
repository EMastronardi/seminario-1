package views;

import java.util.ArrayList;
import java.util.List;

import modelo.Estacion;
import modelo.Ingrediente;

public class IngredienteVO {
	private int idIngrediente;
	private String nombre;
	private float cantidadStock;
	private String medida;
	private int diasCaducidad;
	private boolean freezer;
	private List<EstacionVO> estaciones;
	public IngredienteVO() {
	
	}
	public IngredienteVO(Ingrediente ingrediente) {
		super();
		this.idIngrediente = ingrediente.getIdIngrediente();
		this.nombre = ingrediente.getNombre();
		this.cantidadStock = ingrediente.getCantidadStock();
		this.medida = ingrediente.getMedida().toString();
		this.diasCaducidad = ingrediente.getDiasCaducidad();
		this.freezer = ingrediente.isFreezer();
		//MAPEAMOS LAS ESTACIONES PARA LAS ESTACIONES VIEW-OBJECT
		ArrayList<EstacionVO> estacionesVO = new ArrayList<EstacionVO>();
		for (Estacion element : ingrediente.getEstaciones()) {
			EstacionVO vo = new EstacionVO(element);
			estacionesVO.add(vo);
		}
		this.estaciones = estacionesVO;	
	}
	public int getIdIngrediente() {
		return idIngrediente;
	}
	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getCantidadStock() {
		return cantidadStock;
	}
	public void setCantidadStock(float cantidadStock) {
		this.cantidadStock = cantidadStock;
	}
	public String getMedida() {
		return medida;
	}
	public void setMedida(String medida) {
		this.medida = medida;
	}
	public int getDiasCaducidad() {
		return diasCaducidad;
	}
	public void setDiasCaducidad(int diasCaducidad) {
		this.diasCaducidad = diasCaducidad;
	}
	public boolean isFreezer() {
		return freezer;
	}
	public void setFreezer(boolean freezer) {
		this.freezer = freezer;
	}
	public List<EstacionVO> getEstaciones() {
		return estaciones;
	}
	public void setEstaciones(List<EstacionVO> estaciones) {
		this.estaciones = estaciones;
	}
	public double getCantStock(){
		return this.cantidadStock;
	}
}
