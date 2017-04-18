package viajes.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;
import java.util.List;

import viajes.model.PRO;
import viajes.model.REMB;

public class REMBDAOImpl implements REMBDAO {
	
	private static REMBDAOImpl instancia;

	public REMBDAOImpl() {
	}
	
	public static REMBDAOImpl getInstancia() {
		if (instancia == null)
			instancia= new REMBDAOImpl();
		return instancia;
	}

	@Override
	public void createREMB(String destino, String solicitanteID, String proyecto, int cantidad) {
		REMB remb = new REMB(destino, solicitanteID, proyecto, cantidad);
		ofy().save().entity(remb).now();
	}

	@Override
	public List<REMB> getREMBSuperior(String sup) {
		PRODAO dao2 = PRODAOImpl.getInstancia();
		
		List<REMB> lista1 = ofy().load().type(REMB.class).list();
		List<REMB> lista2 = new ArrayList<REMB>();
		
		for(REMB remb: lista1){
			List<PRO> lista3 = dao2.getSuperior(sup);
			for(PRO pro: lista3){
				if(pro.getNombre().equals(remb.getProyecto())){
					lista2.add(remb);
				}
			}
			
		}
		return lista2;
	}

	@Override
	public List<REMB> getREMBEmpleado(String emp) {

		List<REMB> lista1 = ofy().load().type(REMB.class).list();
		List<REMB> lista2 = new ArrayList<REMB>();
		
		for(REMB remb: lista1){
			String empleado = remb.getSolicitanteID();
			
			if(empleado.equals(emp)) {
				lista2.add(remb);
			}
		}
		return lista2;
	}
	
	@Override
	public REMB getREMBID(String id) {

		List<REMB> lista1 = ofy().load().type(REMB.class).list();
		
		for(REMB remb: lista1){
			String id1 = remb.getID();
			
			if(id1.equals(id)) {
				return remb;
			}
		}
		return null;
	}
	
	@Override
	public List<REMB> getAllREMB(){
		List<REMB> lista1 = ofy().load().type(REMB.class).list();
		return lista1;
	}

	@Override
	public void setEstado(REMB remb, int estado) {
		remb.setEstado(estado);
		ofy().save().entity(remb).now();
	}
	
	@Override
	public void updateREMB(REMB remb) {
		ofy().save().entity(remb).now();
	}
	
	@Override
	public void deleteRemb(REMB remb) {
		ofy().delete().entity(remb).now();
	}

}
