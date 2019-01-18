package subastas;

public class SubastaMinima extends Subasta {
	private double cantidadMinimaPuja;

	public SubastaMinima(String producto, Usuario propietario, double cantidadMinimaPuja) {
		super(producto, propietario);
		this.cantidadMinimaPuja = cantidadMinimaPuja;
	}

	public double getCantidadMinimaPuja() {
		return cantidadMinimaPuja;
	}

	public void setCantidadMinimaPuja(double cantidadMinimaPuja) {
		this.cantidadMinimaPuja = cantidadMinimaPuja;
	}

	@Override
	public boolean ejecutar() {
		if (this.getPujaMayor().getCantidadPuja() >= this.cantidadMinimaPuja){
			return super.ejecutar();
		}
		return false;
	}
	
	public void cerrarSubasta() {
		this.isCerrada = true;
	}
}
