package burbujaElementos;

import java.awt.Color;

import burbujaGeometria.*;

/**
 * Una burbuja es un componente del juego que se mueve siempre en sentido vertical ascendente. 
 * El jugador podr� botar sobre las burbujas o hacerlas explotar.
 * 
 */
public class Burbuja  {
	private Circulo region;
	private final int velocidadMax;
	private int velocidadActual;
	private boolean explotada;
	
	/**
	 * Constructor que inicializa la burbuja tomando un circulo
	 * (que representa su regi�n) y la velocidad m�xima.
	 * @param region valor inicial de la regi�n de la burbuja
	 * @param velocidadMax valor inicial de la velocidad m�xima que puede alcanzar la burbuja 
	 */
	public Burbuja(Circulo region, int velocidadMax) {
		//Nos quedamos con copia para evitar el problema del aliasing
		this.region = new Circulo(region.getCentro(), region.getRadio());
		this.velocidadMax = velocidadMax;
		//inicializamos los atributos velocidadActual y explotada por legibilidad
		//no es necesario porque toman los valores por defecto de los tipos de datos
		this.velocidadActual = 0;
		this.explotada = false;
	}
	
	/**
	 * M�todo de consulta de la propiedad regi�n.
	 * @return el circulo que representa la regi�n de la burbuja
	 */
	public Circulo getRegion() {
		//Devolvemos copia para evitar el problema del aliasing
		return new Circulo(region.getCentro(), region.getRadio());
	}
	
	/**
	 * M�todo de establecimiento de la propiedad regi�n.
	 * @param region nueva regi�n de la burbuja
	 */
	protected void setRegion(Circulo region) {
		//Punto de acceso a una propiedad s�lo para las subclases!!! 
		//tb visible para el resto de clases del paquete
		this.region = region;
	}
	
	/**
	 * M�todo de consulta de la propiedad velocidad actual.
	 * @return valor de la velocidad actual
	 */
	public int getVelocidadActual() {
		return velocidadActual;
	}
	
	/**
	 * M�todo de consulta de la propiedad velocidad m�xima.
	 * @return valor de la velocidad m�xima
	 */
	public int getVelocidadMaxima() {
		return velocidadMax;
	}

	/**
	 * M�todo de consulta de la propiedad explotada.
	 * @return true si la burbuja se ha explotado y false en caso contrario.
	 */
	public boolean isExplotada() {
		return explotada;
	}
	
	//Funcionalidad de la burbuja
	/** 
	 * Hace explotar la burbuja (establece la propiedad explotada a verdadero).
	 */
	public void explotar() {
		explotada = true;
	}
	
	/**
	 * Esta operaci�n recibe como par�metro un punto que se utiliza como referencia 
	 * para situar la regi�n de la burbuja. El resultado de la operaci�n ser� que el 
	 * centro de la regi�n de la burbuja estar� situado en el punto que se establece 
	 * como par�metro.
	 * 
	 * @param posicion nuevo centro del circulo que representa la regi�n de la burbuja
	 */
	public final void situar(Punto posicion) {
		region.desplazar(posicion);
	}
	
	/**
	 * Esta operaci�n desplaza la regi�n de la burbuja hacia arriba. La cantidad de 
	 * desplazamiento en el eje Y equivale a su velocidad actual. Adem�s, incrementa 
	 * la velocidad actual en una unidad, siempre que no supere la velocidad l�mite.
	 */
	public void ascender() {
		
		region.desplazar(0, velocidadActual);
		
		if (velocidadActual < velocidadMax)
			++velocidadActual;
	}
	
	/**
	 * Establece la velocidad actual a 0.
	 * 
	 */
	public void chocar() {
		velocidadActual = 0;
	}
	
	/**
	 * Devuelve una cadena de texto con las informaci�n de las propiedades de la burbuja.
	 * @return cadena de texto con la informaci�n de la burbuja.
	 */
	public String getInfo() {
		return  String.format("v. actual: %d, v. l�mite: %d, explotada: %b", 
				getVelocidadActual(), 
				getVelocidadMaxima(),
				isExplotada());
	}
	
	/**
	 * Consulta el color con el que se representa gr�ficamente la burbuja.
	 * @return color de la burbuja
	 */
	public Color getColor() {
		return Color.GREEN;
	}
	
}















