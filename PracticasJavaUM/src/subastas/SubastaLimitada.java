package subastas;

public class SubastaLimitada extends Subasta {
	private final int numeroMaximoPujas;

	public SubastaLimitada(String producto, Usuario propietario, int numeroMaximoPujas) {
		super(producto, propietario);
		this.numeroMaximoPujas = numeroMaximoPujas;
	}

	public int getNumeroPujasPendientes() {
		return numeroMaximoPujas - listaPujas.size();
	}

	@Override
	public boolean pujar(Usuario pujador, double cantidad) {
		if (super.pujar(pujador, cantidad) && listaPujas.size() <= numeroMaximoPujas) {
			return super.ejecutar();
		} 
		return false;
	}

	@Override
	public boolean pujar(Usuario pujador) {
		if (super.pujar(pujador)) {
			if (this.listaPujas.size() == numeroMaximoPujas) {
				super.ejecutar();
			}
			return true;
		} 
		return false;
	}

}
