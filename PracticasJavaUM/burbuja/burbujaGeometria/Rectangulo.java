package burbujaGeometria;

/**
 * Tipo que representa la figura geom�trica Rect�ngulo.
 * Un rect�ngulo se caracteriza por su cuatro v�rtices y 
 * el tama�o de sus lados.
 */
public class Rectangulo {
	private Punto verticeII;
	private int ladoX;
	private int ladoY;
	
	/**
	 * Constructor que inicializa un rect�ngulo a partir de su
	 * v�rtice inferior izquierdo y el tama�o de sus lados.
	 * @param verticeII punto que representa el v�rtice inferior izquierdo
	 * @param ladoX tama�o del lado en x
	 * @param ladoY tama�o del lado en y
	 */
	public Rectangulo(Punto verticeII, int ladoX, int ladoY) {
		//Nos quedamos con copia para evitar el problema del aliasing
		this.verticeII = new Punto(verticeII);
		this.ladoX = ladoX;
		this.ladoY = ladoY;
	}
	
	/**
	 * Constructor que inicializa un rect�ngulo a partir de los valores
	 * de los v�rtices inferior izquierdo y superior derecho.
	 * @param verticeII punto que representa el v�rtice inferior izquierdo
	 * @param verticeSD punto que representa el v�rtice superior derecho
	 */
	public Rectangulo(Punto verticeII, Punto verticeSD) {
		this(verticeII, verticeSD.getX() - verticeII.getX(), verticeSD.getY() - verticeII.getY());
	}

	/**
	 * M�todo de consulta de la propiedad del lado en x.
	 * @return tama�o del lado en x
	 */
	public int getLadoX() {
		return ladoX;
	}
	
	/**
	 * M�todo de consulta de la propiedad del lado en y.
	 * @return tama�o del lado en y
	 */
	public int getLadoY() {
		return ladoY;
	}
	
	/**
	 * M�todo de consulta de la propiedad del v�rtice inferior izquierdo.
	 * @return punto que representa el v�rtice inferior izquierdo
	 */
	public Punto getVerticeII() {
		return new Punto(verticeII);
	}
	
	/**
	 * M�todo de consulta de la propiedad del v�rtice inferior derecho.
	 * @return punto que representa el v�rtice inferior derecho
	 */
	public Punto getVerticeID() {
		return new Punto(verticeII.getX() + ladoX, verticeII.getY());
	}
	
	/**
	 * M�todo de consulta de la propiedad del v�rtice superior derecho.
	 * @return punto que representa el v�rtice superior derecho
	 */
	public Punto getVerticeSD() {
		return new Punto(verticeII.getX() + ladoX, verticeII.getY() + ladoY);
	}
	
	/**
	 * M�todo de consulta de la propiedad del v�rtice superior izquierdo.
	 * @return punto que representa el v�rtice superior izquierdo
	 */
	public Punto getVerticeSI() {
		return new Punto(verticeII.getX(), verticeII.getY() + ladoY);
	}
	
	/**
	 * M�todo para desplazar un rect�ngulo una cantidad en cada eje.
	 * @param incX cantidad de desplazamiento en el eje x.
	 * @param incY cantidad de desplazamiento en el eje y.
	 */
	public void desplazar(int incX, int incY) {
		verticeII.desplazar(incX, incY);
	}
	
	
	/**
	 * Calcula el per�metro de un rect�ngulo.
	 * @return el per�metro del rect�ngulo
	 */
	public double getPerimetro() {
		return 2 * (ladoX + ladoY);
	}
		
}
