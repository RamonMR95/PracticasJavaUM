package geometria;

public class Circulo {
	/* Atributos de la clase Circulo */
	private Punto centro;
	private int radio;
	private static final int RADIO_DEFAULT = 5;
	private static final Punto ORIGEN = new Punto();

	/* Constructores de la clase */
	public Circulo(Punto Centro, int radio) {
		this.centro = new Punto(Centro);
		this.radio = radio;
	}

	public Circulo() {
		this.centro = new Punto(ORIGEN);
		this.radio = RADIO_DEFAULT;
	}

	public Circulo(Circulo otro) {
		this.centro = otro.centro;
		this.radio = otro.radio;
	}

	/* Metodos get de la clase */
	public Punto getCentro() {
		return centro;
	}

	public int getRadio() {
		return radio;
	}

	/* Funcionalidad de la clase */
	public double getPerimetro() {
		return 2 * Math.PI * radio;
	}

	public void desplazar(int cantidadY, int cantidadX) {
		centro.desplazar(cantidadX, cantidadY);
	}

	public void desplazar(Punto CENTRO) {
		this.centro.setX(centro.getX());
		this.centro.setY(centro.getY());
	}

	public void escalar(double porcentaje) {
		radio = (int) (radio * (porcentaje / 100));
	}

	@Override
	public String toString() {
		return "Circulo [centro=" + centro + ", radio=" + radio + "]";
	}

}
