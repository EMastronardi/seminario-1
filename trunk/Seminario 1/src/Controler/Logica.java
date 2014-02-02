package Controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import modelo.Cliente;
import modelo.Plan;
import modelo.Plato;
import modelo.Restriccion;
import persistencia.PlatosDAO;
import persistencia.RestriccionesDAO;

public class Logica {
	
	public Plan generarPlanSemanal(List<String> tags){
		//TODO armado del plan semanal con los planes diarios
		//Busco los platos que coinciden con los tags ordenados
		for (String tag : tags) {
			//Busco los platos que tienen ese tag
			List<Plato> platos = PlatosDAO.buscarPlatosPorTag(tag);
			Map<Restriccion,Integer> restriccionesPlatos = obtenerRestriccionesPlatos(platos);
			//List<Cliente> 
		}
		return null;
	}
	
	private Map<Restriccion, Integer> obtenerRestriccionesPlatos(
			List<Plato> platos) {
		// TODO Auto-generated method stub
		Map<Restriccion, Integer> mapaPlatos = new TreeMap<Restriccion, Integer>(); 
//		for (Plato plato : platos) {
//			if mapaPlatos.get(plato.getR)
//				mapaPlatos.put(key, value);
//		}
		return null;
	}
	
	private Map<Restriccion, Integer> obtenerRestriccionesClientes(List<Cliente> clientes){
		Map<Restriccion, Integer> mapaClientes = new TreeMap<Restriccion, Integer>();
		//Cargo todas las restricciones con 0 en la cuenta
		List<Restriccion> restricciones = RestriccionesDAO.obtenerRestricciones();
		for (Restriccion restriccion : restricciones) {
			mapaClientes.put(restriccion, 0);
		}
		for (Cliente cliente : clientes) {
			for (Restriccion r : cliente.getRestricciones()){
				mapaClientes.put(r, mapaClientes.get(r)+1);
			}
		}
		return mapaClientes;
	}

	public Plan generarPlanSemanal(){
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("carne");
		tags.add("pasta");
		tags.add("pollo");
		tags.add("cerdo");
		tags.add("verduras");
		return generarPlanSemanal(tags);
	}
}
