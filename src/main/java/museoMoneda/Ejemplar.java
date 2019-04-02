package museoMoneda;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Ejemplar {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int year;
	private String ciudad;
	private Date fecha;
	private String estado;
	@OneToOne
	@JoinColumn(name = "modelo")
	private Moneda moneda;
	@OneToOne
	@JoinColumn(name = "cif")
	private Proveedor proveedor;

	public Ejemplar() {
		
	}
	
	public Ejemplar(Moneda moneda, int year, String ciudad, Date fecha, String estado, Proveedor proveedor) {
			this.moneda = moneda;
			this.year = year;
			this.ciudad = ciudad;
			this.fecha = fecha;
			this.estado = estado;
			this.proveedor = proveedor;
	}
	
	public int getYear() {
			return year;
	}
	
	public void setYear(int year) {
			this.year= year;
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

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

}