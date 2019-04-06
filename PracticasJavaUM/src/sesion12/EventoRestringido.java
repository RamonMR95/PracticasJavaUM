package sesion12;

import java.util.HashSet;

public class EventoRestringido extends Evento {
	HashSet<Marcador> conjuntoOpciones = new HashSet<Marcador>();

	public EventoRestringido(String nombreEvento, double precioApuesta) {
		super(nombreEvento, precioApuesta);
	}

	public HashSet<Marcador> getConjuntoOpciones() {
		return conjuntoOpciones;
	}

	@Override
	protected boolean isPosibleApostar(Marcador marcador) {
		if (this.conjuntoOpciones.contains(marcador)) {
			return true;
		}
		return false;
	}

}
