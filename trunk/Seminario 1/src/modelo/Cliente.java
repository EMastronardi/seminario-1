package modelo;

import java.util.ArrayList;

public class Cliente {
	private int idCliente;
	private String nombre;
	private String apellido;
	private String calle;
	private String telefono;
	private String horaEntrega;//WTF
	private String localidad;
	private String CP;
	private TipoPago tipoPago;
	private EnumEstado estado;
	private ArrayList<ServicioContratado> serviciosContratados;
	private ArrayList<Restriccion> restricciones;
	private String zona;
	

}
