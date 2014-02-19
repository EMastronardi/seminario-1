package persistencia;

import java.util.List;

import modelo.Cliente;
import modelo.ItemMenu;

import org.hibernate.Session;

import utilidades.GlobalsVars;

public class ItemMenuDAO {
	private static Session s = GlobalsVars.HIBERATE_SESSION;
	public static List<Cliente> getClientesByItemId(int idItemMenu){
		
		ItemMenu item = (ItemMenu) s.createQuery("from ItemMenu itm where itm.idItemMenu = "+idItemMenu).uniqueResult();	
		if(item != null){
			return item.getClientes();
		}else{
			return null;
		}
		
	}
}
