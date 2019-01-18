package bitacoras;

import java.util.LinkedList;

public class Bitacora {

	private final String identificador;
	private LinkedList<Entrada> listaEntradas;
	private int numeroEntradaRegistradas;

	public Bitacora(String identificador) {
		this.identificador = identificador;
		this.listaEntradas = new LinkedList<Entrada>();
		this.numeroEntradaRegistradas = 0;
	}

	public String getIdentificador() {
		return identificador;
	}

	public LinkedList<Entrada> getListaEntradas() {
		return listaEntradas;
	}

	public int getNumeroEntradaRegistradas() {
		return numeroEntradaRegistradas;
	}

	public boolean registroEntradas(String suceso) {
		Entrada entrada = new Entrada(suceso);
		return listaEntradas.add(entrada);
	}

	@Override
	public String toString() {
		return "Bitacora [identificador=" + identificador + ", listaEntradas=" + listaEntradas
				+ ", numeroEntradaRegistradas=" + numeroEntradaRegistradas + "]";
	}

}
