package geometria;

public class Rectangulo {
	private int ladoX;
	private int ladoY;
	private Punto verticeII;

	public Rectangulo(Punto verticeII, int ladoX, int ladoY) {
		this.ladoX = ladoX;
		this.ladoY = ladoY;
		this.verticeII = new Punto(verticeII);
	}

	public Rectangulo(Punto verticeII, Punto verticeSD) {
		this(verticeII, verticeSD.getX() - verticeII.getX(), verticeSD.getY() - verticeII.getY());
	}

	public int getPerimetro() {
		return ladoX * 2 + ladoY * 2;
	}

	public Punto getVerticeII() {
		return verticeII;
	}

	public Punto getVerticeSI() {
		return new Punto(verticeII.getX(), verticeII.getY() + ladoY);
	}

	public Punto getVerticeSD() {
		return new Punto(verticeII.getX() + ladoX, verticeII.getY() + ladoY);
	}

	public Punto getVerticeID() {
		return new Punto(verticeII.getX() + ladoX, verticeII.getY());
	}


	public void desplazar(int cantidadX, int cantidadY) {
		verticeII.desplazar(cantidadX, cantidadY);
	}

	public void escalar(int porcentaje) {
		ladoX = ladoX * porcentaje / 100;
		ladoY = ladoY * porcentaje / 100;
	}

	@Override
	public String toString() {
		return "Rectangulo [ladoX=" + ladoX + ", ladoY=" + ladoY + ", getPerimetro()=" + getPerimetro()
				+ ", getVerticeII()=" + getVerticeII() + ", getVerticeSI()=" + getVerticeSI() + ", getVerticeSD()="
				+ getVerticeSD() + ", getVerticeID()=" + getVerticeID() + "]";
	}
	
}
