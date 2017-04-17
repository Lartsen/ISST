package viajes.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import viajes.model.VIA;

public class VIADAOImpl implements VIADAO {
	
	private static VIADAOImpl instancia;

	public VIADAOImpl() {
	}
	
	public static VIADAOImpl getInstancia() {
		if (instancia == null)
			instancia= new VIADAOImpl();
		return instancia;
	}
	
	@Override
	public void createVIA(String destino, String solicitanteID, String proyecto, Date inicio, Date fin,
			String descripcion) {
		VIA via = new VIA(destino, solicitanteID, proyecto, inicio, fin, descripcion);
		ofy().save().entity(via).now();
	}

	@Override
	public List<VIA> getVIASuperior(String sup) {
		
		USUDAO dao = USUDAOImpl.getInstancia();
		List<VIA> lista1 = ofy().load().type(VIA.class).list();
		List<VIA> lista2 = new ArrayList<VIA>();
		
		for(VIA via: lista1){
			String u = via.getSolicitanteID();
			String superior = dao.getUSU(u).getSuperior();
			
			if(superior.equals(sup)) {
				lista2.add(via);
			}
		}
		return lista2;
	}
	
	@Override
	public List<VIA> getVIAEmpleado(String emp) {
		List<VIA> lista1 = ofy().load().type(VIA.class).list();
		List<VIA> lista2 = new ArrayList<VIA>();
		
		for(VIA via: lista1){
			String empleado = via.getSolicitanteID();
			
			if(empleado.equals(emp)) {
				lista2.add(via);
			}
		}
		return lista2;
	}
	
	@Override
	public VIA getVIAID(String id) {
		List<VIA> lista1 = ofy().load().type(VIA.class).list();
		
		for(VIA via: lista1){
			String id2 = via.getID();
			
			if(id.equals(id2)) {
				return via;
			}
		}
		return null;
	}
	

	@Override
	public void setEstado(VIA via, int estado) {
		via.setEstado(estado);
		ofy().save().entity(via).now();
	}
	
	@Override
	public void deleteVIA(VIA via) {
		ofy().delete().entity(via).now();
	}

}
