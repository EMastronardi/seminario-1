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

			Estacion otonio = new Estacion("Oto�o");
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
			
			// estaciones truncadas
			ArrayList<Estacion> estacionesIncompletas = new ArrayList<Estacion>();
			estacionesIncompletas.add(invierno);

			Ingrediente ingrediente = new Ingrediente();

			// Creacion de restricciones
			Restriccion restriccion1 = new Restriccion();
			restriccion1.setDescripcion("Hipertensi�n - No consumir Sal");
			restriccion1.setNombre("Sin Sal");
			restriccion1.setSeveridad(5);
			s.save(restriccion1);
			s.flush();
			Restriccion restriccion2 = new Restriccion();
			restriccion2.setDescripcion("Intolerancia a TACC");
			restriccion2.setNombre("Cel�aco");
			restriccion2.setSeveridad(8);
			s.save(restriccion2);
			s.flush();
			Restriccion restriccion3 = new Restriccion();
			restriccion3.setDescripcion("Diabetes - No consumir az�car");
			restriccion3.setNombre("Sin az�car");
			restriccion3.setSeveridad(3);
			s.save(restriccion3);
			s.flush();
			Restriccion restriccion4 = new Restriccion();
			restriccion4
					.setDescripcion("Divert�culos - Evitar comidas sin fibras");
			restriccion4.setNombre("Divert�culos");
			restriccion4.setSeveridad(5);
			s.save(restriccion4);
			s.flush();
			/*
			 * Creacion de Ingredientes
			 */
			// probar algun ingrediente don estacionesIncompletas en vez de con estaciones
			Ingrediente aceitedegirasol = new Ingrediente("Aceite de girasol",
					9, EnumMedida.Litro, 365, true, estaciones);
			s.save(aceitedegirasol);
			s.flush();
			Ingrediente aceitedeoliva = new Ingrediente("Aceite de oliva", 9,
					EnumMedida.Litro, 90, true, estaciones);
			s.save(aceitedeoliva);
			s.flush();
			Ingrediente aceituna = new Ingrediente("Aceituna", 9,
					EnumMedida.Unidad, 30, true, estaciones);
			s.save(aceituna);
			s.flush();
			Ingrediente ajiamarillo = new Ingrediente("Aj� amarillo", 9,
					EnumMedida.Unidad, 7, true, estaciones);
			s.save(ajiamarillo);
			s.flush();
			Ingrediente ajo = new Ingrediente("Ajo", 9, EnumMedida.Kilo, 7,
					true, estaciones);
			s.save(ajo);
			s.flush();
			Ingrediente alcaparras = new Ingrediente("Alcaparras", 9,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(alcaparras);
			s.flush();
			Ingrediente almendra = new Ingrediente("Almendra", 9,
					EnumMedida.Kilo, 90, true, estaciones);
			s.save(almendra);
			s.flush();
			Ingrediente almendras = new Ingrediente("Almendras", 9,
					EnumMedida.Kilo, 15, true, estaciones);
			s.save(almendras);
			s.flush();
			Ingrediente arroz = new Ingrediente("Arroz", 9, EnumMedida.Kilo,
					365, true, estaciones);
			s.save(arroz);
			s.flush();
			Ingrediente arvejas = new Ingrediente("Arvejas", 9,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(arvejas);
			s.flush();
			Ingrediente avena = new Ingrediente("Avena", 9, EnumMedida.Kilo,
					90, true, estaciones);
			s.save(avena);
			s.flush();
			Ingrediente azucar = new Ingrediente("Az�car", 9, EnumMedida.Kilo,
					365, true, estaciones);
			s.save(azucar);
			s.flush();
			Ingrediente banana = new Ingrediente("Banana", 9, EnumMedida.Kilo,
					7, true, estaciones);
			s.save(banana);
			s.flush();
			Ingrediente berenjena = new Ingrediente("Berenjena", 9,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(berenjena);
			s.flush();
			Ingrediente brocoli = new Ingrediente("Br�coli", 9,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(brocoli);
			s.flush();
			Ingrediente carnedecordero = new Ingrediente("Carne de cordero", 9,
					EnumMedida.Kilo, 90, false, estaciones);
			s.save(carnedecordero);
			s.flush();
			Ingrediente carnederes = new Ingrediente("Carne de res", 9,
					EnumMedida.Kilo, 90, false, estaciones);
			s.save(carnederes);
			s.flush();

			Ingrediente carnedeternera = new Ingrediente("Carne de ternera", 9,
					EnumMedida.Kilo, 90, false, estaciones);
			s.save(carnedeternera);
			s.flush();
			Ingrediente cebolla = new Ingrediente("Cebolla", 9,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(cebolla);
			s.flush();
			Ingrediente cebollitadeverdeo = new Ingrediente(
					"Cebollita de verdeo", 9, EnumMedida.Kilo, 7, true,
					estaciones);
			s.save(cebollitadeverdeo);
			s.flush();
			Ingrediente champinones = new Ingrediente("Champi�ones", 9,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(champinones);
			s.flush();
			Ingrediente choclo = new Ingrediente("Choclo", 9, EnumMedida.Kilo,
					7, true, estaciones);
			s.save(choclo);
			s.flush();
			Ingrediente coliflor = new Ingrediente("Coliflor", 9,
					EnumMedida.Unidad, 7, true, estaciones);
			s.save(coliflor);
			s.flush();
			Ingrediente comino = new Ingrediente("Comino", 9, EnumMedida.Kilo,
					365, true, estaciones);
			s.save(comino);
			s.flush();
			Ingrediente conac = new Ingrediente("Co�ac", 9, EnumMedida.Litro,
					365, true, estaciones);
			s.save(conac);
			s.flush();
			Ingrediente cremadeleche = new Ingrediente("Crema de Leche", 15,
					EnumMedida.Litro, 5, true, estaciones);
			s.save(cremadeleche);
			s.flush();
			Ingrediente cubodecaldoverdura = new Ingrediente(
					"Cubo de caldo verdura", 9, EnumMedida.Unidad, 90, true,
					estaciones);
			s.save(cubodecaldoverdura);
			s.flush();
			Ingrediente durazno = new Ingrediente("Durazno", 9,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(durazno);
			s.flush();
			Ingrediente esenciadevainilla = new Ingrediente(
					"Esencia de vainilla", 9, EnumMedida.Litro, 365, true,
					estaciones);
			s.save(esenciadevainilla);
			s.flush();
			Ingrediente espinaca = new Ingrediente("Espinaca", 9,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(espinaca);
			s.flush();
			Ingrediente filetedepescado = new Ingrediente("Filete de pescado",
					9, EnumMedida.Kilo, 90, true, estaciones);
			s.save(filetedepescado);
			s.flush();
			Ingrediente harina = new Ingrediente("Harina", 9, EnumMedida.Kilo,
					365, true, estaciones);
			s.save(harina);
			s.flush();
			Ingrediente harinadegluten = new Ingrediente("Harina de gluten", 9,
					EnumMedida.Kilo, 365, true, estaciones);
			s.save(harinadegluten);
			s.flush();
			Ingrediente harinadesoja = new Ingrediente("Harina de soja", 9,
					EnumMedida.Kilo, 365, true, estaciones);
			s.save(harinadesoja);
			s.flush();
			Ingrediente hierbas = new Ingrediente("Hierbas", 9,
					EnumMedida.Kilo, 90, true, estaciones);
			s.save(hierbas);
			s.flush();
			Ingrediente hongo = new Ingrediente("Hongo", 9, EnumMedida.Kilo,
					365, true, estaciones);
			s.save(hongo);
			s.flush();
			Ingrediente huevo = new Ingrediente("Huevo", 9, EnumMedida.Unidad,
					7, true, estaciones);
			s.save(huevo);
			s.flush();
			Ingrediente jamon = new Ingrediente("Jam�n", 9, EnumMedida.Kilo, 7,
					true, estaciones);
			s.save(jamon);
			s.flush();
			Ingrediente laurel = new Ingrediente("Laurel", 9,
					EnumMedida.Unidad, 7, true, estaciones);
			s.save(laurel);
			s.flush();
			Ingrediente leche = new Ingrediente("Leche", 9, EnumMedida.Litro,
					60, true, estaciones);
			s.save(leche);
			s.flush();
			Ingrediente limon = new Ingrediente("Lim�n", 9, EnumMedida.Kilo, 7,
					true, estaciones);
			s.save(limon);
			s.flush();
			Ingrediente lomo = new Ingrediente("Lomo", 9, EnumMedida.Kilo, 90,
					false, estaciones);
			s.save(lomo);
			s.flush();
			Ingrediente lomodecerdo = new Ingrediente("Lomo de cerdo", 9,
					EnumMedida.Kilo, 90, true, estaciones);
			s.save(lomodecerdo);
			s.flush();
			Ingrediente mandioca = new Ingrediente("Mandioca", 9,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(mandioca);
			s.flush();
			Ingrediente manteca = new Ingrediente("Manteca", 9,
					EnumMedida.Kilo, 15, true, estaciones);
			s.save(manteca);
			s.flush();
			Ingrediente manzana = new Ingrediente("Manzana", 9,
					EnumMedida.Kilo, 15, true, estaciones);
			s.save(manzana);
			s.flush();
			Ingrediente masahojaldradaparatartas = new Ingrediente(
					"Masa hojaldrada para tartas", 9, EnumMedida.Unidad, 30,
					true, estaciones);
			s.save(masahojaldradaparatartas);
			s.flush();
			Ingrediente mostaza = new Ingrediente("Mostaza", 9,
					EnumMedida.Kilo, 30, true, estaciones);
			s.save(mostaza);
			s.flush();
			Ingrediente oregano = new Ingrediente("Oregano", 9,
					EnumMedida.Kilo, 365, true, estaciones);
			s.save(oregano);
			s.flush();
			Ingrediente panintegral = new Ingrediente("Pan integral", 9,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(panintegral);
			s.flush();
			Ingrediente panrallado = new Ingrediente("Pan rallado", 9,
					EnumMedida.Kilo, 15, true, estaciones);
			s.save(panrallado);
			s.flush();
			Ingrediente papa = new Ingrediente("Papa", 9, EnumMedida.Kilo, 7,
					true, estaciones);
			s.save(papa);
			s.flush();
			Ingrediente pechugadepollo = new Ingrediente("Pechuga de pollo", 9,
					EnumMedida.Unidad, 90, false, estaciones);
			s.save(pechugadepollo);
			s.flush();
			Ingrediente perejil = new Ingrediente("Perejil", 9,
					EnumMedida.Kilo, 30, true, estaciones);
			s.save(perejil);
			s.flush();
			Ingrediente pimenton = new Ingrediente("Pimenton", 9,
					EnumMedida.Kilo, 365, true, estaciones);
			s.save(pimenton);
			s.flush();
			Ingrediente pimienta = new Ingrediente("Pimienta", 9,
					EnumMedida.Kilo, 365, true, estaciones);
			s.save(pimienta);
			s.flush();
			Ingrediente pollo = new Ingrediente("Pollo", 56, EnumMedida.Kilo,
					4, false, estaciones);
			s.save(pollo);
			s.flush();
			Ingrediente puerro = new Ingrediente("Puerro", 9,
					EnumMedida.Unidad, 7, true, estaciones);
			s.save(puerro);
			s.flush();
			Ingrediente puredetomate = new Ingrediente("Pure de Tomate", 15,
					EnumMedida.Litro, 60, true, estaciones);
			s.save(puredetomate);
			s.flush();
			Ingrediente quesocrema = new Ingrediente("Queso crema", 9,
					EnumMedida.Kilo, 60, true, estaciones);
			s.save(quesocrema);
			s.flush();
			Ingrediente quesoporsalud = new Ingrediente("Queso por salud", 9,
					EnumMedida.Kilo, 60, true, estaciones);
			s.save(quesoporsalud);
			s.flush();
			Ingrediente quesorallado = new Ingrediente("Queso rallado", 9,
					EnumMedida.Kilo, 15, true, estaciones);
			s.save(quesorallado);
			s.flush();
			Ingrediente ricotta = new Ingrediente("Ricotta", 9,
					EnumMedida.Kilo, 4, true, estaciones);
			s.save(ricotta);
			s.flush();
			Ingrediente rucula = new Ingrediente("R�cula", 9, EnumMedida.Kilo,
					7, true, estaciones);
			s.save(rucula);
			s.flush();
			Ingrediente sal = new Ingrediente("Sal", 9, EnumMedida.Kilo, 365,
					true, estaciones);
			s.save(sal);
			s.flush();
			Ingrediente salsadetomate = new Ingrediente("Salsa de tomate", 9,
					EnumMedida.Kilo, 365, true, estaciones);
			s.save(salsadetomate);
			s.flush();
			Ingrediente semilladesesamo = new Ingrediente("Semilla de s�samo",
					9, EnumMedida.Kilo, 60, true, estaciones);
			s.save(semilladesesamo);
			s.flush();
			Ingrediente tomate = new Ingrediente("Tomate", 9, EnumMedida.Kilo,
					7, true, estaciones);
			s.save(tomate);
			s.flush();
			Ingrediente tomatecherry = new Ingrediente("Tomate cherry", 9,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(tomatecherry);
			s.flush();
			Ingrediente tomillo = new Ingrediente("Tomillo", 9,
					EnumMedida.Unidad, 7, true, estaciones);
			s.save(tomillo);
			s.flush();
			Ingrediente vinoblanco = new Ingrediente("Vino blanco", 9,
					EnumMedida.Litro, 365, true, estaciones);
			s.save(vinoblanco);
			s.flush();
			Ingrediente vinotinto = new Ingrediente("Vino tinto", 9,
					EnumMedida.Litro, 365, true, estaciones);
			s.save(vinotinto);
			s.flush();
			Ingrediente zanahoria = new Ingrediente("Zanahoria", 9,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(zanahoria);
			s.flush();
			Ingrediente zapallito = new Ingrediente("Zapallito", 9,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(zapallito);
			s.flush();
			Ingrediente zucchini = new Ingrediente("Zucchini", 9,
					EnumMedida.Kilo, 7, true, estaciones);
			s.save(zucchini);
			s.flush();

			/**********************
			 * 
			 * Tag
			 * 
			 * 
			 ***********************/

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

			List<Restriccion> listaRestricciones1 = new ArrayList<Restriccion>();
			listaRestricciones1.add(restriccion1);
			List<Restriccion> listaRestricciones2 = new ArrayList<Restriccion>();
			listaRestricciones2.add(restriccion2);
			List<Restriccion> listaRestricciones3 = new ArrayList<Restriccion>();
			listaRestricciones3.add(restriccion3);
			List<Restriccion> listaRestricciones4 = new ArrayList<Restriccion>();
			listaRestricciones4.add(restriccion4);

			ClientesDAO.crearCliente(new Cliente("Checho", "Molinero",
					"Calle 1", "111111", "13", "Quilmes", "1878", null,
					EnumEstado.ACTIVO, null, listaRestricciones1, "Centro"));

			ClientesDAO.crearCliente(new Cliente("Chalo", "Camino", "Calle 2",
					"22222", "13:30", "Quilmes", "1878", null,
					EnumEstado.ACTIVO, null, listaRestricciones2, "Oeste"));

			ClientesDAO.crearCliente(new Cliente("Emma", "Mastro", "Calle 3",
					"3333", "13:30", "Marteli", "4444", null,
					EnumEstado.ACTIVO, null, listaRestricciones3, "Norte"));

			ClientesDAO.crearCliente(new Cliente("Damiancito", "Quiroga",
					"Calle 4", "4444", "13:30", "Adelina", "5555", null,
					EnumEstado.ACTIVO, null, listaRestricciones4, "Norte"));


			ClientesDAO.crearCliente(new Cliente("Santi", "Rodriguez",
					"Calle 5", "5555", "13:30", "Almagro", "6666", null,
					EnumEstado.ACTIVO, null, null, "Capital"));

			/****************
			 * 
			 * Creaci�n de PLatos
			 * 
			 ******************/

			Plato cazuelacampestre = new Plato(
					"Cazuela campestre",
					"Pelar las papas y las zanahorias y cortarlas en cuatro. Cortar la carne de cordero en cubos medianos y el puerro en trozos no muy peque�os. En una olla con un chorro de aceite, sofre�r el puerro. Agregar los cubos de cordero y cocinar por unos minutos. Incorporar las zanahorias, las papas y las flores de coliflor. Salpimentar a gusto. Cubrir con el caldo. Incorporar la rama de laurel y cocinar a fuego suave por uno 40 minutos.",
					EnumTipoPlato.Principal, pescado);
			Plato carnealvapor = new Plato(
					"Carne al vapor",
					"Para preparar el hogao, calentar el aceite y sofre�r la cebolla, cuando est� transparente agregar el tomate y el resto de los condimentos hasta que todo est� bien cocido. Poner aparte. Aparte, calentar el resto del aceite en una cacerola grande y sofre�r la carne por todos los lados. A�adir un poco de agua y el hogao, tapar bien la cacerola y cocinarla a fuego medio durante 30 minutos. Luego, agregar las papas, la yuca y todo el resto de los condimentos. Sazonar con sal y pimienta y cocinar durante 30 minutos o hasta que la carne est� bien tierna.",
					EnumTipoPlato.Principal, carne);
			Plato goulashHungaro = new Plato(
					"Goulash h�ngaro",
					"1. Cortar la carne en trozos regulares y quitar la grasa sobrante. 2. Colar el tomate con un colador, para conseguir pulpa de tomate espesa (o ponerlo frito) 3. pelar las cebollas y picarlas (yo con la thermomix a vl. 4-5) pelar las zanahorias y cortarlas en rodajas. 4. Poner un buen chorro de aceite de oliva virgen a calentar en la olla express y rehogar la carne, a continuaci�n las cebollas, y los ajos luego las zanahorias y el tomate, salpimentar, remover de vez en cuando. 5. a�adir el resto de ingredientes, el laurel, el piment�n y el vino, cerrar la olla y cuado la v�lvula gire, contar 15 minutos, apagar el fuego, dejar que pierda presi�n. 6. abrir la olla, sacar la carne mas o menos escurrida a otra cacerola donde se vaya a servir, y el fondo (normalmente queda bastante liquido) meterlo en la thermomix junto con algunos trozos de zanahoria y triturar, a�adirlo a la carne, si fuese mucho, no ponerlo todo. 7. acompa�ar de arroz pilaf o blanco",
					EnumTipoPlato.Principal, carne);
			Plato medallonDeLomoEnCrouteDeHierbas = new Plato(
					"Medall�n de lomo en croute de hierbas",
					"Limpia el lomo y c�rtalo en medallones gruesos. Coloca el aceite en una sart�n y sella los medallones de ambos lados. Sazona con sal y pimienta. Termina la cocci�n en el horno a 200�C durante 10 minutos. Desglasa la sart�n con oporto. Incorpora las alcaparras y el caldo. Rectifica la saz�n. Cocina 1 minuto o hasta que se evapore el alcohol. Mezcla las hierbas picadas, las almendras peladas, tostadas y picadas, el pan l�cteo desmigado y el aceite de oliva. 5 minutos antes de finalizar la cocci�n, cubre los medallones con la cro�te de hierbas y almendras. Rinde para 4 porciones.",
					EnumTipoPlato.Principal, carne);
			Plato guisodeternera = new Plato(
					"Guiso de Ternera",
					"Se filetea la carne de ternera y se apalea con un cuchillo plano o un mazo para ablandarla, despu�s se corta en daditos. Ponemos la carne a fre�r con aceite en una olla y removemos, mientras tanto pelar tomates y cebollas apartes iguales y cortarlos en daditos. Picar la mitad de zanahorias que de tomates. A�ad�rselo a la carne y remover, a�adir el vino, pimentar y dejar cocinar durante una hora.Acompa�ar con un trozo de pi�a de Postre.",
					EnumTipoPlato.Principal, carne);
			Plato lomodecerdoalhornoconcebollitas = new Plato(
					"Lomo de cerdo al horno con cebollitas",
					"1. Poner el lomo en una fuente de horno salpimentar 2. Cortar las verduras, las cebollas en juliana las zanahorias en rodajas y en trozos las patatas. 3. Regar con el vino y echar aceite de oliva sobre las verduras y la carne. 4. Meter al horno precalentado 40 min. a 200� tapado con un papel de aluminio (para que no se reseque mucho) 5. Al terminar regar el lomo con la miel subir el horno a 230� poner el gril y dejarlo para que se dore unos 10 min. m�s.",
					EnumTipoPlato.Principal, cerdo);
			Plato tortilladeespinaca = new Plato(
					"Tortilla de espinaca",
					"Colocar en un bol la espinaca junto con la cebolla salteadas, agregar los huevos, sazonar e incorporar los hongos fileteados y la panceta en cubos peque�os. Mezclar todo y cocinar en sart�n con un hilo de aceite de oliva. Utilizar un tapa de cacerola para presionar la tortilla mientras se va cocinando, a media cocci�n dar vuelta con la ayuda de la tapa de cacerola y terminar de cocinar. Servir tibia con Ensalada fresca.",
					EnumTipoPlato.Principal, verdura);
			Plato platoArvejas = new Plato("Arvejas",
					"Servir fr�os en Ensalada", EnumTipoPlato.Ensalada, null);
			Plato polloconsalsadechampinones = new Plato(
					"Pollo con salsa de champi�ones",
					"Prepararemos nuestras pechugas de pollo con salsa de champi�ones, comenzando con el sellado de las pechugas. Para ello se fr�en en un poco de aceite con la mitad de los ajos laminados o enteros. Cuando est�n las pechugas bien doradas, se apartan del fuego y ser reservan. Para hacer la salsa de las pechugas de pollo con salsa de champi��n: Se corta una cebolla en tacos, los otros dientes de ajo en l�mina y se ponen a fre�r en el aceite d�nde hemos hecho las pechugas, a fuego bajo. Cuando est�n un poco doraditos, se echan los champi�ones bien limpios y laminados, y un poco de pimienta negra. Cuando termine de pocharse todo se le hecha la leche, y se bate la salsa. Es bueno guardar algunas l�minas de champi�ones sin triturar, para adornar el plato y que se sepa que la salsa est� echa con ellos.",
					EnumTipoPlato.Principal, tagpollo);
			Plato pescadoensalsadeaji = new Plato(
					"Pescado en salsa de aj�",
					"Calentar el aceite en una sart�n y agregar la cebolla picada. Cocinar hasta que est� tierna y transparente. Agregar los aj�es ya licuados y cocinar moviendo 5 minutos. Agregar el pan, previamente remojado en leche y escurrido. Mezclar. Sazonar con sal, pimienta y queso parmesano. Colocar el pescado en un molde refractario ligeramente engrasado y verter encima la crema de aj�. Salpicar con trocitos de mantequilla. Llevar al horno precalentado a 350�F (180�C) durante 15 minutos o hasta que el pescado est� cocido.",
					EnumTipoPlato.Principal, pescado);
			Plato pasteldechoclo = new Plato(
					"Pastel de choclo",
					"Rehogar en una cacerola la cebolla en la manteca hasta que quede transparente. Agregar la harina y revolver cocinando la preparaci�n 1 minuto. Incorporar lentamente la leche caliente donde se habr� disuelto el cubito de caldo revolviendo continuamente. Cocinar hasta espesar 5 minutos. Retirar, agregar el choclo, el queso rallado, el pan rallado y entibiar. Incorporar los huevos de a uno, mezclando bien y condimentar con pimienta y nuez moscada. Colocar en una fuente de horno enmantecada, espolvorear con queso rallado y az�car. Cocinar en horno moderado 40 minutos, hasta que este firme el pastel. Servir caliente o fr�o, solo o con guarnici�n de jam�n crudo. Se puede hacer en cazuelitas individuales.",
					EnumTipoPlato.Principal, verdura);
			Plato milanesadesoja = new Plato(
					"Milanesa de soja",
					"Mezclar la harina de soja, la harina de gluten, sal, cebolla rallada, ajo, perejil, la clara sin batir y cantidad necesaria de agua para formar un pasta.Formar un cilindro y enfriar tapado 30 minutos. Estirar y cortar c�rculos de 10 a 12 cm. Hervirlos en caldo caliente durante 5 minutos. Retirar con espumadera, escurrir sobre papel absorbente Pasar las milanesas por huevo batido, sal, ajo y perejil y pan rallado. Hornear o fre�r. Acompa�ar con Ensalada de hojas verdes.",
					EnumTipoPlato.Principal, verdura);
			Plato pasteldeberenjenasyespinacas = new Plato(
					"Pastel de berenjenas y espinacas",
					"Cortamos a daditos la berenjena la ponemos en un plato hondo con dos cucharadas de agua y un poco de sal, las llevamos al microondas y las dejamos unos 7 minutos. Reservamos. De igual forma ponemos las espinacas congeladas en un plato con dos cucharadas de agua y las dejamos 6 minutos, pero a mitad del tiempo paramos para remover un poco y a�adir un poco de sal. Luego en una sarten ponemos dos cucharadas de aceite de oliva y echamos los ajos picados a fuego medio hasta que se doren, echamos un poco de sal y el piment�n, cocinamos bien el piment�n durante 4 minutos y volcamos las espinacas, salteamos unos minutos y salpimentamos, cocinamos las espinacas durante 6 � 7 minutos y reservamos. Para emplatar, utilizaremos un molde circular en el que primero pondremos una loncha de queso, encima una parte de las berenjenas, luego otra loncha de queso, echamos las espinacas, desmoldamos y coronamos con una cu�a del mismo queso, llevar el plato al microondas y ponerlo a media potencia (600w.) durante unos minutos para que funda el queso.",
					EnumTipoPlato.Principal, verdura);
			Plato pollocrocanteconavena = new Plato(
					"Pollo crocante con avena",
					"Sofr�e el ajo en aceite de oliva. Incorpora el br�coli picado y revuelve durante 3 minutos a fuego medio. A�ade la Avena, queso, sal y pimienta. Mezcla bien. Corta los filetes de pollo para que queden en forma mariposa. Tambi�n realiza otro corte para redondear un poco los extremos. Sazona con sal y pimienta. Divide el relleno en cinco partes iguales. Coloca una porci�n en cada corte de los filetes. Ci�rralos con 3 mondadientes por filete. Para apanarlos, mezcla en un recipiente Avena, semillas de s�samo, sal y pimienta. Sumerge los filetes en la clara de huevo y luego p�salos por la mezcla de Avena y s�samo cubriendo toda la superficie. Ll�valos al horno precalentado a 180�C en una fuente con aceite de oliva, durante aproximadamente 40 minutos. Volt�alos a la mitad del tiempo para que se doren y queden crujientes por ambos lados.",
					EnumTipoPlato.Principal, tagpollo);
			Plato risottoconhongos = new Plato(
					"Risotto con hongos",
					"Picar la cebolla en brunoise, tiene que quedar del tama�o del grano de arroz. Colocar en una sart�n el aceite de oliva. Saltear la cebolla cortada. Agregar a la cebolla el arroz, sellar los granos hasta que cambien de color, desglazar con el vino y condimentar. Incorporar de a poco el fondo de vegetales. Cuando falten cinco minutos para terminar la cocci�n del arroz, agregar los hongos frescos fileteados. Terminar montando con manteca y queso provolone rallado.",
					EnumTipoPlato.Principal, verdura);
			Plato rollosdepescadoyespinaca = new Plato(
					"Rollos de pescado y espinaca",
					"En un recipiente colocamos los filetes de pescado, agregamos el jugo de lim�n, la mostaza, sal, pimienta y el ajo bien picadito. Revolvemos bien todo y dejamos macerar durante 10 minutos. Picamos la espinaca bien chiquita, le agregamos la ricotta, sal, pimienta, nuez moscada y las dos cucharadas de aceite. Revolvemos bien para unir todo. Tomamos de a uno los filetes y como se ve en la foto, le colocamos el relleno enrollando y sujetando con dos escarbadientes para que no se abran. En una sart�n o cacerola colocamos un chorrito de aceite y ponemos los rollitos. Cocinamos durante 15 minutos gir�ndolos cada tanto, para que se doren de todos lados. Si hacen mucha cantidad lo pueden colocar en una fuente y llevar al horno cocin�ndolos durante 20 minutos. Para la salsa colocamos en una cacerolita la crema y el caldo y calentamos hasta disolver todo. Si se quiere una salsa m�s liviana se le puede agregar leche. Con esta preparaci�n cubrimos los rollitos y a la mesa.",
					EnumTipoPlato.Principal, pescado);
			Plato pollogrilleallimon = new Plato(
					"Pollo grille al lim�n",
					"En una bolsa con cierre herm�tico poner las pechugas de pollo, menta, ajo, jugo y ralladura de lim�n;  dejar marinar en el refrigerador por 8 horas. Calentar un sart�n para grillar o una parrilla a fuego alto y aceitar con una brocha. Estilar las pechugas de pollo y reservar la marinada; grillar 4-5 min. o hasta que la superficie de las pechugas est�n bien marcadas. Darlas vuelta y grillar por el otro lado, rociando constantemente con el l�quido de la marinada reservada hasta que est�n doradas y cocidas. Sazonar con sal y pimienta. Retirar del fuego y servir de inmediato acompa�ado de papas asadas o verduras salteadas.",
					EnumTipoPlato.Principal, tagpollo);
			Plato ensaladadeverdurasgrilladas = new Plato(
					"Ensalada de verduras grilladas",
					"Lavar y secar bien las hojas verdes. Disponerlas sobre la base de los platos. Cortar bastones largos de zucchini y berenjena y grillarlos con sal, pimienta y aceite. Reservar calientes. Cortar los tomates cherry a la mitad. Cortar cuadrados de pan y tostar en el horno. Vinagreta: Licuar el tomate trozado con el vinagre, los condimentos y el aceite. Monatje: Servir las verduras sobre las hojas verdes. Decorar con los cherry, los pancitos tostados y la salsa.",
					EnumTipoPlato.Ensalada, verdura);
			Plato pescadoconaceitunas = new Plato(
					"Pescado con aceitunas",
					"Calienta el aceite de oliva en una cacerola amplia y sofr�e el ajo y la cebolla hasta que se vean transparentes. Sazona el pescado con sal e incorp�ralo a la mezcla anterior; cocina durante un par de minutos y a�ade el jitomate, aceitunas, perejil y alcaparras. Revuelve con cuidado, tapa y cocina unos minutos m�s, hasta que el pescado se haya cocido.",
					EnumTipoPlato.Principal, pescado);
			Plato fideosalhuevoconmanteca = new Plato(
					"Fideos al Huevo con manteca",
					"En una fuente grande se distribuye la harina y la sal. Se hace un hoyo en el centro y se agregan los huevos. Se toma la masa con las manos, agregando la cucharada de aceite en el proceso. Cuando se tiene una masa unida se amasa sobre la mesada no menos de 10 minutos (paso vital) hasta que la masa quede uniforme y con cierta elasticidad. Se forma un bollo y se deja reposar por lo menos una media hora tap�ndolo con un repasador seco. Luego se divide en 5 o 6 trozos y se pasa por la m�quina de pastas, reduciendo en un punto el espesor en cada pasada. En nuestro caso, los rodillos tienen 7 espesores: el 6 lo utilizamos para pasta rellena, el 5 para los fideos anchos y el 4 para los fideos finos como los de esta foto. Es muy importante el paso por el primer nivel (el m�s grueso). Aqu� paso la pasta de 6 a 8 veces, doblando en dos cada vez, hasta obtener una tira del ancho de la procesadora. Los siguientes pasos se realizan con esta base, espolvoreando con abundante harina y pasando una sola vez por cada espesor. Se van estirando los fideos cortados en una mesa o tabla grande, sobre un papel blanco de envolver y espolvoreados una vez m�s con harina. En esta foto puede observarse una producci�n de �fettuccine� con algunos �finos� para Cecilia, por supuesto. Si se dispone de una parrilla o rack de madera como la mostrada se cuelgan los fideos cubiertos con un repasador h�medo hasta el momento de hervirlos en abundante agua.",
					EnumTipoPlato.Principal, pasta);
			Plato manzanaasada = new Plato(
					"Manzana asada",
					"Con la ayuda de un cuchillo de punta afilada, extrae, con mucho cuidado, el coraz�n de las manzanas. Luego llena los huecos con az�car, un poquito de co�ac y las almendras, si es que decides agregarle, picadas bien finitas. Ahora coloca las manzanas en una fuente para horno, pero previamente �ntala con manteca. Preparado todo esto, a��dele un chorrito de agua y p�nchalas ligeramente con un tenedor para que no revienten, �no querr�s tener un desastre dentro de tu horno! A continuaci�n col�cale la tapa de las manzanas que cortaste para poder rellenarlas. Encima de ellas, pon una cucharada de az�car, que una vez cocida quedara dorada, mejorando el aspecto y el sabor. Finalmente d�jalas al horno, moderado, unos treinta minutos y ya tendr�s tus manzanas preparadas para disfrutarlas. Como veras es muy sencillo e hacer y no lleva mas que unos minutos.",
					EnumTipoPlato.Postre, null);
			Plato raviolesdejamonyricotta = new Plato(
					"Ravioles de jam�n y ricotta",
					"Masa. Colocar la harina junto con la sal, sobre la mesa de trabajo. Hacer un hoyo en el centro y poner las yemas, el huevo, el aceite y algo de agua. Mezclar los ingredientes con las puntas de llos dedos e ir tomando la harina de a peque�as porciones hasta integrar toda la harina, agreg�ndole m�s cantidad de agua de ser necesario para terminar de ligar todo. El agua que necesite la masa, se agregar� de a cucharadas para que la masa no se tiernice demasiado por exceso de humedad. Su consistencia debe ser blanda pero no demasiado. Amasar durante 12 minutos aproximadamente o hasta lograr una masa el�stica, que no se pegue en las manos ni en la mesa. Tomar el bollo y colocarlo en una bolsa pl�stica y dejarlo a temperatura ambiente durante 20 a 30 minutos, para que repose. Pasado ese tiempo, sacar la masa de la bolsa pl�stica y apoyarla sobre la mesa enharinada. Dvidirla en varias partes para que con poco volumen de masa nos resulte m�s f�cil estirarla con el palote. Primero aplanarla con las manos y luego comenzar a estirarla siempre partiendo del centro. Estirar hacia arriba y luego hacia abajo y hacia los costados d�ndole forma rectangular. Les recordamos nuevamente que la masa se estira apoyando el palote sobre la mitad de la masa y haci�ndolo girar desde all� hacia el borde superior. Lo mismo se realiza para el borde inferior. Esto permite ir quebrando el gluten y llegar a los bordes sin que estos retrocedan o se encogan. Continuar estirando hasta que la masa est� fina pero no en exceso, aproximadamente de 1mm de espesor. Espolvorear con un poco de harina y cubrirla con un pa�o para que no se seque. Continuar haciendo lo mismo con el resto de la masa. agregar un poco de caldo y continuar la cocci�n a fuego lento durante 15 minutos m�s con la cacerola destapada o hasta que la salsa tome consistencia.",
					EnumTipoPlato.Principal, pasta);
			Plato tartadezapallitos = new Plato(
					"Tarta de zapallitos",
					"Cortar la cebolla en rodajas finas. Cortar el aji en tiras. Cortar los zapallitos en rodajas y luego en cuadraditos de 2 cm. mas o menos. Saltear la cebolla, el aji y los zapallitos en una sart�n utilizando � parte de manteca y � de aceite. Batir ligeramente los huevos. Mezclar los huevos con la crema, el queso crema y el salteado de cebolla aj� y zapallitos. Agregar el queso rallado y salpimentar nuevamente de ser necesario. Colocar el disco de masa en una tartera. Rellenar con la mezcla de zapallitos. Llevar a horno moderado hasta que la superficie est� dorada, unos 40 minutos. Retirar y servir tibia o fr�a.",
					EnumTipoPlato.Principal, verdura);
			Plato platoBanana = new Plato("Banana", "", EnumTipoPlato.Postre,
					null);
			Plato platoManzana = new Plato("Manzana", "", EnumTipoPlato.Postre,
					null);
			Plato puredepapa = new Plato(
					"Pure de papa",
					"Para hacer el pure de papa siempre es mejor hervir las papas con la cascara, previo a eso siempre hay que lavarlas (mas si no son papas blancas y tienen mucha tierra). Debemos preparar el agua con sal y colocar alli las papas, luego de media hora y dependiendo del tama�o de las mismas podemos verificas si estas listas pinchandolas con un cuchillo (si entra con facilidad es que ya estan listas). Una vez que termina la cocci�n de nuestras papas, lo que haremos es ponerlas en una fuente de agua bien fr��a y les quitaremos la c�scara. Cuando las tenemos peladas, tendremos 2 opciones o usar el pisa papa tradicional o recurrir a la mini pimer (si usamos la mini pimer deberemos cortar las papas en trozos previamente). Una vez que obtenemos el pur� de papa, lo condimentaremos con nuez moscada, manteca, leche o crema de leche, pimienta y si fuera necesario con una pizca de sal, lo mezclamos y ya esta listo para servir.",
					EnumTipoPlato.Ensalada, null);
			Plato puredezapallo = new Plato(
					"Pure de zapallo",
					"Muchas veces a la hora de poner a hervir el zapallo, nos damos cuenta que sacarle la c�scara resulta una molestia, por lo que si se lava bien, el zapallo puede hervirse con c�scara y sacarsela una vez cocido es muy sencillo. Es importante hervir el zapallo con un poco de sal. Durante la coccion se puede verificar si esta listo pinchandolo, siempre depende del tama�o de los trozos de zapallo. Para condimentarlo se le puede a�adir aceite de oliva, pimienta, una pizca de sal y una pizca de az�car para realzarle el sabor.",
					EnumTipoPlato.Ensalada, null);
			Plato duraznoenalmibar = new Plato(
					"Durazno en almibar",
					"Lavar los duraznos, secarlos, ponerlos en una cacerola, cubrirlos con agua y agregar azucar a gusto hasta que el agua tome el sabor que se prefiera. Agregar la chaucha de vainilla o la esencia a gusto. Cocinar hasta que los duraznos esten tiernos, pero firmes. Retirar del fuego, pelarlos con cuidado, quitar los carozos. Colocar los carozos y la piel de los duraznos en la cacerola donde estaba el agua y continuar la coccion. Cuando se obtiene un almibar semidenso, colar y reservar. Limpiar frascos de vidrio con alcohol fino,dejar unos minutos hasta que se evapore el olor a alcohol, acomodar los duraznos y llenar los frascos con el almibar caliente. Dejar enfriar y cerrar los frascos hermeticamente. Conservar en la heladera.",
					EnumTipoPlato.Postre, null);

			/***********************
			 * 
			 * 
			 * Creacion de ItemIngrediente para los Platos
			 * 
			 * 
			 **************************/

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

			/*
			 * 
			 * Agregado de las Restricciones Y persistencia de los platos
			 */

			cazuelacampestre.setRestricciones(listaRestricciones1);
			s.save(cazuelacampestre);
			s.flush();

			carnealvapor.setRestricciones(listaRestricciones2);
			s.save(carnealvapor);
			s.flush();

			s.save(goulashHungaro);
			s.flush();

			medallonDeLomoEnCrouteDeHierbas
					.setRestricciones(listaRestricciones4);
			s.save(medallonDeLomoEnCrouteDeHierbas);
			s.flush();

			s.save(guisodeternera);
			s.flush();

			lomodecerdoalhornoconcebollitas
					.setRestricciones(listaRestricciones1);
			s.save(lomodecerdoalhornoconcebollitas);
			s.flush();

			tortilladeespinaca.setRestricciones(listaRestricciones3);
			s.save(tortilladeespinaca);
			s.flush();

			s.save(platoArvejas);
			s.flush();

			polloconsalsadechampinones.setRestricciones(listaRestricciones4);
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

			fideosalhuevoconmanteca.setRestricciones(listaRestricciones2);
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

			// Creaci�n de menus

			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

			Menu menu1 = creaMenu(cazuelacampestre, platoArvejas,
					duraznoenalmibar, pescado, df.parse("2014/01/01"));

			s.save(menu1);
			s.flush();

			Menu menu2 = creaMenu(carnealvapor, platoArvejas, platoBanana, carne,
					df.parse("2014/01/01"));
			s.save(menu2);
			s.flush();

			Menu menu3 = creaMenu(tortilladeespinaca, platoArvejas,
					platoManzana, verdura, df.parse("2014/01/01"));
			s.save(menu3);
			s.flush();

			Menu menu4 = creaMenu(polloconsalsadechampinones, platoArvejas,
					platoManzana, tagpollo, df.parse("2014/01/01"));
			s.save(menu4);
			s.flush();

			Menu menu5 = creaMenu(lomodecerdoalhornoconcebollitas,
					puredezapallo, platoManzana, cerdo, df.parse("2014/01/01"));
			s.save(menu5);
			s.flush();

			Menu menu6 = creaMenu(guisodeternera, platoArvejas, platoBanana,
					carne, df.parse("2014/01/01"));
			s.save(menu6);
			s.flush();

			Menu menu7 = creaMenu(medallonDeLomoEnCrouteDeHierbas,
					puredepapa, platoBanana, carne, df.parse("2012/01/01"));
			s.save(menu7);
			s.flush();

			Menu menu8 = creaMenu(fideosalhuevoconmanteca, platoArvejas,
					duraznoenalmibar, pasta, df.parse("2014/02/01"));
			s.save(menu8);
			s.flush();

			Menu menu9 = creaMenu(raviolesdejamonyricotta, platoArvejas,
					duraznoenalmibar, pasta, df.parse("2014/01/01"));
			s.save(menu9);
			s.flush();

			Menu menu10 = creaMenu(pescadoensalsadeaji, platoArvejas,
					duraznoenalmibar, pescado, df.parse("2012/01/01"));
			s.save(menu10);
			s.flush();

			Menu menu11 = creaMenu(pasteldechoclo, platoArvejas,
					duraznoenalmibar, verdura, df.parse("2013/01/01"));
			s.save(menu11);
			s.flush();

			Menu menu12 = creaMenu(pollocrocanteconavena, platoArvejas,
					duraznoenalmibar, tagpollo, df.parse("2012/01/01"));
			s.save(menu12);
			s.flush();

			Menu menu13 = creaMenu(rollosdepescadoyespinaca, platoArvejas,
					duraznoenalmibar, pescado, df.parse("2013/10/01"));
			s.save(menu13);
			s.flush();

			// transac.commit();
		} catch (Exception e) {
			// transac.rollback();
			e.printStackTrace();
			System.out.println("No se pudo dar de alto los resgistros");
		}

	}

	private static Menu creaMenu(Plato cazuelacampestre, Plato platoArvejas,
			Plato duraznoenalmibar, Tag pescado, Date fecha) {

		List<Plato> platos = new ArrayList<Plato>();

		Menu menu = new Menu();
		menu.setCalorias(1000);
		menu.setEstado(EnumEstado.ACTIVO);

		platos.add(cazuelacampestre);
		platos.add(platoArvejas);
		platos.add(duraznoenalmibar);
		menu.setPlatos(platos);
		menu.setTag(pescado);
		menu.setUltimoUso(fecha);

		return menu;
	}
}
