package viajes.dao;

import java.util.Date;
import java.util.List;

import viajes.model.VIA;

public interface VIADAO {
	
	public void createVIA(String destino, String solicitanteID, String proyecto, Date inicio, Date fin, String descripcion);
	
	public List<VIA> getVIASuperior(String sup);
	public List<VIA> getVIAEmpleado(String emp);
	public List<VIA> getVIAProyecto(String proyecto);
	public VIA getVIAID(String id);
	
	public void setEstado(VIA via, int estado);
	public void updateVIA(VIA via);
	public void deleteVIA(VIA via);
}
