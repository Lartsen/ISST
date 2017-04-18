package viajes.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class REMB implements Serializable {
	private static final long serialVersionUID = 1L;

	public REMB() {
	}
	
	@Index
	private String solicitanteID;
	@Index
	private String destino;
	@Index
	private String proyecto;
	@Id
	private String ID;
	@Index
	private int cantidad;
	@Index
	private int estado;
	@Index
	private String document;
	
	public REMB(String destino, String solicitanteID, String proyecto, int cantidad){
		this.ID = solicitanteID+"&"+destino+"&"+proyecto;
		this.solicitanteID = solicitanteID;
		this.destino = destino;
		this.proyecto = proyecto;
		this.cantidad = cantidad;
		this.estado = 0;
	}
	
	public String getDocument(){
		return this.document;
	}
	
	public String getSolicitanteID(){
		return this.solicitanteID;
	}
	
	public String getDestino(){
		return this.destino;
	}
	
	public String getProyecto(){
		return this.proyecto;
	}
	
	public String getID(){
		return this.ID;
	}
	
	public int getCantidad(){
		return this.cantidad;
	}
	
	public int getEstado(){
		return this.estado;
	}
	
	public void setEstado(int estado){
		this.estado = estado;
	}
	
	public void setDocument(String document){
		this.document = document;
	}
	
}
