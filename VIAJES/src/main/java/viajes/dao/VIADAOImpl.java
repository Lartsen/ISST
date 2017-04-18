package viajes.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import viajes.model.PRO;
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
		
		PRODAO dao2 = PRODAOImpl.getInstancia();
		List<VIA> lista1 = ofy().load().type(VIA.class).list();
		List<VIA> lista2 = new ArrayList<VIA>();
		
		for(VIA via: lista1){
			List<PRO> lista3 = dao2.getSuperior(sup);
			for(PRO pro: lista3){
				if(via.getProyecto().equals(pro.getNombre())){
					lista2.add(via);
				}
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
	public List<VIA> getVIAProyecto(String proyecto) {
		List<VIA> lista1 = ofy().load().type(VIA.class).list();
		List<VIA> lista2 = new ArrayList<VIA>();
		
		for(VIA via: lista1){
			String pro = via.getProyecto();
			
			if(proyecto.equals(pro)) {
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
	public void updateVIA(VIA via) {
		ofy().save().entity(via).now();
	}
	
	
	@Override
	public void deleteVIA(VIA via) {
		ofy().delete().entity(via).now();
	}

}
