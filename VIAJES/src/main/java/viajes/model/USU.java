package viajes.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class USU implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String usuario;
	@Index
	private String password;
	@Index
	private int rol;
	@Index
	private String correo;
	
	public int getRol(){
		return this.rol;
	}
	
	public String getUsuario(){
		return this.usuario;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getCorreo(){
		return this.correo;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setUsuario(String usuario){
		this.usuario = usuario;
	}
	
	public void setRol(int rol){
		this.rol = rol;
	}
	
	public void setCorreo(String correo){
		this.correo = correo;
	}
	
	
	public USU(String usuario, String password, int rol, String correo) {
		this.usuario = usuario;
		this.password = password;
		this.rol = rol;
		this.correo = correo;
	}
	
	public USU(){
		
	}

}
