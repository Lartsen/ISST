package viajes.dao;

import java.util.List;

import viajes.model.REMB;

public interface REMBDAO {
	
	public void createREMB(String destino, String solicitanteID, String proyecto, int cantidad);
	
	public List<REMB> getREMBSuperior(String sup);
	public List<REMB> getREMBEmpleado(String emp);
	public List<REMB> getAllREMB();
	public REMB getREMBID(String id);
	
	public void setEstado(REMB remb, int estado);
	public void deleteRemb(REMB remb);
}
