package sesion12;

public class EventoLibre extends Evento {

	public EventoLibre(String nombreEvento, double precioApuesta) {
		super(nombreEvento, precioApuesta);

	}

	@Override
	protected boolean isPosibleApostar(Marcador marcador) {
		if (this.getMapaApuestas().containsValue(marcador)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
