package persistencia;

import java.util.ArrayList;

import modelo.ItemOrdenDeCompra;
import modelo.OrdenDeCompra;

import org.hibernate.Session;

import utilidades.GlobalsVars;
import views.ItemOrdenDeCompraVO;
import views.OrdenDeCompraVO;

public class OrdenDeCompraDAO {
	private static Session s = GlobalsVars.HIBERATE_SESSION;

	public static ArrayList<OrdenDeCompraVO> getOrdenesDeCompraVO() {
		ArrayList<OrdenDeCompra> ods = (ArrayList<OrdenDeCompra>) s
				.createQuery("From OrdenDeCompra").list();
		ArrayList<OrdenDeCompraVO> odsVO = new ArrayList<OrdenDeCompraVO>();
		for (OrdenDeCompra od : ods) {
			OrdenDeCompraVO odvo = new OrdenDeCompraVO(od);
			odsVO.add(odvo);
		}
		return odsVO;
	}

	public static void guardarOC(OrdenDeCompra oc) {
		s.save(oc);
		s.flush();
	}

	public static ArrayList<ItemOrdenDeCompraVO> getItemsOrdenCompraVO(String idOc) {
		ArrayList<ItemOrdenDeCompra> list = (ArrayList<ItemOrdenDeCompra>) s
				.createQuery("Select o.items From OrdenDeCompra o where o.idOrdenDeCompra =  "+idOc).list();
		ArrayList<ItemOrdenDeCompraVO> listVos = new ArrayList<ItemOrdenDeCompraVO>();
		for (ItemOrdenDeCompra i : list) {
			ItemOrdenDeCompraVO iocVO = new ItemOrdenDeCompraVO(i) ;
			listVos.add(iocVO);
			
		}
		return listVos;
	}
}
