package views;

import java.util.ArrayList;
import java.util.List;


public class RestriccionVOList {
	private List<RestriccionVO> restricciones;
	
	public RestriccionVOList(){
		restricciones = new ArrayList<RestriccionVO>(); 
	}
	public void add(RestriccionVO restriccion){
		restricciones.add(restriccion);
	}
}
