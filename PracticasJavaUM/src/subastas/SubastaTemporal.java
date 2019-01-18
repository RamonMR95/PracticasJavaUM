package subastas;

public class SubastaTemporal extends Subasta {
	private double tiempoPujar;
	private double inicioContador;

	public SubastaTemporal(String producto, Usuario propietario, double tiempoPujar) {
		super(producto, propietario);
		this.tiempoPujar = tiempoPujar;
		inicioContador = System.currentTimeMillis();
	}

	public double getTiempoPujar() {
		return tiempoPujar;
	}

	public boolean pujar(Usuario pujador, double cantidad) {
		double ya = System.currentTimeMillis();

		if (super.pujar(pujador, cantidad) && (this.tiempoPujar > (ya - inicioContador))) {
			return ejecutar();
		} else {
			return false;
		}

	}

	@Override
	public boolean pujar(Usuario pujador) {
		double ya = System.currentTimeMillis();
		if (super.pujar(pujador) && (this.tiempoPujar > (ya - inicioContador))) {
			return ejecutar();
		} else {
			return false;
		}
	}

}
