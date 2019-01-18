package burbujaElementos;

import java.awt.Color;

import burbujaGeometria.*;



/** 
 *  Una burbuja creciente es una burbuja d�bil que va aumentando 
 *  el radio de su regi�n en 25% cada vez que soporta un bote 
 *  (se aplica la operaci�n chocar). Dado que es una burbuja d�bil, 
 *  este tipo de burbujas explota cuando ha recibido un n�mero de botes
 *  igual a su tama�o inicial (radio de su regi�n).
 *
 */
public class BurbujaCreciente extends BurbujaDebil {
	
	private final static int PORCENTAJE_CRECIMIENTO = 125;

	/**
	 * Constructor que inicializa las propiedades de una burbuja creciente
	 * a partir de la regi�n y la velocidad m�xima.
	 * A pesar de que es un tipo de burbuja d�bil en la que se tiene que establecer
	 * la propiedad de botes restantes, esta informaci�n no se tiene que pasar como
	 * par�metro porque se sabe que para toda burbuja creciente el n�mero de botes 
	 * restates coincide con el valor inicial de su radio.
	 * @param region circulo que representa la regi�n de la burbuja
	 * @param velocidadMax valor inicial de la velocidad m�xima
	 */
	public BurbujaCreciente(Circulo region, int velocidadMax) {
		//Ejemplo de constructor de una clase descendiente que tiene menos argumentos
		//que el constructor del padre
		super(region, velocidadMax, region.getRadio());
	}
	
	
	/**
	 * Modifica el comportamiento del m�todo heredado del padre para tener en cuenta
	 * el crecimiento de la burbuja cada vez que recibe un choque.
	 */
	@Override
	public void chocar() {
		// En cada choque aumentar el radio de la regi�n
		Circulo region = getRegion();
		
		region.escalar(PORCENTAJE_CRECIMIENTO);
		
		setRegion(region);
		
		//Comportarme igual que una burbuja debil comprobando los botes restantes
		//si botes restantes == 0 --> explota()
		super.chocar();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getColor() {
		return Color.BLUE;
	}
}
