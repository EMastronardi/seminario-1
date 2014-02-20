package utilidades;

import org.hibernate.Session;

import persistencia.HibernateUtil;

public class Tester {
	public static void main(String[] args){
		System.out.println("Carga de los datos de prueba");
		InitializeSystems.cargador();
	}
}
