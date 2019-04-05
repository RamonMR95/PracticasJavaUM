package subastas;

import java.util.LinkedList;

public class Usuario {
	/* Atributos de la clase Usuario */
	private final String nombre;
	private double credito;
	private LinkedList<Subasta> subastas;

	/* Constructores de la clase Usuario */

	public Usuario(String nombre, double credito) {
		this.nombre = nombre;
		this.credito = credito;
		this.subastas = new LinkedList<Subasta>();
	}

	public Usuario(String nombre) {
		this.nombre = nombre;
		this.credito = 0;
		this.subastas = new LinkedList<Subasta>();
	}

	/* Metodos get */
	public String getNombre() {
		return nombre;
	}

	public double getCredito() {
		return credito;
	}

	/* Funcionalidad de la clase */
	public void incrementarCredito(double cantidad) {
		credito += cantidad;
	}

	public void decrementarCredito(double cantidad) {
		credito -= cantidad;
	}

	public LinkedList<Subasta> getSubastas() {
		return subastas;
	}

	public void addSubasta(Subasta subasta) {
		subastas.add(subasta);
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", credito=" + credito + "]";
	}
}
