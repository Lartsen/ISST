package viajes.dao;

import java.util.List;
import viajes.model.USU;

public interface USUDAO {
	
	public void createUSUDAO(String usuario, String password, int rol, String superior);
	
	public USU getUSU(String usuario);
	public List<USU> getRol(int rol);
	public List<USU> getUsuarios();
	
	public void setUSU(USU usu);
}
