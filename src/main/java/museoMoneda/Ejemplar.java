package museoMoneda;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ejemplar {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int año;
	private String ciudad;
	private Date fecha;
	private String estado;
	private int moneda;
	private String proveedor;

	public Ejemplar() {
		
	}
	
	public Ejemplar(int moneda, int año, String ciudad, Date fecha, String estado, String proveedor) {
			this.moneda = moneda;
			this.año = año;
			this.ciudad = ciudad;
			this.fecha = fecha;
			this.estado = estado;
			this.proveedor = proveedor;
	}
	
	public int getAño() {
			return año;
	}
	
	public void setAño(int año) {
			this.año= año;
	}
	
	public String getCiudad() {
			return ciudad;
	}
	
	public void setCiudad(String ciudad) {
			this.ciudad= ciudad;
	}
	
	public Date getFecha() {
			return fecha;
	}
	
	public void setFecha(Date fecha) {
			this.fecha= fecha;
	}
	
	public String getEstado() {
			return estado;
	}
	
	public void setEstado(String estado) {
			this.estado= estado;
	}
	
	

	public int getId() {
		return id;
	}

	public int getMoneda() {
		return moneda;
	}

	public void setMoneda(int moneda) {
		this.moneda = moneda;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * @param anotherString
	 * @return
	 * @see java.lang.String#compareTo(java.lang.String)
	 */
	public int compareTo(String anotherString) {
		return ciudad.compareTo(anotherString);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.Date#compareTo(java.util.Date)
	 */
	public int compareTo(java.util.Date arg0) {
		return fecha.compareTo(arg0);
	}
	


}