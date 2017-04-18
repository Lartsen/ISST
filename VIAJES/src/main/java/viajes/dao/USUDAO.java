package viajes.dao;

import java.util.List;
import viajes.model.USU;

public interface USUDAO {
	
	public void createUSU(String usuario, String password, int rol, String Correo);
	
	public USU getUSU(String usuario);
	public List<USU> getRol(int rol);
	public List<USU> getUsuarios();
	
	public void setUSU(USU usu);
}
