package viajes.dao;

import java.util.List;

import viajes.model.PRO;

public interface PRODAO {
	
	public void createPRO(String nombre, String superior);
	
	public PRO getPro(String nombre);
	public List<PRO> getSuperior(String superior);
	
	public void setNombre(PRO pro, String nombre);
	public void setSuperior(PRO pro, String superior);

}
