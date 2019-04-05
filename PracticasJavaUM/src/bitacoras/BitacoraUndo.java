package bitacoras;

public class BitacoraUndo extends Bitacora {

	public BitacoraUndo(String identificador) {
		super(identificador);
	}

	public boolean deshacer() {
		if (numeroEntradaRegistradas == 0) {
			return false;
		}
		this.getListaEntradas().removeLast();
		this.numeroEntradaRegistradas--;
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
