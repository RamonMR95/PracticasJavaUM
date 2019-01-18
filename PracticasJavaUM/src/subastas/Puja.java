package subastas;

public class Puja {
	/* Atributos de la clase Puja */
	private final Usuario pujador;
	private final double cantidadPuja;

	/* Constructor de la clase */
	public Puja(Usuario pujador, double cantidadPuja) {
		this.pujador = pujador;
		this.cantidadPuja = cantidadPuja;
	}

	/* Metodos get */
	public Usuario getPujador() {
		return pujador;
	}

	public double getCantidadPuja() {
		return cantidadPuja;
	}

	@Override
	public String toString() {
		return "Puja [pujador=" + pujador + ", cantidadPuja=" + cantidadPuja + "]";
	}
	
}
