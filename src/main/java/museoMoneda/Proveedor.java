package museoMoneda;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proveedor {
	
	@Id
	private String cif;
	private String nombre;
	private String direccionPostal;
	private String email;
	private int tlf;
	
	public Proveedor() {
		
	}
	public Proveedor(String cif, String nombre, String direccionPostal, String email, int tlf) {
		this.cif = cif;
		this.nombre = nombre;
		this.direccionPostal = direccionPostal;
		this.email = email;
		this.tlf = tlf;
	}
	

	public void setCif(String cif) {
		this.cif = cif;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTlf(int tlf) {
		this.tlf = tlf;
	}
	public String getCif() {
		return cif;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDireccionPostal() {
		return direccionPostal;
	}
	public String getEmail() {
		return email;
	}
	public int getTlf() {
		return tlf;
	}

}
