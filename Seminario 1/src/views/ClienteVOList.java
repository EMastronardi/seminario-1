package views;

import java.util.ArrayList;
import java.util.List;


public class ClienteVOList {
	private List<ClienteVO> clientes;
	
	public ClienteVOList(){
		clientes = new ArrayList<ClienteVO>(); 
	}
	public void add(ClienteVO cliente){
		clientes.add(cliente);
	}
}
