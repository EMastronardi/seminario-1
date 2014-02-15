package views;

import java.util.ArrayList;
import java.util.List;

import modelo.EnumTipoPlato;
import modelo.Menu;
import modelo.Plato;

public class MenuVO {
	// TODO

	private int idMenu;
	private List<PlatoVO> platos;
	private int calorias;
	private String estado;
	private String tag;

	public PlatoVO getEnsalada(){
		for (PlatoVO plato : platos) {
			if(plato.getTipoPlato().equals(EnumTipoPlato.Ensalada)) 
				return plato;
		}
		return null;
	}
	public PlatoVO getPrincipal(){
		for (PlatoVO plato : platos) {
			if(plato.getTipoPlato().equals(EnumTipoPlato.Principal)) 
				return plato;
		}
		return null;
	}
	public PlatoVO getPostre(){
		for (PlatoVO plato : platos) {
			if(plato.getTipoPlato().equals(EnumTipoPlato.Postre)) 
				return plato;
		}
		return null;
	}
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
	public String getTag(){
		return tag;
	}
	public void setTag(String tag){
		this.tag = tag;
	}
	public MenuVO(int idMenu, List<PlatoVO> platos, int calorias, String estado) {
		super();
		this.idMenu = idMenu;
		this.platos = platos;
		this.calorias = calorias;
		this.estado = estado;
	}

	public MenuVO(Menu menu) {
		List<PlatoVO> platosVO = new ArrayList<PlatoVO>();
		
		this.calorias = menu.getCalorias();
		this.estado = menu.getEstado().toString();
		this.idMenu = menu.getIdMenu();
		for (Plato plato : menu.getPlatos()) {
			platosVO.add(new PlatoVO(plato));
		}
		this.platos = platosVO;
		this.tag = menu.getTag().toString();
	}

}
