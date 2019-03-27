package museoMoneda;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Moneda implements Comparable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int modelo;
	
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

	@Override
	public int compareTo(Object arg0) {
		Moneda m = (Moneda) arg0;
		
		
		return 0;
	}
/*
	public void actualizar(Moneda moneda) {
		this.valor = moneda.valor;
		this.divisa = moneda.divisa;
		this.diametro = moneda.diametro;
		this.peso = moneda.peso;
		this.composicion = moneda.composicion;
		this.descripcion = moneda.descripcion;
	}
*/	
	
	
}
