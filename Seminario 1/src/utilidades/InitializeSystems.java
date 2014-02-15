package utilidades;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.Cliente;
import modelo.EnumEstado;
import modelo.EnumMedida;
import modelo.EnumTipoPlato;
import modelo.Estacion;
import modelo.Ingrediente;
import modelo.ItemIngrediente;
import modelo.Menu;
import modelo.Plato;
import modelo.Restriccion;
import modelo.Tag;

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
		 * GENERACION DE DATOS BASE PARA LA COCICNA DE SILVIA SE GENERAN : -
		 * Restricciones - Ingredientes - Clientes - Platos
		 */
		s = GlobalsVars.HIBERATE_SESSION;

		// transac = s.beginTransaction();
		try {

			// Insertamos Estacones --------------------------------------

			Estacion otonio = new Estacion("Otoño");
			Estacion invierno = new Estacion("Invierno");
			Estacion primavera = new Estacion("Primavera");
			Estacion verano = new Estacion("Verano");
			s.save(otonio);
			s.save(invierno);
			s.save(primavera);
			s.save(verano);

			// ------------------------------------------------------------

			// Obtenemos Estaciones
			ArrayList<Estacion> estaciones = (ArrayList<Estacion>) s
					.createQuery("from Estacion").list();
			ArrayList<Restriccion> restricciones;

			Ingrediente ingrediente = new Ingrediente();

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
			// Ingrediente papa = new Ingrediente();
			// papa.setCantidadStock(25);
			// papa.setDiasCaducidad(10);
			// papa.setEstaciones(estaciones);
			// papa.setFreezer(false);
			// papa.setMedida(EnumMedida.Kilo);
			// papa.setNombre("Papa");
			// // Agregamos restricciones.
			//
			// s.save(papa);
			// s.flush();
			// // restricciones.clear();
			//
			// // TOMATE
			// Ingrediente tomate = new Ingrediente();
			// tomate.setCantidadStock(25);
			// tomate.setDiasCaducidad(10);
			// tomate.setEstaciones(estaciones);
			// tomate.setFreezer(false);
			// tomate.setMedida(EnumMedida.Kilo);
			// tomate.setNombre("Papa");
			// s.save(tomate);
			// s.flush();
			//
			// // POLLO
			// Ingrediente pollo = new Ingrediente();
			// pollo.setCantidadStock(56);
			// pollo.setDiasCaducidad(4);
			// pollo.setEstaciones(estaciones);
			// pollo.setFreezer(true);
			// pollo.setMedida(EnumMedida.Kilo);
			// pollo.setNombre("Pollo");
			// s.save(pollo);
			// s.flush();
			//
			// // CEBOLLA
			// Ingrediente cebolla = new Ingrediente();
			// cebolla.setCantidadStock(10);
			// cebolla.setDiasCaducidad(15);
			// cebolla.setEstaciones(estaciones);
			// cebolla.setFreezer(false);
			// cebolla.setMedida(EnumMedida.Kilo);
			// cebolla.setNombre("Cebolla");
			// s.save(cebolla);
			// s.flush();
			//
			// // Arroz
			// Ingrediente arroz = new Ingrediente();
			// arroz.setCantidadStock(250);
			// arroz.setDiasCaducidad(360);
			// arroz.setEstaciones(estaciones);
			// arroz.setFreezer(false);
			// arroz.setMedida(EnumMedida.Kilo);
			// arroz.setNombre("Arroz");
			// s.save(arroz);
			// s.flush();
			//
			// // LOMO
			// Ingrediente lomo = new Ingrediente();
			// lomo.setCantidadStock(250);
			// lomo.setDiasCaducidad(360);
			// lomo.setEstaciones(estaciones);
			// lomo.setFreezer(true);
			// lomo.setMedida(EnumMedida.Kilo);
			// lomo.setNombre("Lomo");
			// s.save(lomo);
			// s.flush();
			//
			// // BROCOLI
			// Ingrediente brocoli = new Ingrediente();
			// brocoli.setCantidadStock(5);
			// brocoli.setDiasCaducidad(10);
			// brocoli.setEstaciones(estaciones);
			// brocoli.setFreezer(true);
			// brocoli.setMedida(EnumMedida.Kilo);
			// brocoli.setNombre("Brocoli");
			// // Agregamos restricciones.
			//
			// s.save(brocoli);
			// s.flush();
			//
			// // ACEITE DE OLIVA
			// Ingrediente oliva = new Ingrediente();
			// oliva.setCantidadStock(25);
			// oliva.setDiasCaducidad(90);
			// oliva.setEstaciones(estaciones);
			// oliva.setFreezer(false);
			// oliva.setMedida(EnumMedida.Litro);
			// oliva.setNombre("Aceite de Oliva");
			// s.save(oliva);
			// s.flush();
			//
			// // ACEITE DE girasol
			// Ingrediente girasol = new Ingrediente();
			// girasol.setCantidadStock(25);
			// girasol.setDiasCaducidad(90);
			// girasol.setEstaciones(estaciones);
			// girasol.setFreezer(false);
			// girasol.setMedida(EnumMedida.Litro);
			// girasol.setNombre("Aceite de Girasol");
			// s.save(girasol);
			// s.flush();
			//
			// // LIMON
			// Ingrediente limon = new Ingrediente();
			// limon.setCantidadStock(25);
			// limon.setDiasCaducidad(4);
			// limon.setEstaciones(estaciones);
			// limon.setFreezer(false);
			// limon.setMedida(EnumMedida.Kilo);
			// limon.setNombre("Limon");
			//
			// s.save(limon);
			// s.flush();
			//
			// // SAL
			// Ingrediente sal = new Ingrediente();
			// sal.setCantidadStock(25);
			// sal.setDiasCaducidad(365);
			// sal.setEstaciones(estaciones);
			// sal.setFreezer(false);
			// sal.setMedida(EnumMedida.Kilo);
			// sal.setNombre("Sal");
			// s.save(sal);
			// s.flush();
			//
			// // Champi
			// Ingrediente champi = new Ingrediente();
			// champi.setCantidadStock(500);
			// champi.setDiasCaducidad(15);
			// champi.setEstaciones(estaciones);
			// champi.setFreezer(false);
			// champi.setMedida(EnumMedida.Gramo);
			// champi.setNombre("Champiï¿½on");
			// s.save(champi);
			// s.flush();
			//
			// // Ajo
			// Ingrediente ajo = new Ingrediente();
			// ajo.setCantidadStock(5);
			// ajo.setDiasCaducidad(15);
			// ajo.setEstaciones(estaciones);
			// ajo.setFreezer(false);
			// ajo.setMedida(EnumMedida.Unidad);
			// ajo.setNombre("Ajo");
			// s.save(ajo);
			// s.flush();
			//
			// // Pure de tomate
			// Ingrediente pureTomate = new Ingrediente();
			// pureTomate.setCantidadStock(15);
			// pureTomate.setDiasCaducidad(60);
			// pureTomate.setEstaciones(estaciones);
			// pureTomate.setFreezer(false);
			// pureTomate.setMedida(EnumMedida.Litro);
			// pureTomate.setNombre("Pure de Tomate");
			// s.save(pureTomate);
			// s.flush();
			//
			// // Crema de Leche
			// Ingrediente crema = new Ingrediente();
			// crema.setCantidadStock(15);
			// crema.setDiasCaducidad(5);
			// crema.setEstaciones(estaciones);
			// crema.setFreezer(false);
			// crema.setMedida(EnumMedida.Litro);
			// crema.setNombre("Crema de Leche");
			// s.save(crema);
			// s.flush();
			//
			// // Perejil
			// Ingrediente perejil = new Ingrediente();
			// perejil.setCantidadStock(300);
			// perejil.setDiasCaducidad(5);
			// perejil.setEstaciones(estaciones);
			// perejil.setFreezer(false);
			// perejil.setMedida(EnumMedida.Gramo);
			// perejil.setNombre("Perejil");
			// s.save(perejil);
			// s.flush();

			Ingrediente aceitedegirasol = new Ingrediente("Aceite de girasol",
					999999, EnumMedida.Litro, 365, true, estaciones);
			s.save(aceitedegirasol);
			s.flush();
			Ingrediente aceitedeoliva = new Ingrediente("Aceite de oliva",
					999999, EnumMedida.Litro, 90, true, estaciones);
			s.save(aceitedeoliva);
			s.flush();
			Ingrediente aceituna = new Ingrediente("Aceituna", 999999,
					EnumMedida.Unidad, 30, true, estaciones);
			s.save(aceituna);
			s.flush();
			Ingrediente ajiamarillo = new Ingrediente("Ají amarillo", 999999,
					EnumMedida.Unidad, 7, true, estaciones);
			s.save(ajiamarillo);
			s.flush();
			Ingrediente ajo = new Ingrediente("Ajo", 999999, EnumMedida.Kilo,
					7, true, estaciones);
			s.save(ajo);
			s.flush();
			Ingrediente alcaparras = new Ingrediente("Alcaparras", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(alcaparras);
			s.flush();
			Ingrediente almendra = new Ingrediente("Almendra", 999999,
					EnumMedida.Kilo, 90, true, estaciones);
			s.save(almendra);
			s.flush();
			Ingrediente almendras = new Ingrediente("Almendras", 999999,
					EnumMedida.Kilo, 15, true, estaciones);
			s.save(almendras);
			s.flush();
			Ingrediente arroz = new Ingrediente("Arroz", 999999,
					EnumMedida.Kilo, 365, true, estaciones);
			s.save(arroz);
			s.flush();
			Ingrediente arvejas = new Ingrediente("Arvejas", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(arvejas);
			s.flush();
			Ingrediente avena = new Ingrediente("Avena", 999999,
					EnumMedida.Kilo, 90, true, estaciones);
			s.save(avena);
			s.flush();
			Ingrediente azucar = new Ingrediente("Azúcar", 999999,
					EnumMedida.Kilo, 365, true, estaciones);
			s.save(azucar);
			s.flush();
			Ingrediente banana = new Ingrediente("Banana", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(banana);
			s.flush();
			Ingrediente berenjena = new Ingrediente("Berenjena", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(berenjena);
			s.flush();
			Ingrediente brocoli = new Ingrediente("Brócoli", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(brocoli);
			s.flush();
			Ingrediente carnedecordero = new Ingrediente("Carne de cordero",
					999999, EnumMedida.Kilo, 90, false, estaciones);
			s.save(carnedecordero);
			s.flush();
			Ingrediente carnederes = new Ingrediente("Carne de res", 999999,
					EnumMedida.Kilo, 90, false, estaciones);
			s.save(carnederes);
			s.flush();

			Ingrediente carnedeternera = new Ingrediente("Carne de ternera",
					999999, EnumMedida.Kilo, 90, false, estaciones);
			s.save(carnedeternera);
			s.flush();
			Ingrediente cebolla = new Ingrediente("Cebolla", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(cebolla);
			s.flush();
			Ingrediente cebollitadeverdeo = new Ingrediente(
					"Cebollita de verdeo", 999999, EnumMedida.Kilo, 7, true,
					estaciones);
			s.save(cebollitadeverdeo);
			s.flush();
			Ingrediente champinones = new Ingrediente("Champiñones", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(champinones);
			s.flush();
			Ingrediente choclo = new Ingrediente("Choclo", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(choclo);
			s.flush();
			Ingrediente coliflor = new Ingrediente("Coliflor", 999999,
					EnumMedida.Unidad, 7, true, estaciones);
			s.save(coliflor);
			s.flush();
			Ingrediente comino = new Ingrediente("Comino", 999999,
					EnumMedida.Kilo, 365, true, estaciones);
			s.save(comino);
			s.flush();
			Ingrediente conac = new Ingrediente("Coñac", 999999,
					EnumMedida.Litro, 365, true, estaciones);
			s.save(conac);
			s.flush();
			Ingrediente cremadeleche = new Ingrediente("Crema de Leche", 15,
					EnumMedida.Litro, 5, true, estaciones);
			s.save(cremadeleche);
			s.flush();
			Ingrediente cubodecaldoverdura = new Ingrediente(
					"Cubo de caldo verdura", 999999, EnumMedida.Unidad, 90,
					true, estaciones);
			s.save(cubodecaldoverdura);
			s.flush();
			Ingrediente durazno = new Ingrediente("Durazno", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(durazno);
			s.flush();
			Ingrediente esenciadevainilla = new Ingrediente(
					"Esencia de vainilla", 999999, EnumMedida.Litro, 365, true,
					estaciones);
			s.save(esenciadevainilla);
			s.flush();
			Ingrediente espinaca = new Ingrediente("Espinaca", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(espinaca);
			s.flush();
			Ingrediente filetedepescado = new Ingrediente("Filete de pescado",
					999999, EnumMedida.Kilo, 90, true, estaciones);
			s.save(filetedepescado);
			s.flush();
			Ingrediente harina = new Ingrediente("Harina", 999999,
					EnumMedida.Kilo, 365, true, estaciones);
			s.save(harina);
			s.flush();
			Ingrediente harinadegluten = new Ingrediente("Harina de gluten",
					999999, EnumMedida.Kilo, 365, true, estaciones);
			s.save(harinadegluten);
			s.flush();
			Ingrediente harinadesoja = new Ingrediente("Harina de soja",
					999999, EnumMedida.Kilo, 365, true, estaciones);
			s.save(harinadesoja);
			s.flush();
			Ingrediente hierbas = new Ingrediente("Hierbas", 999999,
					EnumMedida.Kilo, 90, true, estaciones);
			s.save(hierbas);
			s.flush();
			Ingrediente hongo = new Ingrediente("Hongo", 999999,
					EnumMedida.Kilo, 365, true, estaciones);
			s.save(hongo);
			s.flush();
			Ingrediente huevo = new Ingrediente("Huevo", 999999,
					EnumMedida.Unidad, 7, true, estaciones);
			s.save(huevo);
			s.flush();
			Ingrediente jamon = new Ingrediente("Jamón", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(jamon);
			s.flush();
			Ingrediente laurel = new Ingrediente("Laurel", 999999,
					EnumMedida.Unidad, 7, true, estaciones);
			s.save(laurel);
			s.flush();
			Ingrediente leche = new Ingrediente("Leche", 999999,
					EnumMedida.Litro, 60, true, estaciones);
			s.save(leche);
			s.flush();
			Ingrediente limon = new Ingrediente("Limón", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(limon);
			s.flush();
			Ingrediente lomo = new Ingrediente("Lomo", 999999, EnumMedida.Kilo,
					90, false, estaciones);
			s.save(lomo);
			s.flush();
			Ingrediente lomodecerdo = new Ingrediente("Lomo de cerdo", 999999,
					EnumMedida.Kilo, 90, true, estaciones);
			s.save(lomodecerdo);
			s.flush();
			Ingrediente mandioca = new Ingrediente("Mandioca", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(mandioca);
			s.flush();
			Ingrediente manteca = new Ingrediente("Manteca", 999999,
					EnumMedida.Kilo, 15, true, estaciones);
			s.save(manteca);
			s.flush();
			Ingrediente manzana = new Ingrediente("Manzana", 999999,
					EnumMedida.Kilo, 15, true, estaciones);
			s.save(manzana);
			s.flush();
			Ingrediente masahojaldradaparatartas = new Ingrediente(
					"Masa hojaldrada para tartas", 999999, EnumMedida.Unidad,
					30, true, estaciones);
			s.save(masahojaldradaparatartas);
			s.flush();
			Ingrediente mostaza = new Ingrediente("Mostaza", 999999,
					EnumMedida.Kilo, 30, true, estaciones);
			s.save(mostaza);
			s.flush();
			Ingrediente oregano = new Ingrediente("Oregano", 999999,
					EnumMedida.Kilo, 365, true, estaciones);
			s.save(oregano);
			s.flush();
			Ingrediente panintegral = new Ingrediente("Pan integral", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(panintegral);
			s.flush();
			Ingrediente panrallado = new Ingrediente("Pan rallado", 999999,
					EnumMedida.Kilo, 15, true, estaciones);
			s.save(panrallado);
			s.flush();
			Ingrediente papa = new Ingrediente("Papa", 999999, EnumMedida.Kilo,
					7, true, estaciones);
			s.save(papa);
			s.flush();
			Ingrediente pechugadepollo = new Ingrediente("Pechuga de pollo",
					999999, EnumMedida.Unidad, 90, false, estaciones);
			s.save(pechugadepollo);
			s.flush();
			Ingrediente perejil = new Ingrediente("Perejil", 999999,
					EnumMedida.Kilo, 30, true, estaciones);
			s.save(perejil);
			s.flush();
			Ingrediente pimenton = new Ingrediente("Pimenton", 999999,
					EnumMedida.Kilo, 365, true, estaciones);
			s.save(pimenton);
			s.flush();
			Ingrediente pimienta = new Ingrediente("Pimienta", 999999,
					EnumMedida.Kilo, 365, true, estaciones);
			s.save(pimienta);
			s.flush();
			Ingrediente pollo = new Ingrediente("Pollo", 56, EnumMedida.Kilo,
					4, false, estaciones);
			s.save(pollo);
			s.flush();
			Ingrediente puerro = new Ingrediente("Puerro", 999999,
					EnumMedida.Unidad, 7, true, estaciones);
			s.save(puerro);
			s.flush();
			Ingrediente puredetomate = new Ingrediente("Pure de Tomate", 15,
					EnumMedida.Litro, 60, true, estaciones);
			s.save(puredetomate);
			s.flush();
			Ingrediente quesocrema = new Ingrediente("Queso crema", 999999,
					EnumMedida.Kilo, 60, true, estaciones);
			s.save(quesocrema);
			s.flush();
			Ingrediente quesoporsalud = new Ingrediente("Queso por salud",
					999999, EnumMedida.Kilo, 60, true, estaciones);
			s.save(quesoporsalud);
			s.flush();
			Ingrediente quesorallado = new Ingrediente("Queso rallado", 999999,
					EnumMedida.Kilo, 15, true, estaciones);
			s.save(quesorallado);
			s.flush();
			Ingrediente ricotta = new Ingrediente("Ricotta", 999999,
					EnumMedida.Kilo, 4, true, estaciones);
			s.save(ricotta);
			s.flush();
			Ingrediente rucula = new Ingrediente("Rúcula", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(rucula);
			s.flush();
			Ingrediente sal = new Ingrediente("Sal", 999999, EnumMedida.Kilo,
					365, true, estaciones);
			s.save(sal);
			s.flush();
			Ingrediente salsadetomate = new Ingrediente("Salsa de tomate",
					999999, EnumMedida.Kilo, 365, true, estaciones);
			s.save(salsadetomate);
			s.flush();
			Ingrediente semilladesesamo = new Ingrediente("Semilla de sésamo",
					999999, EnumMedida.Kilo, 60, true, estaciones);
			s.save(semilladesesamo);
			s.flush();
			Ingrediente tomate = new Ingrediente("Tomate", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(tomate);
			s.flush();
			Ingrediente tomatecherry = new Ingrediente("Tomate cherry", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(tomatecherry);
			s.flush();
			Ingrediente tomillo = new Ingrediente("Tomillo", 999999,
					EnumMedida.Unidad, 7, true, estaciones);
			s.save(tomillo);
			s.flush();
			Ingrediente vinoblanco = new Ingrediente("Vino blanco", 999999,
					EnumMedida.Litro, 365, true, estaciones);
			s.save(vinoblanco);
			s.flush();
			Ingrediente vinotinto = new Ingrediente("Vino tinto", 999999,
					EnumMedida.Litro, 365, true, estaciones);
			s.save(vinotinto);
			s.flush();
			Ingrediente zanahoria = new Ingrediente("Zanahoria", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(zanahoria);
			s.flush();
			Ingrediente zapallito = new Ingrediente("Zapallito", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(zapallito);
			s.flush();
			Ingrediente zucchini = new Ingrediente("Zucchini", 999999,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(zucchini);
			s.flush();

			// Tag

			Tag pescado = new Tag("pescado", "pescado");
			s.save(pescado);
			s.flush();
			Tag tagpollo = new Tag("pollo", "pollo");
			s.save(tagpollo);
			s.flush();
			Tag carne = new Tag("carne", "carne");
			s.save(carne);
			Tag verdura = new Tag("verdura", "verdura");
			s.save(verdura);
			s.flush();
			Tag pasta = new Tag("pasta", "pasta");
			s.save(pasta);
			s.flush();
			Tag cerdo = new Tag("cerdo", "cerdo");
			s.save(cerdo);
			s.flush();

			// Creacion de Clientes
			//

			List<Restriccion> listaRestricciones = new ArrayList<Restriccion>();
			listaRestricciones.add(restriccion1);

			ClientesDAO.crearCliente(new Cliente("Checho", "Molinero",
					"Calle 1", "111111", "13", "Quilmes", "1878", null,
					EnumEstado.ACTIVO, null, listaRestricciones, "Centro"));

			listaRestricciones.add(restriccion2);

			ClientesDAO.crearCliente(new Cliente("Chalo", "Camino", "Calle 2",
					"22222", "13:30", "Quilmes", "1878", null,
					EnumEstado.ACTIVO, null, listaRestricciones, "Oeste"));

			Plato cazuelacampestre = new Plato(
					"Cazuela campestre",
					"Pelar las papas y las zanahorias y cortarlas en cuatro. Cortar la carne de cordero en cubos medianos y el puerro en trozos no muy pequeños. En una olla con un chorro de aceite, sofreír el puerro. Agregar los cubos de cordero y cocinar por unos minutos. Incorporar las zanahorias, las papas y las flores de coliflor. Salpimentar a gusto. Cubrir con el caldo. Incorporar la rama de laurel y cocinar a fuego suave por uno 40 minutos.",
					EnumTipoPlato.Principal, pescado);
			Plato carnealvapor = new Plato(
					"Carne al vapor",
					"Para preparar el hogao, calentar el aceite y sofreír la cebolla, cuando esté transparente agregar el tomate y el resto de los condimentos hasta que todo esté bien cocido. Poner aparte. Aparte, calentar el resto del aceite en una cacerola grande y sofreír la carne por todos los lados. Añadir un poco de agua y el hogao, tapar bien la cacerola y cocinarla a fuego medio durante 30 minutos. Luego, agregar las papas, la yuca y todo el resto de los condimentos. Sazonar con sal y pimienta y cocinar durante 30 minutos o hasta que la carne esté bien tierna.",
					EnumTipoPlato.Principal, carne);
			Plato goulashHungaro = new Plato(
					"Goulash húngaro",
					"1. Cortar la carne en trozos regulares y quitar la grasa sobrante. 2. Colar el tomate con un colador, para conseguir pulpa de tomate espesa (o ponerlo frito) 3. pelar las cebollas y picarlas (yo con la thermomix a vl. 4-5) pelar las zanahorias y cortarlas en rodajas. 4. Poner un buen chorro de aceite de oliva virgen a calentar en la olla express y rehogar la carne, a continuación las cebollas, y los ajos luego las zanahorias y el tomate, salpimentar, remover de vez en cuando. 5. añadir el resto de ingredientes, el laurel, el pimentón y el vino, cerrar la olla y cuado la válvula gire, contar 15 minutos, apagar el fuego, dejar que pierda presión. 6. abrir la olla, sacar la carne mas o menos escurrida a otra cacerola donde se vaya a servir, y el fondo (normalmente queda bastante liquido) meterlo en la thermomix junto con algunos trozos de zanahoria y triturar, añadirlo a la carne, si fuese mucho, no ponerlo todo. 7. acompañar de arroz pilaf o blanco",
					EnumTipoPlato.Principal, carne);
			Plato medallonDeLomoEnCrouteDeHierbas = new Plato(
					"Medallón de lomo en croute de hierbas",
					"Limpia el lomo y córtalo en medallones gruesos. Coloca el aceite en una sartén y sella los medallones de ambos lados. Sazona con sal y pimienta. Termina la cocción en el horno a 200°C durante 10 minutos. Desglasa la sartén con oporto. Incorpora las alcaparras y el caldo. Rectifica la sazón. Cocina 1 minuto o hasta que se evapore el alcohol. Mezcla las hierbas picadas, las almendras peladas, tostadas y picadas, el pan lácteo desmigado y el aceite de oliva. 5 minutos antes de finalizar la cocción, cubre los medallones con la croûte de hierbas y almendras. Rinde para 4 porciones.",
					EnumTipoPlato.Principal, carne);
			Plato guisodeternera = new Plato(
					"Guiso de Ternera",
					"Se filetea la carne de ternera y se apalea con un cuchillo plano o un mazo para ablandarla, después se corta en daditos. Ponemos la carne a freír con aceite en una olla y removemos, mientras tanto pelar tomates y cebollas apartes iguales y cortarlos en daditos. Picar la mitad de zanahorias que de tomates. Añadírselo a la carne y remover, añadir el vino, pimentar y dejar cocinar durante una hora.Acompañar con un trozo de piña de Postre.",
					EnumTipoPlato.Principal, carne);
			Plato lomodecerdoalhornoconcebollitas = new Plato(
					"Lomo de cerdo al horno con cebollitas",
					"1. Poner el lomo en una fuente de horno salpimentar 2. Cortar las verduras, las cebollas en juliana las zanahorias en rodajas y en trozos las patatas. 3. Regar con el vino y echar aceite de oliva sobre las verduras y la carne. 4. Meter al horno precalentado 40 min. a 200º tapado con un papel de aluminio (para que no se reseque mucho) 5. Al terminar regar el lomo con la miel subir el horno a 230º poner el gril y dejarlo para que se dore unos 10 min. más.",
					EnumTipoPlato.Principal, cerdo);
			Plato tortilladeespinaca = new Plato(
					"Tortilla de espinaca",
					"Colocar en un bol la espinaca junto con la cebolla salteadas, agregar los huevos, sazonar e incorporar los hongos fileteados y la panceta en cubos pequeños. Mezclar todo y cocinar en sartén con un hilo de aceite de oliva. Utilizar un tapa de cacerola para presionar la tortilla mientras se va cocinando, a media cocción dar vuelta con la ayuda de la tapa de cacerola y terminar de cocinar. Servir tibia con Ensalada fresca.",
					EnumTipoPlato.Principal, verdura);
			Plato platoArvejas = new Plato("Arvejas",
					"Servir fríos en Ensalada", EnumTipoPlato.Ensalada, null);
			Plato polloconsalsadechampinones = new Plato(
					"Pollo con salsa de champiñones",
					"Prepararemos nuestras pechugas de pollo con salsa de champiñones, comenzando con el sellado de las pechugas. Para ello se fríen en un poco de aceite con la mitad de los ajos laminados o enteros. Cuando estén las pechugas bien doradas, se apartan del fuego y ser reservan. Para hacer la salsa de las pechugas de pollo con salsa de champiñón: Se corta una cebolla en tacos, los otros dientes de ajo en lámina y se ponen a freír en el aceite dónde hemos hecho las pechugas, a fuego bajo. Cuando estén un poco doraditos, se echan los champiñones bien limpios y laminados, y un poco de pimienta negra. Cuando termine de pocharse todo se le hecha la leche, y se bate la salsa. Es bueno guardar algunas láminas de champiñones sin triturar, para adornar el plato y que se sepa que la salsa está echa con ellos.",
					EnumTipoPlato.Principal, tagpollo);
			Plato pescadoensalsadeaji = new Plato(
					"Pescado en salsa de ají",
					"Calentar el aceite en una sartén y agregar la cebolla picada. Cocinar hasta que esté tierna y transparente. Agregar los ajíes ya licuados y cocinar moviendo 5 minutos. Agregar el pan, previamente remojado en leche y escurrido. Mezclar. Sazonar con sal, pimienta y queso parmesano. Colocar el pescado en un molde refractario ligeramente engrasado y verter encima la crema de ají. Salpicar con trocitos de mantequilla. Llevar al horno precalentado a 350ºF (180ºC) durante 15 minutos o hasta que el pescado esté cocido.",
					EnumTipoPlato.Principal, pescado);
			Plato pasteldechoclo = new Plato(
					"Pastel de choclo",
					"Rehogar en una cacerola la cebolla en la manteca hasta que quede transparente. Agregar la harina y revolver cocinando la preparación 1 minuto. Incorporar lentamente la leche caliente donde se habrá disuelto el cubito de caldo revolviendo continuamente. Cocinar hasta espesar 5 minutos. Retirar, agregar el choclo, el queso rallado, el pan rallado y entibiar. Incorporar los huevos de a uno, mezclando bien y condimentar con pimienta y nuez moscada. Colocar en una fuente de horno enmantecada, espolvorear con queso rallado y azúcar. Cocinar en horno moderado 40 minutos, hasta que este firme el pastel. Servir caliente o frío, solo o con guarnición de jamón crudo. Se puede hacer en cazuelitas individuales.",
					EnumTipoPlato.Principal, verdura);
			Plato milanesadesoja = new Plato(
					"Milanesa de soja",
					"Mezclar la harina de soja, la harina de gluten, sal, cebolla rallada, ajo, perejil, la clara sin batir y cantidad necesaria de agua para formar un pasta.Formar un cilindro y enfriar tapado 30 minutos. Estirar y cortar círculos de 10 a 12 cm. Hervirlos en caldo caliente durante 5 minutos. Retirar con espumadera, escurrir sobre papel absorbente Pasar las milanesas por huevo batido, sal, ajo y perejil y pan rallado. Hornear o freír. Acompañar con Ensalada de hojas verdes.",
					EnumTipoPlato.Principal, verdura);
			Plato pasteldeberenjenasyespinacas = new Plato(
					"Pastel de berenjenas y espinacas",
					"Cortamos a daditos la berenjena la ponemos en un plato hondo con dos cucharadas de agua y un poco de sal, las llevamos al microondas y las dejamos unos 7 minutos. Reservamos. De igual forma ponemos las espinacas congeladas en un plato con dos cucharadas de agua y las dejamos 6 minutos, pero a mitad del tiempo paramos para remover un poco y añadir un poco de sal. Luego en una sarten ponemos dos cucharadas de aceite de oliva y echamos los ajos picados a fuego medio hasta que se doren, echamos un poco de sal y el pimentón, cocinamos bien el pimentón durante 4 minutos y volcamos las espinacas, salteamos unos minutos y salpimentamos, cocinamos las espinacas durante 6 ó 7 minutos y reservamos. Para emplatar, utilizaremos un molde circular en el que primero pondremos una loncha de queso, encima una parte de las berenjenas, luego otra loncha de queso, echamos las espinacas, desmoldamos y coronamos con una cuña del mismo queso, llevar el plato al microondas y ponerlo a media potencia (600w.) durante unos minutos para que funda el queso.",
					EnumTipoPlato.Principal, verdura);
			Plato pollocrocanteconavena = new Plato(
					"Pollo crocante con avena",
					"Sofríe el ajo en aceite de oliva. Incorpora el brócoli picado y revuelve durante 3 minutos a fuego medio. Añade la Avena, queso, sal y pimienta. Mezcla bien. Corta los filetes de pollo para que queden en forma mariposa. También realiza otro corte para redondear un poco los extremos. Sazona con sal y pimienta. Divide el relleno en cinco partes iguales. Coloca una porción en cada corte de los filetes. Ciérralos con 3 mondadientes por filete. Para apanarlos, mezcla en un recipiente Avena, semillas de sésamo, sal y pimienta. Sumerge los filetes en la clara de huevo y luego pásalos por la mezcla de Avena y sésamo cubriendo toda la superficie. Llévalos al horno precalentado a 180ºC en una fuente con aceite de oliva, durante aproximadamente 40 minutos. Voltéalos a la mitad del tiempo para que se doren y queden crujientes por ambos lados.",
					EnumTipoPlato.Principal, tagpollo);
			Plato risottoconhongos = new Plato(
					"Risotto con hongos",
					"Picar la cebolla en brunoise, tiene que quedar del tamaño del grano de arroz. Colocar en una sartén el aceite de oliva. Saltear la cebolla cortada. Agregar a la cebolla el arroz, sellar los granos hasta que cambien de color, desglazar con el vino y condimentar. Incorporar de a poco el fondo de vegetales. Cuando falten cinco minutos para terminar la cocción del arroz, agregar los hongos frescos fileteados. Terminar montando con manteca y queso provolone rallado.",
					EnumTipoPlato.Principal, verdura);
			Plato rollosdepescadoyespinaca = new Plato(
					"Rollos de pescado y espinaca",
					"En un recipiente colocamos los filetes de pescado, agregamos el jugo de limón, la mostaza, sal, pimienta y el ajo bien picadito. Revolvemos bien todo y dejamos macerar durante 10 minutos. Picamos la espinaca bien chiquita, le agregamos la ricotta, sal, pimienta, nuez moscada y las dos cucharadas de aceite. Revolvemos bien para unir todo. Tomamos de a uno los filetes y como se ve en la foto, le colocamos el relleno enrollando y sujetando con dos escarbadientes para que no se abran. En una sartén o cacerola colocamos un chorrito de aceite y ponemos los rollitos. Cocinamos durante 15 minutos girándolos cada tanto, para que se doren de todos lados. Si hacen mucha cantidad lo pueden colocar en una fuente y llevar al horno cocinándolos durante 20 minutos. Para la salsa colocamos en una cacerolita la crema y el caldo y calentamos hasta disolver todo. Si se quiere una salsa más liviana se le puede agregar leche. Con esta preparación cubrimos los rollitos y a la mesa.",
					EnumTipoPlato.Principal, pescado);
			Plato pollogrilleallimon = new Plato(
					"Pollo grille al limón",
					"En una bolsa con cierre hermético poner las pechugas de pollo, menta, ajo, jugo y ralladura de limón;  dejar marinar en el refrigerador por 8 horas. Calentar un sartén para grillar o una parrilla a fuego alto y aceitar con una brocha. Estilar las pechugas de pollo y reservar la marinada; grillar 4-5 min. o hasta que la superficie de las pechugas estén bien marcadas. Darlas vuelta y grillar por el otro lado, rociando constantemente con el líquido de la marinada reservada hasta que estén doradas y cocidas. Sazonar con sal y pimienta. Retirar del fuego y servir de inmediato acompañado de papas asadas o verduras salteadas.",
					EnumTipoPlato.Principal, tagpollo);
			Plato ensaladadeverdurasgrilladas = new Plato(
					"Ensalada de verduras grilladas",
					"Lavar y secar bien las hojas verdes. Disponerlas sobre la base de los platos. Cortar bastones largos de zucchini y berenjena y grillarlos con sal, pimienta y aceite. Reservar calientes. Cortar los tomates cherry a la mitad. Cortar cuadrados de pan y tostar en el horno. Vinagreta: Licuar el tomate trozado con el vinagre, los condimentos y el aceite. Monatje: Servir las verduras sobre las hojas verdes. Decorar con los cherry, los pancitos tostados y la salsa.",
					EnumTipoPlato.Ensalada, verdura);
			Plato pescadoconaceitunas = new Plato(
					"Pescado con aceitunas",
					"Calienta el aceite de oliva en una cacerola amplia y sofríe el ajo y la cebolla hasta que se vean transparentes. Sazona el pescado con sal e incorpóralo a la mezcla anterior; cocina durante un par de minutos y añade el jitomate, aceitunas, perejil y alcaparras. Revuelve con cuidado, tapa y cocina unos minutos más, hasta que el pescado se haya cocido.",
					EnumTipoPlato.Principal, pescado);
			Plato fideosalhuevoconmanteca = new Plato(
					"Fideos al Huevo con manteca",
					"En una fuente grande se distribuye la harina y la sal. Se hace un hoyo en el centro y se agregan los huevos. Se toma la masa con las manos, agregando la cucharada de aceite en el proceso. Cuando se tiene una masa unida se amasa sobre la mesada no menos de 10 minutos (paso vital) hasta que la masa quede uniforme y con cierta elasticidad. Se forma un bollo y se deja reposar por lo menos una media hora tapándolo con un repasador seco. Luego se divide en 5 o 6 trozos y se pasa por la máquina de pastas, reduciendo en un punto el espesor en cada pasada. En nuestro caso, los rodillos tienen 7 espesores: el 6 lo utilizamos para pasta rellena, el 5 para los fideos anchos y el 4 para los fideos finos como los de esta foto. Es muy importante el paso por el primer nivel (el más grueso). Aquí paso la pasta de 6 a 8 veces, doblando en dos cada vez, hasta obtener una tira del ancho de la procesadora. Los siguientes pasos se realizan con esta base, espolvoreando con abundante harina y pasando una sola vez por cada espesor. Se van estirando los fideos cortados en una mesa o tabla grande, sobre un papel blanco de envolver y espolvoreados una vez más con harina. En esta foto puede observarse una producción de “fettuccine” con algunos “finos” para Cecilia, por supuesto. Si se dispone de una parrilla o rack de madera como la mostrada se cuelgan los fideos cubiertos con un repasador húmedo hasta el momento de hervirlos en abundante agua.",
					EnumTipoPlato.Principal, pasta);
			Plato manzanaasada = new Plato(
					"Manzana asada",
					"Con la ayuda de un cuchillo de punta afilada, extrae, con mucho cuidado, el corazón de las manzanas. Luego llena los huecos con azúcar, un poquito de coñac y las almendras, si es que decides agregarle, picadas bien finitas. Ahora coloca las manzanas en una fuente para horno, pero previamente úntala con manteca. Preparado todo esto, añádele un chorrito de agua y pínchalas ligeramente con un tenedor para que no revienten, ¡no querrás tener un desastre dentro de tu horno! A continuación colócale la tapa de las manzanas que cortaste para poder rellenarlas. Encima de ellas, pon una cucharada de azúcar, que una vez cocida quedara dorada, mejorando el aspecto y el sabor. Finalmente déjalas al horno, moderado, unos treinta minutos y ya tendrás tus manzanas preparadas para disfrutarlas. Como veras es muy sencillo e hacer y no lleva mas que unos minutos.",
					EnumTipoPlato.Postre, null);
			Plato raviolesdejamonyricotta = new Plato(
					"Ravioles de jamón y ricotta",
					"Masa. Colocar la harina junto con la sal, sobre la mesa de trabajo. Hacer un hoyo en el centro y poner las yemas, el huevo, el aceite y algo de agua. Mezclar los ingredientes con las puntas de llos dedos e ir tomando la harina de a pequeñas porciones hasta integrar toda la harina, agregándole más cantidad de agua de ser necesario para terminar de ligar todo. El agua que necesite la masa, se agregará de a cucharadas para que la masa no se tiernice demasiado por exceso de humedad. Su consistencia debe ser blanda pero no demasiado. Amasar durante 12 minutos aproximadamente o hasta lograr una masa elástica, que no se pegue en las manos ni en la mesa. Tomar el bollo y colocarlo en una bolsa plástica y dejarlo a temperatura ambiente durante 20 a 30 minutos, para que repose. Pasado ese tiempo, sacar la masa de la bolsa plástica y apoyarla sobre la mesa enharinada. Dvidirla en varias partes para que con poco volumen de masa nos resulte más fácil estirarla con el palote. Primero aplanarla con las manos y luego comenzar a estirarla siempre partiendo del centro. Estirar hacia arriba y luego hacia abajo y hacia los costados dándole forma rectangular. Les recordamos nuevamente que la masa se estira apoyando el palote sobre la mitad de la masa y haciéndolo girar desde allí hacia el borde superior. Lo mismo se realiza para el borde inferior. Esto permite ir quebrando el gluten y llegar a los bordes sin que estos retrocedan o se encogan. Continuar estirando hasta que la masa esté fina pero no en exceso, aproximadamente de 1mm de espesor. Espolvorear con un poco de harina y cubrirla con un paño para que no se seque. Continuar haciendo lo mismo con el resto de la masa. agregar un poco de caldo y continuar la cocción a fuego lento durante 15 minutos más con la cacerola destapada o hasta que la salsa tome consistencia.",
					EnumTipoPlato.Principal, pasta);
			Plato tartadezapallitos = new Plato(
					"Tarta de zapallitos",
					"Cortar la cebolla en rodajas finas. Cortar el aji en tiras. Cortar los zapallitos en rodajas y luego en cuadraditos de 2 cm. mas o menos. Saltear la cebolla, el aji y los zapallitos en una sartén utilizando ½ parte de manteca y ½ de aceite. Batir ligeramente los huevos. Mezclar los huevos con la crema, el queso crema y el salteado de cebolla ají y zapallitos. Agregar el queso rallado y salpimentar nuevamente de ser necesario. Colocar el disco de masa en una tartera. Rellenar con la mezcla de zapallitos. Llevar a horno moderado hasta que la superficie esté dorada, unos 40 minutos. Retirar y servir tibia o fría.",
					EnumTipoPlato.Principal, verdura);
			Plato platoBanana = new Plato("Banana", "", EnumTipoPlato.Postre,
					null);
			Plato platoManzana = new Plato("Manzana", "", EnumTipoPlato.Postre,
					null);
			Plato puredepapa = new Plato(
					"Pure de papa",
					"Para hacer el pure de papa siempre es mejor hervir las papas con la cascara, previo a eso siempre hay que lavarlas (mas si no son papas blancas y tienen mucha tierra). Debemos preparar el agua con sal y colocar alli las papas, luego de media hora y dependiendo del tamaño de las mismas podemos verificas si estas listas pinchandolas con un cuchillo (si entra con facilidad es que ya estan listas). Una vez que termina la cocción de nuestras papas, lo que haremos es ponerlas en una fuente de agua bien frí­a y les quitaremos la cáscara. Cuando las tenemos peladas, tendremos 2 opciones o usar el pisa papa tradicional o recurrir a la mini pimer (si usamos la mini pimer deberemos cortar las papas en trozos previamente). Una vez que obtenemos el puré de papa, lo condimentaremos con nuez moscada, manteca, leche o crema de leche, pimienta y si fuera necesario con una pizca de sal, lo mezclamos y ya esta listo para servir.",
					EnumTipoPlato.Ensalada, null);
			Plato puredezapallo = new Plato(
					"Pure de zapallo",
					"Muchas veces a la hora de poner a hervir el zapallo, nos damos cuenta que sacarle la cáscara resulta una molestia, por lo que si se lava bien, el zapallo puede hervirse con cáscara y sacarsela una vez cocido es muy sencillo. Es importante hervir el zapallo con un poco de sal. Durante la coccion se puede verificar si esta listo pinchandolo, siempre depende del tamaño de los trozos de zapallo. Para condimentarlo se le puede añadir aceite de oliva, pimienta, una pizca de sal y una pizca de azúcar para realzarle el sabor.",
					EnumTipoPlato.Ensalada, null);
			Plato duraznoenalmibar = new Plato(
					"Durazno en almibar",
					"Lavar los duraznos, secarlos, ponerlos en una cacerola, cubrirlos con agua y agregar azucar a gusto hasta que el agua tome el sabor que se prefiera. Agregar la chaucha de vainilla o la esencia a gusto. Cocinar hasta que los duraznos esten tiernos, pero firmes. Retirar del fuego, pelarlos con cuidado, quitar los carozos. Colocar los carozos y la piel de los duraznos en la cacerola donde estaba el agua y continuar la coccion. Cuando se obtiene un almibar semidenso, colar y reservar. Limpiar frascos de vidrio con alcohol fino,dejar unos minutos hasta que se evapore el olor a alcohol, acomodar los duraznos y llenar los frascos con el almibar caliente. Dejar enfriar y cerrar los frascos hermeticamente. Conservar en la heladera.",
					EnumTipoPlato.Postre, null);

			// Creacion de Platos
			// // Lomo Strogonoff Liviano
			// Plato plato = new Plato();
			// List<ItemIngrediente> ingredientes = new
			// ArrayList<ItemIngrediente>();
			// ingredientes.add(new ItemIngrediente(crema, 1));
			// ingredientes.add(new ItemIngrediente(lomo, 1));
			// ingredientes.add(new ItemIngrediente(perejil, 1));
			// ingredientes.add(new ItemIngrediente(champi, 1));
			// ingredientes.add(new ItemIngrediente(pureTomate, 1));
			// ingredientes.add(new ItemIngrediente(cebolla, 1));
			// ingredientes.add(new ItemIngrediente(crema, 1));
			// ingredientes.add(new ItemIngrediente(ajo, 1));
			// plato.setIngredientes(ingredientes);
			// plato.setNombre("Lomo Strogonoff Liviano");
			// plato.setReceta("1.	Retirar cualquier rastro de grasa visible que pudiera tener el lomo; cortarlo en cubos de 2cm de lado.<br> 2.	Cortar los champiï¿½ones en laminas. Reservar todo.<br>3.	Picar la cebolla y el ajo. Cocinarlos en una olla, con 1 cucharada de caldo, hasta que la cebolla este transparente.<br>4.	Aï¿½adir los cubos de lomo y cocinar hasta que cambien de color en toda su superficie.<br>5.	Agregar los champiï¿½ones, el resto del caldo, el pure de tomate y la mostaza. Continuar la coccion aproximadamente 20 minutos mas, hasta que la carne este tierna.<br>6.	Incorporar la crema de leche y cocinar 10 minutos mas.<br/>7.Espolvorear con peejil picado y servir caliente, con el arroz blanco como guarnicion.");
			// s.save(plato);

			cazuelacampestre.getIngredientes().add(
					new ItemIngrediente(puerro, Float.parseFloat("1")));
			cazuelacampestre.getIngredientes().add(
					new ItemIngrediente(carnedecordero, Float
							.parseFloat("0.75")));
			cazuelacampestre.getIngredientes().add(
					new ItemIngrediente(coliflor, Float.parseFloat("1")));
			cazuelacampestre.getIngredientes().add(
					new ItemIngrediente(zanahoria, Float.parseFloat("0.5")));
			cazuelacampestre.getIngredientes().add(
					new ItemIngrediente(papa, Float.parseFloat("1.5")));
			cazuelacampestre.getIngredientes().add(
					new ItemIngrediente(aceitedegirasol, Float
							.parseFloat("0.05")));
			cazuelacampestre.getIngredientes().add(
					new ItemIngrediente(cubodecaldoverdura, Float
							.parseFloat("1")));
			cazuelacampestre.getIngredientes().add(
					new ItemIngrediente(laurel, Float.parseFloat("1")));
			carnealvapor.getIngredientes().add(
					new ItemIngrediente(papa, Float.parseFloat("1")));
			carnealvapor.getIngredientes().add(
					new ItemIngrediente(aceitedegirasol, Float
							.parseFloat("0.03")));
			carnealvapor.getIngredientes().add(
					new ItemIngrediente(carnederes, Float.parseFloat("0.5")));
			carnealvapor.getIngredientes().add(
					new ItemIngrediente(mandioca, Float.parseFloat("0.3")));
			carnealvapor.getIngredientes().add(
					new ItemIngrediente(oregano, Float.parseFloat("1")));
			carnealvapor.getIngredientes().add(
					new ItemIngrediente(tomillo, Float.parseFloat("1")));
			carnealvapor.getIngredientes().add(
					new ItemIngrediente(sal, Float.parseFloat("0.003")));
			carnealvapor.getIngredientes().add(
					new ItemIngrediente(pimienta, Float.parseFloat("0.002")));
			goulashHungaro.getIngredientes().add(
					new ItemIngrediente(zanahoria, Float.parseFloat("0.5")));
			goulashHungaro.getIngredientes()
					.add(new ItemIngrediente(carnedeternera, Float
							.parseFloat("1.5")));
			goulashHungaro.getIngredientes().add(
					new ItemIngrediente(ajo, Float.parseFloat("0.016")));
			goulashHungaro.getIngredientes().add(
					new ItemIngrediente(cebolla, Float.parseFloat("1")));
			goulashHungaro.getIngredientes().add(
					new ItemIngrediente(vinotinto, Float.parseFloat("0.15")));
			goulashHungaro.getIngredientes().add(
					new ItemIngrediente(salsadetomate, Float
							.parseFloat("0.175")));
			medallonDeLomoEnCrouteDeHierbas.getIngredientes().add(
					new ItemIngrediente(sal, Float.parseFloat("0.003")));
			medallonDeLomoEnCrouteDeHierbas.getIngredientes().add(
					new ItemIngrediente(pimienta, Float.parseFloat("0.002")));
			medallonDeLomoEnCrouteDeHierbas.getIngredientes()
					.add(new ItemIngrediente(aceitedeoliva, Float
							.parseFloat("0.05")));
			medallonDeLomoEnCrouteDeHierbas.getIngredientes().add(
					new ItemIngrediente(panintegral, Float.parseFloat("0.1")));
			medallonDeLomoEnCrouteDeHierbas.getIngredientes().add(
					new ItemIngrediente(lomo, Float.parseFloat("1")));
			medallonDeLomoEnCrouteDeHierbas.getIngredientes().add(
					new ItemIngrediente(almendras, Float.parseFloat("0.1")));
			guisodeternera.getIngredientes().add(
					new ItemIngrediente(zanahoria, Float.parseFloat("0.5")));
			guisodeternera.getIngredientes().add(
					new ItemIngrediente(pimienta, Float.parseFloat("0.002")));
			guisodeternera.getIngredientes()
					.add(new ItemIngrediente(aceitedeoliva, Float
							.parseFloat("0.05")));
			guisodeternera.getIngredientes().add(
					new ItemIngrediente(cebolla, Float.parseFloat("0.2")));
			guisodeternera.getIngredientes().add(
					new ItemIngrediente(vinotinto, Float.parseFloat("0.15")));
			guisodeternera.getIngredientes().add(
					new ItemIngrediente(tomate, Float.parseFloat("0.15")));
			guisodeternera.getIngredientes().add(
					new ItemIngrediente(carnedeternera, Float.parseFloat("1")));
			lomodecerdoalhornoconcebollitas.getIngredientes().add(
					new ItemIngrediente(papa, Float.parseFloat("0.5")));
			lomodecerdoalhornoconcebollitas.getIngredientes()
					.add(new ItemIngrediente(aceitedeoliva, Float
							.parseFloat("0.05")));
			lomodecerdoalhornoconcebollitas.getIngredientes().add(
					new ItemIngrediente(cebolla, Float.parseFloat("0.2")));
			lomodecerdoalhornoconcebollitas.getIngredientes().add(
					new ItemIngrediente(vinoblanco, Float.parseFloat("0.15")));
			lomodecerdoalhornoconcebollitas.getIngredientes().add(
					new ItemIngrediente(lomodecerdo, Float.parseFloat("1")));
			tortilladeespinaca.getIngredientes().add(
					new ItemIngrediente(aceitedegirasol, Float
							.parseFloat("0.03")));
			tortilladeespinaca.getIngredientes().add(
					new ItemIngrediente(sal, Float.parseFloat("0.003")));
			tortilladeespinaca.getIngredientes().add(
					new ItemIngrediente(pimienta, Float.parseFloat("0.002")));
			tortilladeespinaca.getIngredientes().add(
					new ItemIngrediente(cebolla, Float.parseFloat("0.2")));
			tortilladeespinaca.getIngredientes().add(
					new ItemIngrediente(espinaca, Float.parseFloat("0.25")));
			tortilladeespinaca.getIngredientes().add(
					new ItemIngrediente(huevo, Float.parseFloat("5")));
			platoArvejas.getIngredientes().add(
					new ItemIngrediente(arvejas, Float.parseFloat("0.2")));
			polloconsalsadechampinones.getIngredientes().add(
					new ItemIngrediente(pimienta, Float.parseFloat("0.002")));
			polloconsalsadechampinones.getIngredientes().add(
					new ItemIngrediente(ajo, Float.parseFloat("0.016")));
			polloconsalsadechampinones.getIngredientes().add(
					new ItemIngrediente(cebolla, Float.parseFloat("0.2")));
			polloconsalsadechampinones.getIngredientes().add(
					new ItemIngrediente(pechugadepollo, Float.parseFloat("2")));
			polloconsalsadechampinones.getIngredientes().add(
					new ItemIngrediente(champinones, Float.parseFloat("0.3")));
			polloconsalsadechampinones.getIngredientes().add(
					new ItemIngrediente(leche, Float.parseFloat("0.25")));
			pescadoensalsadeaji.getIngredientes().add(
					new ItemIngrediente(aceitedegirasol, Float
							.parseFloat("0.045")));
			pescadoensalsadeaji.getIngredientes().add(
					new ItemIngrediente(sal, Float.parseFloat("0.002")));
			pescadoensalsadeaji.getIngredientes().add(
					new ItemIngrediente(cebolla, Float.parseFloat("0.2")));
			pescadoensalsadeaji.getIngredientes().add(
					new ItemIngrediente(panintegral, Float.parseFloat("0.1")));
			pescadoensalsadeaji.getIngredientes().add(
					new ItemIngrediente(ajiamarillo, Float.parseFloat("10")));
			pescadoensalsadeaji.getIngredientes().add(
					new ItemIngrediente(manteca, Float.parseFloat("0.025")));
			pescadoensalsadeaji.getIngredientes().add(
					new ItemIngrediente(filetedepescado, Float
							.parseFloat("0.5")));
			pasteldechoclo.getIngredientes().add(
					new ItemIngrediente(cubodecaldoverdura, Float
							.parseFloat("1")));
			pasteldechoclo.getIngredientes().add(
					new ItemIngrediente(pimienta, Float.parseFloat("0.002")));
			pasteldechoclo.getIngredientes().add(
					new ItemIngrediente(cebolla, Float.parseFloat("0.4")));
			pasteldechoclo.getIngredientes().add(
					new ItemIngrediente(huevo, Float.parseFloat("4")));
			pasteldechoclo.getIngredientes().add(
					new ItemIngrediente(leche, Float.parseFloat("0.47")));
			pasteldechoclo.getIngredientes().add(
					new ItemIngrediente(manteca, Float.parseFloat("0.05")));
			pasteldechoclo.getIngredientes().add(
					new ItemIngrediente(harina, Float.parseFloat("0.015")));
			pasteldechoclo.getIngredientes().add(
					new ItemIngrediente(choclo, Float.parseFloat("0.35")));
			pasteldechoclo.getIngredientes()
					.add(new ItemIngrediente(quesorallado, Float
							.parseFloat("0.03")));
			pasteldechoclo.getIngredientes().add(
					new ItemIngrediente(panrallado, Float.parseFloat("0.02")));
			pasteldechoclo.getIngredientes().add(
					new ItemIngrediente(azucar, Float.parseFloat("0.0025")));
			milanesadesoja.getIngredientes().add(
					new ItemIngrediente(cubodecaldoverdura, Float
							.parseFloat("1")));
			milanesadesoja.getIngredientes().add(
					new ItemIngrediente(ajo, Float.parseFloat("0.01")));
			milanesadesoja.getIngredientes().add(
					new ItemIngrediente(cebolla, Float.parseFloat("0.2")));
			milanesadesoja.getIngredientes().add(
					new ItemIngrediente(huevo, Float.parseFloat("3")));
			milanesadesoja.getIngredientes().add(
					new ItemIngrediente(panrallado, Float.parseFloat("0.2")));
			milanesadesoja.getIngredientes().add(
					new ItemIngrediente(harinadesoja, Float.parseFloat("0.5")));
			milanesadesoja.getIngredientes().add(
					new ItemIngrediente(harinadegluten, Float
							.parseFloat("0.25")));
			pasteldeberenjenasyespinacas.getIngredientes().add(
					new ItemIngrediente(sal, Float.parseFloat("0.002")));
			pasteldeberenjenasyespinacas.getIngredientes()
					.add(new ItemIngrediente(aceitedeoliva, Float
							.parseFloat("0.05")));
			pasteldeberenjenasyespinacas.getIngredientes().add(
					new ItemIngrediente(ajo, Float.parseFloat("0.015")));
			pasteldeberenjenasyespinacas.getIngredientes().add(
					new ItemIngrediente(espinaca, Float.parseFloat("0.25")));
			pasteldeberenjenasyespinacas.getIngredientes().add(
					new ItemIngrediente(berenjena, Float.parseFloat("0.15")));
			pasteldeberenjenasyespinacas.getIngredientes()
					.add(new ItemIngrediente(quesoporsalud, Float
							.parseFloat("0.08")));
			pollocrocanteconavena.getIngredientes().add(
					new ItemIngrediente(aceitedegirasol, Float
							.parseFloat("0.02")));
			pollocrocanteconavena.getIngredientes().add(
					new ItemIngrediente(sal, Float.parseFloat("0.006")));
			pollocrocanteconavena.getIngredientes().add(
					new ItemIngrediente(pimienta, Float.parseFloat("0.003")));
			pollocrocanteconavena.getIngredientes().add(
					new ItemIngrediente(ajo, Float.parseFloat("0.022")));
			pollocrocanteconavena.getIngredientes().add(
					new ItemIngrediente(huevo, Float.parseFloat("1")));
			pollocrocanteconavena.getIngredientes().add(
					new ItemIngrediente(pechugadepollo, Float.parseFloat("5")));
			pollocrocanteconavena.getIngredientes().add(
					new ItemIngrediente(avena, Float.parseFloat("0.12")));
			pollocrocanteconavena.getIngredientes().add(
					new ItemIngrediente(quesocrema, Float.parseFloat("0.055")));
			pollocrocanteconavena.getIngredientes().add(
					new ItemIngrediente(brocoli, Float.parseFloat("0.15")));
			pollocrocanteconavena.getIngredientes().add(
					new ItemIngrediente(semilladesesamo, Float
							.parseFloat("0.058")));
			risottoconhongos.getIngredientes().add(
					new ItemIngrediente(cubodecaldoverdura, Float
							.parseFloat("1")));
			risottoconhongos.getIngredientes().add(
					new ItemIngrediente(sal, Float.parseFloat("0.002")));
			risottoconhongos.getIngredientes().add(
					new ItemIngrediente(pimienta, Float.parseFloat("0.002")));
			risottoconhongos.getIngredientes()
					.add(new ItemIngrediente(aceitedeoliva, Float
							.parseFloat("0.06")));
			risottoconhongos.getIngredientes().add(
					new ItemIngrediente(cebolla, Float.parseFloat("0.15")));
			risottoconhongos.getIngredientes().add(
					new ItemIngrediente(vinoblanco, Float.parseFloat("0.1")));
			risottoconhongos.getIngredientes().add(
					new ItemIngrediente(manteca, Float.parseFloat("0.05")));
			risottoconhongos.getIngredientes().add(
					new ItemIngrediente(quesorallado, Float.parseFloat("0.1")));
			risottoconhongos.getIngredientes().add(
					new ItemIngrediente(arroz, Float.parseFloat("0.5")));
			risottoconhongos.getIngredientes().add(
					new ItemIngrediente(hongo, Float.parseFloat("0.4")));
			rollosdepescadoyespinaca.getIngredientes().add(
					new ItemIngrediente(aceitedegirasol, Float
							.parseFloat("0.03")));
			rollosdepescadoyespinaca.getIngredientes().add(
					new ItemIngrediente(pimienta, Float.parseFloat("0.002")));
			rollosdepescadoyespinaca.getIngredientes().add(
					new ItemIngrediente(ajo, Float.parseFloat("0.016")));
			rollosdepescadoyespinaca.getIngredientes().add(
					new ItemIngrediente(espinaca, Float.parseFloat("0.2")));
			rollosdepescadoyespinaca.getIngredientes().add(
					new ItemIngrediente(filetedepescado, Float
							.parseFloat("0.5")));
			rollosdepescadoyespinaca.getIngredientes().add(
					new ItemIngrediente(limon, Float.parseFloat("0.1")));
			rollosdepescadoyespinaca.getIngredientes().add(
					new ItemIngrediente(ricotta, Float.parseFloat("0.25")));
			rollosdepescadoyespinaca.getIngredientes().add(
					new ItemIngrediente(mostaza, Float.parseFloat("0.06")));
			rollosdepescadoyespinaca.getIngredientes().add(
					new ItemIngrediente(cremadeleche, Float.parseFloat("0.2")));
			pollogrilleallimon.getIngredientes().add(
					new ItemIngrediente(aceitedegirasol, Float
							.parseFloat("0.12")));
			pollogrilleallimon.getIngredientes().add(
					new ItemIngrediente(sal, Float.parseFloat("0.002")));
			pollogrilleallimon.getIngredientes().add(
					new ItemIngrediente(pimienta, Float.parseFloat("0.002")));
			pollogrilleallimon.getIngredientes().add(
					new ItemIngrediente(ajo, Float.parseFloat("0.06")));
			pollogrilleallimon.getIngredientes().add(
					new ItemIngrediente(pechugadepollo, Float.parseFloat("4")));
			pollogrilleallimon.getIngredientes().add(
					new ItemIngrediente(limon, Float.parseFloat("0.6")));
			ensaladadeverdurasgrilladas.getIngredientes().add(
					new ItemIngrediente(aceitedegirasol, Float
							.parseFloat("0.03")));
			ensaladadeverdurasgrilladas.getIngredientes().add(
					new ItemIngrediente(pimienta, Float.parseFloat("0.002")));
			ensaladadeverdurasgrilladas.getIngredientes().add(
					new ItemIngrediente(vinotinto, Float.parseFloat("0.01")));
			ensaladadeverdurasgrilladas.getIngredientes().add(
					new ItemIngrediente(panintegral, Float.parseFloat("0.1")));
			ensaladadeverdurasgrilladas.getIngredientes().add(
					new ItemIngrediente(tomate, Float.parseFloat("0.15")));
			ensaladadeverdurasgrilladas.getIngredientes().add(
					new ItemIngrediente(espinaca, Float.parseFloat("0.2")));
			ensaladadeverdurasgrilladas.getIngredientes().add(
					new ItemIngrediente(berenjena, Float.parseFloat("0.3")));
			ensaladadeverdurasgrilladas.getIngredientes().add(
					new ItemIngrediente(rucula, Float.parseFloat("0.15")));
			ensaladadeverdurasgrilladas.getIngredientes().add(
					new ItemIngrediente(zucchini, Float.parseFloat("0.2")));
			ensaladadeverdurasgrilladas.getIngredientes().add(
					new ItemIngrediente(tomatecherry, Float.parseFloat("0.1")));
			pescadoconaceitunas.getIngredientes()
					.add(new ItemIngrediente(aceitedeoliva, Float
							.parseFloat("0.03")));
			pescadoconaceitunas.getIngredientes().add(
					new ItemIngrediente(ajo, Float.parseFloat("0.06")));
			pescadoconaceitunas.getIngredientes().add(
					new ItemIngrediente(cebolla, Float.parseFloat("0.2")));
			pescadoconaceitunas.getIngredientes().add(
					new ItemIngrediente(tomate, Float.parseFloat("0.15")));
			pescadoconaceitunas.getIngredientes().add(
					new ItemIngrediente(filetedepescado, Float
							.parseFloat("0.5")));
			pescadoconaceitunas.getIngredientes().add(
					new ItemIngrediente(alcaparras, Float.parseFloat("0.04")));
			pescadoconaceitunas.getIngredientes().add(
					new ItemIngrediente(perejil, Float.parseFloat("0.1")));
			pescadoconaceitunas.getIngredientes().add(
					new ItemIngrediente(aceituna, Float.parseFloat("10")));
			fideosalhuevoconmanteca.getIngredientes().add(
					new ItemIngrediente(aceitedegirasol, Float
							.parseFloat("0.01")));
			fideosalhuevoconmanteca.getIngredientes().add(
					new ItemIngrediente(huevo, Float.parseFloat("3")));
			fideosalhuevoconmanteca.getIngredientes().add(
					new ItemIngrediente(manteca, Float.parseFloat("0.025")));
			fideosalhuevoconmanteca.getIngredientes().add(
					new ItemIngrediente(harina, Float.parseFloat("0.3")));
			manzanaasada.getIngredientes().add(
					new ItemIngrediente(azucar, Float.parseFloat("0.1")));
			manzanaasada.getIngredientes().add(
					new ItemIngrediente(manzana, Float.parseFloat("0.8")));
			manzanaasada.getIngredientes().add(
					new ItemIngrediente(conac, Float.parseFloat("0.2")));
			raviolesdejamonyricotta.getIngredientes().add(
					new ItemIngrediente(aceitedegirasol, Float
							.parseFloat("0.01")));
			raviolesdejamonyricotta.getIngredientes().add(
					new ItemIngrediente(sal, Float.parseFloat("0.004")));
			raviolesdejamonyricotta.getIngredientes().add(
					new ItemIngrediente(pimienta, Float.parseFloat("0.004")));
			raviolesdejamonyricotta.getIngredientes().add(
					new ItemIngrediente(huevo, Float.parseFloat("8")));
			raviolesdejamonyricotta.getIngredientes().add(
					new ItemIngrediente(leche, Float.parseFloat("0.35")));
			raviolesdejamonyricotta.getIngredientes().add(
					new ItemIngrediente(manteca, Float.parseFloat("0.05")));
			raviolesdejamonyricotta.getIngredientes().add(
					new ItemIngrediente(harina, Float.parseFloat("0.65")));
			raviolesdejamonyricotta.getIngredientes().add(
					new ItemIngrediente(quesorallado, Float.parseFloat("0.1")));
			raviolesdejamonyricotta.getIngredientes().add(
					new ItemIngrediente(ricotta, Float.parseFloat("0.2")));
			raviolesdejamonyricotta.getIngredientes().add(
					new ItemIngrediente(perejil, Float.parseFloat("0.02")));
			raviolesdejamonyricotta.getIngredientes().add(
					new ItemIngrediente(jamon, Float.parseFloat("0.3")));
			tartadezapallitos.getIngredientes()
					.add(new ItemIngrediente(aceitedeoliva, Float
							.parseFloat("0.03")));
			tartadezapallitos.getIngredientes().add(
					new ItemIngrediente(cebolla, Float.parseFloat("0.1")));
			tartadezapallitos.getIngredientes().add(
					new ItemIngrediente(huevo, Float.parseFloat("3")));
			tartadezapallitos.getIngredientes().add(
					new ItemIngrediente(ajiamarillo, Float.parseFloat("1")));
			tartadezapallitos.getIngredientes().add(
					new ItemIngrediente(manteca, Float.parseFloat("0.02")));
			tartadezapallitos.getIngredientes().add(
					new ItemIngrediente(quesorallado, Float.parseFloat("0.1")));
			tartadezapallitos.getIngredientes()
					.add(new ItemIngrediente(cremadeleche, Float
							.parseFloat("0.35")));
			tartadezapallitos.getIngredientes().add(
					new ItemIngrediente(zapallito, Float.parseFloat("0.5")));
			tartadezapallitos.getIngredientes().add(
					new ItemIngrediente(cebollitadeverdeo, Float
							.parseFloat("0.2")));
			tartadezapallitos.getIngredientes().add(
					new ItemIngrediente(masahojaldradaparatartas, Float
							.parseFloat("1")));
			platoBanana.getIngredientes().add(
					new ItemIngrediente(manzana, Float.parseFloat("0.25")));
			platoManzana.getIngredientes().add(
					new ItemIngrediente(banana, Float.parseFloat("0.25")));
			puredepapa.getIngredientes().add(
					new ItemIngrediente(papa, Float.parseFloat("0.4")));
			puredezapallo.getIngredientes().add(
					new ItemIngrediente(sal, Float.parseFloat("0.003")));
			puredezapallo.getIngredientes().add(
					new ItemIngrediente(zapallito, Float.parseFloat("0.5")));
			duraznoenalmibar.getIngredientes().add(
					new ItemIngrediente(azucar, Float.parseFloat("0.02")));
			duraznoenalmibar.getIngredientes().add(
					new ItemIngrediente(durazno, Float.parseFloat("1")));
			duraznoenalmibar.getIngredientes().add(
					new ItemIngrediente(esenciadevainilla, Float
							.parseFloat("0.02")));

			s.save(cazuelacampestre);
			s.flush();
			s.save(carnealvapor);
			s.flush();
			s.save(goulashHungaro);
			s.flush();
			s.save(medallonDeLomoEnCrouteDeHierbas);
			s.flush();
			s.save(guisodeternera);
			s.flush();
			s.save(lomodecerdoalhornoconcebollitas);
			s.flush();
			s.save(tortilladeespinaca);
			s.flush();
			s.save(platoArvejas);
			s.flush();
			s.save(polloconsalsadechampinones);
			s.flush();
			s.save(pescadoensalsadeaji);
			s.flush();
			s.save(pasteldechoclo);
			s.flush();
			s.save(milanesadesoja);
			s.flush();
			s.save(pasteldeberenjenasyespinacas);
			s.flush();
			s.save(pollocrocanteconavena);
			s.flush();
			s.save(risottoconhongos);
			s.flush();
			s.save(rollosdepescadoyespinaca);
			s.flush();
			s.save(pollogrilleallimon);
			s.flush();
			s.save(ensaladadeverdurasgrilladas);
			s.flush();
			s.save(pescadoconaceitunas);
			s.flush();
			s.save(fideosalhuevoconmanteca);
			s.flush();
			s.save(manzanaasada);
			s.flush();
			s.save(raviolesdejamonyricotta);
			s.flush();
			s.save(tartadezapallitos);
			s.flush();
			s.save(platoBanana);
			s.flush();
			s.save(platoManzana);
			s.flush();
			s.save(puredepapa);
			s.flush();
			s.save(puredezapallo);
			s.flush();
			s.save(duraznoenalmibar);
			s.flush();

			// Creación de menus

			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

			Menu menu1 = new Menu();
			menu1.setCalorias(1000);
			menu1.setEstado(EnumEstado.ACTIVO);
			List<Plato> platos1 = new ArrayList<Plato>();
			platos1.add(cazuelacampestre);
			platos1.add(platoArvejas);
			platos1.add(duraznoenalmibar);
			menu1.setPlatos(platos1);
			menu1.setRestricciones(listaRestricciones);
			menu1.setTag(pescado);
			menu1.setUltimoUso(df.parse("2014/01/01"));
			s.save(menu1);
			s.flush();

			Menu menu2 = new Menu();
			menu2.setCalorias(1500);
			menu2.setEstado(EnumEstado.ACTIVO);
			List<Plato> platos2 = new ArrayList<Plato>();
			platos2.add(carnealvapor);
			platos2.add(platoArvejas);
			platos2.add(platoBanana);
			menu2.setPlatos(platos2);
			menu2.setRestricciones(listaRestricciones);
			menu2.setTag(carne);
			menu2.setUltimoUso(df.parse("2014/01/01"));
			s.save(menu2);
			s.flush();

			Menu menu3 = new Menu();
			menu3.setCalorias(1500);
			menu3.setEstado(EnumEstado.ACTIVO);
			List<Plato> platos3 = new ArrayList<Plato>();
			platos3.add(tortilladeespinaca);
			platos3.add(platoArvejas);
			platos3.add(platoManzana);
			menu3.setPlatos(platos3);
			menu3.setRestricciones(listaRestricciones);
			menu3.setTag(verdura);
			menu3.setUltimoUso(df.parse("2014/01/01"));
			s.save(menu3);
			s.flush();

			// transac.commit();
		} catch (Exception e) {
			// transac.rollback();
			e.printStackTrace();
			System.out.println("No se pudo dar de alto los resgistros");
		}

	}
}
