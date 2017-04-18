package viajes.model;

import java.io.Serializable;
import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class VIA implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String ID;
	@Index
	private String destino;
	@Index
	private String solicitanteID;
	@Index
	private String proyecto;
	@Index
	private Date inicio;
	@Index
	private Date fin;
	@Index
	private String descripcion;
	@Index
	private int estado;
	@Index
	private String document;
	
	public VIA(String destino, String solicitanteID, String proyecto, Date inicio, Date fin, String descripcion){
		this.ID = solicitanteID+"&"+destino+"&"+proyecto;
		this.solicitanteID = solicitanteID;
		this.destino = destino;
		this.proyecto = proyecto;
		this.inicio = inicio;
		this.fin = fin;
		this.descripcion = descripcion;
		this.estado = 0;
	}

	public VIA() {
	}
	
	public String getDocument(){
		return this.document;
	}
	
	public String getID(){
		return this.ID;
	}
	
	public String getDestino(){
		return this.destino;
	}
	
	public int getEstado(){
		return this.estado;
	}
	
	public String getSolicitanteID(){
		return this.solicitanteID;
	}
	
	public String getProyecto(){
		return this.proyecto;
	}
	
	public Date getInicio(){
		return this.inicio;
	}
	
	public Date getFin(){
		return this.fin;
	}
	
	public String getDescripcion(){
		return this.descripcion;
	}
	
	public void setEstado(int estado){
		this.estado = estado;
	}
	
	public void setDocument(String document){
		this.document = document;
	}
}
