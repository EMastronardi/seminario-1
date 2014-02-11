package views;

import java.util.List;

public class MenuVO {
	// TODO

	private int idMenu;
	private List<PlatoVO> platos;
	private int calorias;
	private String estado;

	// private Date ultimoUso;
	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public List<PlatoVO> getPlatos() {
		return platos;
	}

	public void setPlatos(List<PlatoVO> platos) {
		this.platos = platos;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public MenuVO(int idMenu, List<PlatoVO> platos, int calorias, String estado) {
		super();
		this.idMenu = idMenu;
		this.platos = platos;
		this.calorias = calorias;
		this.estado = estado;
	}

}
