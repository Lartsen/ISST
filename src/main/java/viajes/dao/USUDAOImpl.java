package viajes.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.googlecode.objectify.Key;

import viajes.model.USU;

public class USUDAOImpl implements USUDAO {
	
	private static USUDAOImpl instancia;

	public USUDAOImpl() {
	}
	
	public static USUDAOImpl getInstancia() {
		if (instancia == null)
			instancia= new USUDAOImpl();
		return instancia;
	}
	

	@Override
	public void createUSUDAO(String usuario, String password, int rol, String superior) {
		USU usu = new USU(usuario, password, rol, superior);
		ofy().save().entity(usu).now();
	}
	
	@Override
	public USU getUSU(String usuario){
		return ofy().load().type(USU.class).filterKey(Key.create(USU.class,usuario)).first().now();
	}
	
	@Override
	public List<USU> getRol(int rol){
		return ofy().load().type(USU.class).filter("rol", rol).list();
	}
	
	@Override
	public List<USU> getUsuarios(){
		return ofy().load().type(USU.class).list();
	}

	@Override
	public void setUSU(USU usu) {
		ofy().save().entity(usu).now();

	}
}
