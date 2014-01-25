package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ServicioCliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idServiciocliente;
	@ManyToOne
	@JoinColumn(name = "idServicio")
	//TODO va la columna?
	private Servicio servicio;
	private EnumDia dia;
	private boolean entrega;

	public ServicioCliente() {
	}

	public ServicioCliente(int idServiciocliente, Servicio servicio,
			EnumDia dia, boolean entrega) {
		this.idServiciocliente = idServiciocliente;
		this.servicio = servicio;
		this.dia = dia;
		this.entrega = entrega;
	}

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

}
