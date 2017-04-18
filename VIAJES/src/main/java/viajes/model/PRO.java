package viajes.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class PRO implements Serializable {

	private static final long serialVersionUID = 1L;

	public PRO() {
	}
	@Id
	private String nombre;
	@Index
	private String superior;
	
	public PRO(String nombre, String superior){
		this.nombre = nombre;
		this.superior = superior;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getSuperior(){
		return this.superior;
	}
	
	public void setSuperior(String superior){
		this.superior = superior;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}

}
