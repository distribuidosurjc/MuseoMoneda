package museoMoneda;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Moneda {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer modelo;
	
//	private String modelo;
	private int valor;
	private String divisa;
	private double diametro;
	private double peso;
	private String composicion;
	private String descripcion;

	public Moneda() {
		
	}

	public Moneda(int valor, String divisa, double diametro, double peso, String composicion, String descripcion) {
		//this.modelo = modelo;
		this.valor = valor;
		this.divisa = divisa;
		this.diametro = diametro;
		this.peso = peso;
		this.composicion = composicion;
		this.descripcion = descripcion;
	}

	public int getModelo() {
		return modelo;
	}

/*	public void setModelo(String modelo) {
		this.modelo = modelo;
	}*/

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getDivisa() {
		return divisa;
	}

	public void setDivisa(String divisa) {
		this.divisa = divisa;
	}

/*	public long getId() {
		return id;
	}
*/

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getComposicion() {
		return composicion;
	}

	public void setComposicion(String composicion) {
		this.composicion = composicion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
