package utilidades;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.EnumEstado;
import modelo.EnumMedida;
import modelo.Estacion;
import modelo.Ingrediente;
import modelo.Plato;
import modelo.Restriccion;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistencia.ClientesDAO;

public class InitializeSystems {

	private static Session s;
	private static Transaction transac;

	/**
	 * @return 
	 * 
	 */
	public static void cargador() {
		/*
		 * GENERACION DE DATOS BASE PARA LA COCICNA DE SILVIA
		 * SE GENERAN : 
		 * - Restricciones - Ingredientes - Clientes - Platos
		 */
		s = GlobalsVars.HIBERATE_SESSION;

		transac = s.beginTransaction();
		try {
			// Obtenemos Estaciones
			ArrayList<Estacion> estaciones = (ArrayList<Estacion>) s
					.createQuery("from Estacion").list();
			ArrayList<Restriccion> restricciones;

			// Creacion de restricciones
			Restriccion restriccion1 = new Restriccion();
			restriccion1.setDescripcion("Descrip Restriccion 1");
			restriccion1.setNombre("Restriccion 1");
			restriccion1.setSeveridad(5);
			s.save(restriccion1);
			s.flush();
			Restriccion restriccion2 = new Restriccion();
			restriccion2.setDescripcion("Descrip Restriccion 2");
			restriccion2.setNombre("Restriccion 2");
			restriccion2.setSeveridad(8);
			s.save(restriccion2);
			s.flush();
			Restriccion restriccion3 = new Restriccion();
			restriccion3.setDescripcion("Descrip Restriccion 3");
			restriccion3.setNombre("Restriccion 3");
			restriccion3.setSeveridad(3);
			s.save(restriccion3);
			s.flush();
			Restriccion restriccion4 = new Restriccion();
			restriccion4.setDescripcion("Descrip Restriccion 4");
			restriccion4.setNombre("Restriccion 4");
			restriccion4.setSeveridad(5);
			s.save(restriccion4);
			s.flush();
			/*
			 * Creacion de Ingredientes
			 */
			Ingrediente papa = new Ingrediente();
			papa.setCantidadStock(25);
			papa.setDiasCaducidad(10);
			papa.setEstaciones(estaciones);
			papa.setFreezer(false);
			papa.setMedida(EnumMedida.Kilo);
			papa.setNombre("Papa");
			// Agregamos restricciones.

			s.save(papa);
			s.flush();
			// restricciones.clear();

			// TOMATE
			Ingrediente tomate = new Ingrediente();
			tomate.setCantidadStock(25);
			tomate.setDiasCaducidad(10);
			tomate.setEstaciones(estaciones);
			tomate.setFreezer(false);
			tomate.setMedida(EnumMedida.Kilo);
			tomate.setNombre("Papa");
			s.save(tomate);
			s.flush();

			// POLLO
			Ingrediente pollo = new Ingrediente();
			pollo.setCantidadStock(56);
			pollo.setDiasCaducidad(4);
			pollo.setEstaciones(estaciones);
			pollo.setFreezer(true);
			pollo.setMedida(EnumMedida.Kilo);
			pollo.setNombre("Pollo");
			s.save(pollo);
			s.flush();

			// CEBOLLA
			Ingrediente cebolla = new Ingrediente();
			cebolla.setCantidadStock(10);
			cebolla.setDiasCaducidad(15);
			cebolla.setEstaciones(estaciones);
			cebolla.setFreezer(false);
			cebolla.setMedida(EnumMedida.Kilo);
			cebolla.setNombre("Cebolla");
			s.save(cebolla);
			s.flush();

			// Arroz
			Ingrediente arroz = new Ingrediente();
			arroz.setCantidadStock(250);
			arroz.setDiasCaducidad(360);
			arroz.setEstaciones(estaciones);
			arroz.setFreezer(false);
			arroz.setMedida(EnumMedida.Kilo);
			arroz.setNombre("Arroz");
			s.save(arroz);
			s.flush();

			// LOMO
			Ingrediente lomo = new Ingrediente();
			lomo.setCantidadStock(250);
			lomo.setDiasCaducidad(360);
			lomo.setEstaciones(estaciones);
			lomo.setFreezer(true);
			lomo.setMedida(EnumMedida.Kilo);
			lomo.setNombre("Lomo");
			s.save(lomo);
			s.flush();

			// BROCOLI
			Ingrediente brocoli = new Ingrediente();
			brocoli.setCantidadStock(5);
			brocoli.setDiasCaducidad(10);
			brocoli.setEstaciones(estaciones);
			brocoli.setFreezer(true);
			brocoli.setMedida(EnumMedida.Kilo);
			brocoli.setNombre("Brocoli");
			// Agregamos restricciones.

			s.save(brocoli);
			s.flush();

			// ACEITE DE OLIVA
			Ingrediente oliva = new Ingrediente();
			oliva.setCantidadStock(25);
			oliva.setDiasCaducidad(90);
			oliva.setEstaciones(estaciones);
			oliva.setFreezer(false);
			oliva.setMedida(EnumMedida.Litro);
			oliva.setNombre("Aceite de Oliva");
			s.save(oliva);
			s.flush();

			// ACEITE DE girasol
			Ingrediente girasol = new Ingrediente();
			girasol.setCantidadStock(25);
			girasol.setDiasCaducidad(90);
			girasol.setEstaciones(estaciones);
			girasol.setFreezer(false);
			girasol.setMedida(EnumMedida.Litro);
			girasol.setNombre("Aceite de Girasol");
			s.save(girasol);
			s.flush();

			// LIMON
			Ingrediente limon = new Ingrediente();
			limon.setCantidadStock(25);
			limon.setDiasCaducidad(4);
			limon.setEstaciones(estaciones);
			limon.setFreezer(false);
			limon.setMedida(EnumMedida.Kilo);
			limon.setNombre("Limon");

			s.save(limon);
			s.flush();

			// SAL
			Ingrediente sal = new Ingrediente();
			sal.setCantidadStock(25);
			sal.setDiasCaducidad(365);
			sal.setEstaciones(estaciones);
			sal.setFreezer(false);
			sal.setMedida(EnumMedida.Kilo);
			sal.setNombre("Sal");
			s.save(sal);
			s.flush();

			// Champi
			Ingrediente champi = new Ingrediente();
			champi.setCantidadStock(500);
			champi.setDiasCaducidad(15);
			champi.setEstaciones(estaciones);
			champi.setFreezer(false);
			champi.setMedida(EnumMedida.Gramo);
			champi.setNombre("Champiñon");
			s.save(champi);
			s.flush();

			// Ajo
			Ingrediente ajo = new Ingrediente();
			ajo.setCantidadStock(5);
			ajo.setDiasCaducidad(15);
			ajo.setEstaciones(estaciones);
			ajo.setFreezer(false);
			ajo.setMedida(EnumMedida.Unidad);
			ajo.setNombre("Ajo");
			s.save(ajo);
			s.flush();

			// Pure de tomate
			Ingrediente pureTomate = new Ingrediente();
			pureTomate.setCantidadStock(15);
			pureTomate.setDiasCaducidad(60);
			pureTomate.setEstaciones(estaciones);
			pureTomate.setFreezer(false);
			pureTomate.setMedida(EnumMedida.Litro);
			pureTomate.setNombre("Pure de Tomate");
			s.save(pureTomate);
			s.flush();

			// Crema de Leche
			Ingrediente crema = new Ingrediente();
			crema.setCantidadStock(15);
			crema.setDiasCaducidad(5);
			crema.setEstaciones(estaciones);
			crema.setFreezer(false);
			crema.setMedida(EnumMedida.Litro);
			crema.setNombre("Crema de Leche");
			s.save(crema);
			s.flush();

			// Perejil
			Ingrediente perejil = new Ingrediente();
			perejil.setCantidadStock(300);
			perejil.setDiasCaducidad(5);
			perejil.setEstaciones(estaciones);
			perejil.setFreezer(false);
			perejil.setMedida(EnumMedida.Gramo);
			perejil.setNombre("Perejil");
			s.save(perejil);
			s.flush();

			// Creacion de Clientes
			//

			List<Restriccion> listaRestricciones = new ArrayList<Restriccion>();
			listaRestricciones.add(restriccion1);

			ClientesDAO.crearCliente(new Cliente("Checho", "Molinero",
					"Calle 1", "111111", "13", "Quilmes", "1878", null,
					EnumEstado.ESTADO1, null, listaRestricciones, "Centro"));

			listaRestricciones.add(restriccion2);

			ClientesDAO.crearCliente(new Cliente("Chalo", "Camino", "Calle 2",
					"22222", "13:30", "Quilmes", "1878", null,
					EnumEstado.ESTADO1, null, listaRestricciones, "Oeste"));

			// Creacion de Platos
			// Lomo Strogonoff Liviano
			Plato plato = new Plato();
			ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
			ingredientes.add(crema);
			ingredientes.add(lomo);
			ingredientes.add(perejil);
			ingredientes.add(champi);
			ingredientes.add(pureTomate);
			ingredientes.add(cebolla);
			ingredientes.add(crema);
			ingredientes.add(ajo);
			plato.setIngredientes(ingredientes);
			plato.setNombre("Lomo Strogonoff Liviano");
			plato.setReceta("1.	Retirar cualquier rastro de grasa visible que pudiera tener el lomo; cortarlo en cubos de 2cm de lado.<br> 2.	Cortar los champiñones en laminas. Reservar todo.<br>3.	Picar la cebolla y el ajo. Cocinarlos en una olla, con 1 cucharada de caldo, hasta que la cebolla este transparente.<br>4.	Añadir los cubos de lomo y cocinar hasta que cambien de color en toda su superficie.<br>5.	Agregar los champiñones, el resto del caldo, el pure de tomate y la mostaza. Continuar la coccion aproximadamente 20 minutos mas, hasta que la carne este tierna.<br>6.	Incorporar la crema de leche y cocinar 10 minutos mas.<br/>7.Espolvorear con peejil picado y servir caliente, con el arroz blanco como guarnicion.");
			s.save(plato);
			transac.commit();
		} catch (RuntimeException e) {
			transac.rollback();
			System.out.println("No se pudo dar de alto los resgistros");
		}

	}

}
