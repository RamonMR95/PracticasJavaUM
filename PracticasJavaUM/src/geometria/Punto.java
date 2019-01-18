package geometria;

public class Punto {
	/* Atributos de la clase Punto */
	private int x;
	private int y;

	/* Constructores de la clase Punto */
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Punto() {
		this(0, 0);
	}

	public Punto(Punto otro) {
		this.x = otro.x;
		this.y = otro.y;
	}

	/* Metodos get&set */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/* Funcionalidad de la clase */
	public void desplazar(int cantidadX, int cantidadY) {
		x += cantidadX;
		y += cantidadY;
	}

	public void desplazar(Direccion direccion) {

		switch (direccion) {
		case ARRIBA:
			this.desplazar(0, 1);
			break;
		case ABAJO:
			this.desplazar(0, -1);
			break;
		case DERECHA:
			this.desplazar(1, 0);
			break;
		case IZQUIERDA:
			this.desplazar(-1, 0);
			break;
		}
	}

	public double distancia(Punto otro) {
		return Math.sqrt(Math.pow(x - otro.x, 2) + Math.pow(y - otro.y, 2));
	}

	public static Punto puntoMasAlejado(Punto... puntos) {
		Punto masLejano = null;
		Punto ORIGEN = new Punto();
		double mayorDistancia = 0;

		for (Punto punto : puntos) {
			double distanciaActual = ORIGEN.distancia(punto);

			if (distanciaActual > mayorDistancia) {
				masLejano = punto;
				mayorDistancia = distanciaActual;
			}
		}
		return masLejano;
	}

	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}

}
