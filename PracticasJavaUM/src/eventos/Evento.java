package eventos;

import java.util.HashMap;

public abstract class Evento {
	private String nombreEvento;
	private double precioApuesta;
	private int numeroApuestas;
	private String apostador;
	private HashMap<String, Marcador> mapaApuestas = new HashMap<String, Marcador>();

	public Evento(String nombreEvento, double precioApuesta) {
		this.nombreEvento = nombreEvento;
		this.precioApuesta = precioApuesta;
		this.numeroApuestas = 0;

	}

	public String getNombreEvento() {
		return nombreEvento;
	}

	public double getPrecioApuesta() {
		return precioApuesta;
	}

	public int getNumeroApuestas() {
		return numeroApuestas;
	}

	public String getApostador() {
		return apostador;
	}

	public HashMap<String, Marcador> getMapaApuestas() {
		return mapaApuestas;
	}

	protected abstract boolean isPosibleApostar(Marcador marcador);

	public boolean apostar(String apostador, Marcador marcador) {
		if (isPosibleApostar(marcador)) {
			this.mapaApuestas.put(apostador, marcador);
			this.numeroApuestas++;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Evento [nombreEvento=" + nombreEvento + ", precioApuesta=" + precioApuesta + ", numeroApuestas="
				+ numeroApuestas + ", apostador=" + mapaApuestas.keySet() + ", marcador=" + mapaApuestas.values() + "]";
	}

}
