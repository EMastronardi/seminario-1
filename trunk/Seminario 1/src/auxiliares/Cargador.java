package auxiliares;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.EnumEstado;
import modelo.Restriccion;
import persistencia.ClientesDAO;
import persistencia.RestriccionesDAO;

public class Cargador {

	public static void cargarDatos() {
		// TODO Auto-generated method stub
		Restriccion r1 = new Restriccion("Sal", "No se permite el uso de Sal",
				10);
		Restriccion r2 = new Restriccion("Azúcar",
				"No se permite el uso de Azúcar", 10);
		Restriccion r3 = new Restriccion("Picante",
				"No se permite el uso de Picantes", 5);

		RestriccionesDAO.agregarRestriccion(r1);
		RestriccionesDAO.agregarRestriccion(r2);
		RestriccionesDAO.agregarRestriccion(r3);

		List<Restriccion> restricciones = new ArrayList<Restriccion>();
		restricciones.add(r1);

		ClientesDAO.crearCliente(new Cliente("Checho", "Molinero", "Calle 1",
				"111111", "13", "Quilmes", "1878", null, EnumEstado.ESTADO1,
				null, restricciones, "Centro"));
		
		restricciones.add(r2);
		
		ClientesDAO.crearCliente(new Cliente("Chalo", "Camino", "Calle 2",
				"22222", "13:30", "Quilmes", "1878", null, EnumEstado.ESTADO1,
				null, restricciones, "Oeste"));
	}

}
