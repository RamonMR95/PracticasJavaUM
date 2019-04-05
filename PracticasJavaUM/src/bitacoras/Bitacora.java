package bitacoras;

import java.util.LinkedList;

public class Bitacora {

	private final String identificador;
	private LinkedList<Entrada> listaEntradas;
	public int numeroEntradaRegistradas;

	public Bitacora(String identificador) {
		this.identificador = identificador;
		this.listaEntradas = new LinkedList<Entrada>();
		this.numeroEntradaRegistradas = 0;
	}

	public Bitacora(Bitacora bitacora) {
		this.identificador = bitacora.identificador;
		this.listaEntradas = bitacora.listaEntradas;
		this.numeroEntradaRegistradas = bitacora.numeroEntradaRegistradas;
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
		if (listaEntradas.add(entrada)) {
			this.numeroEntradaRegistradas++;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Bitacora [identificador=" + identificador + ", listaEntradas=" + listaEntradas
				+ ", numeroEntradaRegistradas=" + numeroEntradaRegistradas + "]";
	}

	@Override
	public Bitacora clone() {
		return new Bitacora(this);
	}
}
