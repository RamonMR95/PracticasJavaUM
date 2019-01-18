package burbujaGeometria;

/**
 * Representa la figura geom�trica C�rculo.
 * Un circulo se caracteriza por un punto, que es su centro
 * y el valor del radio.
 */
public class Circulo {
	//Constante de la clase circulo
	//Una constante puede ser public porque no puede cambiar el valor
	public final static int RADIO_DEFECTO = 5;
	public final static Punto ORIGEN = new Punto();
	
	private Punto centro;
	private int radio;
	
	/**
	 * Constructor que inicializa todas las propiedades del c�rculo.
	 * @param centro valor inicial del centro
	 * @param radio valor inicial del radio
	 */
	public Circulo(Punto centro, int radio) {
		//Solucionamos el problema del aliasing creando un nuevo punto
		//igual que el que me pasan como par�metro
		this.centro = new Punto(centro);
		this.radio = radio;
	}
	
	/**
	 * Constructor sin argumentos. Construye el Circulo en 
	 * el origen de coordenadas con radio 5 (valores por defecto)
	 */
	public Circulo() {
		this(ORIGEN, RADIO_DEFECTO);
	}
	
	/**
	 * Constructor de copia. Inicializa el circulo con los mismos
	 * valores que tiene el circulo que se pasa como par�metro.
	 * @param circulo circulo del que se copian sus propiedades
	 */
	public Circulo(Circulo circulo) {
		this(circulo.getCentro(), circulo.getRadio());
	}
	
	/**
	 * Calcula el per�metro de un c�rculo.
	 * @return valor del perim�tro
	 */
	public double getPerimetro() {
		return 2 * Math.PI * radio;
	}
	
	/**
	 * M�todo de consulta de la propiedad centro.
	 * @return valor del centro
	 */
	public Punto getCentro() {
		//Devolvemos copia para evitar el problema del aliasing
		return new Punto(centro);
	}

	/**
	 * M�todo de consulta de la propiedad radio.
	 * @return valor del radio
	 */
	public int getRadio() {
		return radio;
	}
	
	/**
	 * Desplaza el c�rculo una cantidad en cada eje.
	 * @param incX cantidad de desplazamiento en x
	 * @param incY cantidad de desplazamiento en y
	 */
	public void desplazar(int incX, int incY) {

		centro.desplazar(incX, incY);
	}

	/** 
	 * Sit�a el circulo en una nueva posicion.
	 * @param nuevoCentro nueva posici�n del centro
	 */
	public void desplazar(Punto nuevoCentro) {
		//Diferentes alternativas par la implementaci�n
		//Opcion 1
		centro.setX(nuevoCentro.getX());
		centro.setY(nuevoCentro.getY());
		
		//Opcion 2
	    /*
	    int incX = nuevoCentro.getX() - centro.getX();
		int incY = nuevoCentro.getY() - centro.getY();
		
		centro.desplazar(incX, incY);
		*/
	}
	
	/**
	 * Cambia el tama�o de un c�rculo.
	 * Por ejemplo, Escalar a 200% significa duplicar el tama�o del radio
	 * @param porcentaje porcentaje en el que se modifica el radio
	 */
	public void escalar(int porcentaje) {
		radio = (int) (radio * (porcentaje / 100.0));
	}

}








