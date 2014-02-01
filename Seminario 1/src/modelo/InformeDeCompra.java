package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class InformeDeCompra {
	@Id
	private int idInformeDeCompra;
	@OneToMany
	@JoinColumn(name = "idInformeDeCompra")
	private List<ItemInformeDeCompra> items;
	private Date fecha;
	
	public InformeDeCompra(){
		items = new ArrayList<ItemInformeDeCompra>();
	}
	
	public int getIdInformeDeCompra() {
		return idInformeDeCompra;
	}
	public void setIdInformeDeCompra(int idInformeDeCompra) {
		this.idInformeDeCompra = idInformeDeCompra;
	}
	public List<ItemInformeDeCompra> getItems() {
		return items;
	}
	public void setItems(List<ItemInformeDeCompra> items) {
		this.items = items;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	

}
