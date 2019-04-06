package sesion12;

import java.util.HashMap;

public abstract class Evento {
	public enum EstadoEvento {ABIERTO, CERRADO, FINALIZADO};
	private String nombreEvento;
	private double precioApuesta;
	private int numeroApuestas;
	private String apostador;
	private HashMap<String, Marcador> mapaApuestas = new HashMap<String, Marcador>();
	private Marcador resultado;
	private EstadoEvento estadoEvento;

	public Evento(String nombreEvento, double precioApuesta) {
		this.nombreEvento = nombreEvento;
		this.precioApuesta = precioApuesta;
		this.numeroApuestas = 0;
		this.resultado = new Marcador(0, 0);
		this.estadoEvento = EstadoEvento.ABIERTO;
	}
	
	public EstadoEvento getEstadoEvento() {
		return estadoEvento;
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

	
	public Marcador getResultado() {
		return resultado;
	}

	public void setResultado(Marcador resultado) {
		this.resultado = resultado;
	}

	protected abstract boolean isPosibleApostar(Marcador marcador);

	public boolean apostar(String apostador, Marcador marcador) {
		if (isPosibleApostar(marcador) && estadoEvento == EstadoEvento.ABIERTO) {
			this.mapaApuestas.put(apostador, marcador);
			this.numeroApuestas++;
			return true;
		}
		return false;
	}

	public void cerrarEvento() {
		this.estadoEvento = EstadoEvento.CERRADO;
	}
	
	@Override
	public String toString() {
		return "Evento [nombreEvento=" + nombreEvento + ", precioApuesta=" + precioApuesta + ", numeroApuestas="
				+ numeroApuestas + ", apostador=" + mapaApuestas.keySet() + ", marcador=" + mapaApuestas.values() + "]";
	}

}
