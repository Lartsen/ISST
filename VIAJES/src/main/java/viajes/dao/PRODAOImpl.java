package viajes.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Key;

import viajes.model.PRO;

public class PRODAOImpl implements PRODAO {
	
	private static PRODAOImpl instancia;

	public PRODAOImpl() {
	}
	
	public static PRODAOImpl getInstancia(){
		if (instancia == null)
			instancia= new PRODAOImpl();
		return instancia;
	}

	@Override
	public void createPRO(String nombre, String superior) {
		PRO pro = new PRO(nombre, superior);
		ofy().save().entity(pro).now();
	}

	@Override
	public PRO getPro(String nombre) {
		return ofy().load().type(PRO.class).filterKey(Key.create(PRO.class,nombre)).first().now();
	}

	@Override
	public List<PRO> getSuperior(String superior) {
		List<PRO> lista1 = ofy().load().type(PRO.class).list();
		List<PRO> lista2 = new ArrayList<PRO>();
		
		for(PRO pro: lista1){
			String sup = pro.getSuperior();
			if (superior.equals(sup)) {
				lista2.add(pro);
			}
		}
		return lista2;
	}

	@Override
	public void setNombre(PRO pro, String nombre) {
		pro.setNombre(nombre);
		ofy().save().entity(pro).now();
	}

	@Override
	public void setSuperior(PRO pro, String superior) {
		pro.setSuperior(superior);
		ofy().save().entity(pro).now();
	}

}
