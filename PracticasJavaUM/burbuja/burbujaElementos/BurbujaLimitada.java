package burbujaElementos;


import java.awt.Color;

import burbujaGeometria.*;


/** 
 * Una burbuja limitada es una burbuja que puede desplazarse hasta una determinada 
 *  cantidad. El l�mite de desplazamiento se establece en su construcci�n y no var�a.
 *  Cada vez que la burbuja asciende, determina si puede seguir subiendo, esto es,
 *  si ya ha alcanzado su l�mite de desplazamiento. En caso de llegar al l�mite, 
 *  la burbuja se queda en su posici�n y no actualiza la velocidad actual, es decir, 
 *  no hace nada.
 * 
 */
public class BurbujaLimitada extends Burbuja {
	
	//Nueva propiedad
	private int limiteDesplazamiento;
	
	//atributo implementaci�n
	private int cantidadDesplazamiento;
	
	/**
	 * Constructor que inicializa las propiedades de una burbuja limitada a partir
	 * de su regi�n, velocidad m�xima y el l�mite de desplazamiento.
	 * @param region circulo que representa la regi�n de la burbuja limitada
	 * @param velocidadMax valor inicial de la velocidad m�xima
	 * @param limiteDesplazamiento valor inicial del l�mite de desplazamiento
	 */
	public BurbujaLimitada(Circulo region, int velocidadMax, int limiteDesplazamiento) {
		super(region, velocidadMax);
		
		this.limiteDesplazamiento = limiteDesplazamiento;
		this.cantidadDesplazamiento = 0;
	}
	
	/**
	 * M�todo de consulta de la propiedad l�mite de desplazamiento.
	 * @return valor del l�mite de desplazamiento
	 */
	public int getLimiteDesplazamiento() {
		return limiteDesplazamiento;
	}
	
	/**
	 * M�todo que consulta si la burbuja limitada est� parada.
	 * Una burbuja limitada se puede haber parado porque el jugador
	 * haya chocado o porque ha alcanzado el l�mite de desplazamiento.
	 * @return true si la burbuja est� parada y false en caso contrario.
	 */
	public boolean isParada() {
		return (getVelocidadActual() == 0 
				|| cantidadDesplazamiento >= limiteDesplazamiento);
	}
	
	
	//M�todos adaptados 
	
	/**  Cada vez que la burbuja asciende, determina si puede seguir subiendo, esto es,
	 *  si ya ha alcanzado su l�mite de desplazamiento. En caso de llegar al l�mite, 
	 *  la burbuja se queda en su posici�n y no actualiza la velocidad actual, es decir, 
	 *  no hace nada.  
     */
	@Override
	public void ascender() {
			
		if (cantidadDesplazamiento < limiteDesplazamiento) {
			
			int posicionYInicial = getRegion().getCentro().getY();
			
			//llamamos al m�todo ascender disponible en la clase padre
			super.ascender();
			
			//actualizar la cantidad de desplazamiento
			
			int posicionYFinal = getRegion().getCentro().getY();
			
			cantidadDesplazamiento += (posicionYFinal - posicionYInicial);
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getInfo() {
		return super.getInfo() + String.format(" - limiteDesplazamiento: %d, cantidadDesplazamiento: %d", limiteDesplazamiento, cantidadDesplazamiento); 
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getColor() {
		return Color.YELLOW;
	}
}
