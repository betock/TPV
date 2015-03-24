package DTO;

public class Plato {
	
	private int numero;
	private String numeroCarta;
	private String nombre;
	private double precio;
	
	public Plato(int numero, String numeroCarta, String nombre, double precio) {
		super();
		this.numero = numero;
		this.numeroCarta = numeroCarta;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNumeroCarta() {
		return numeroCarta;
	}
	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
