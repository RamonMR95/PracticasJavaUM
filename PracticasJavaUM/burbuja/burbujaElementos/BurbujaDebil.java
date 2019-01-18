package burbujaElementos;

import java.awt.Color;

import burbujaGeometria.*;

/**
 * Una burbuja d�bil es una burbuja que se caracteriza por soportar un n�mero limitado 
 * de botes (botes restantes). Esta propiedad se establece en la construcci�n.
 * Cada vez que recibe un bote (se aplica la operaci�n chocar),
 * reduce en una unidad el n�mero de botes restantes. Cuando esta propiedad alcanza el 
 * valor 0, la burbuja explota.
 *
 */
public class BurbujaDebil extends Burbuja {
	private int botesRestantes;
	
	/**
	 * Constructor que inicializa las propiedades de una Burbuja D�bil a partir
	 * de la regi�n, velocidad m�xima y botes que resiste.
	 * @param region circulo que representa la regi�n de la burbuja
	 * @param velocidadMax valor inicial de la velocidad m�xima
	 * @param botesRestantes cantidad de botes que resiste la burbuja antes de explotarse
	 */
	public BurbujaDebil(Circulo region, int velocidadMax, int botesRestantes) {
		super(region, velocidadMax);
		
		this.botesRestantes = botesRestantes;
	}
	
	/**
	 * Informa de los botes que resiste a la burbuja antes de explotarse.
	 * @return botes que todav�a resiste la burbuja
	 */
	public int getBotesRestantes() {
		return botesRestantes;
	}
	
	//Funcionalidad adaptada de la clase padre

	/** 
	 *  Cada vez que recibe un bote reduce en una unidad el n�mero de botes restantes. 
	 *  Cuando esta propiedad alcanza el valor 0, la burbuja explota.
	 */
	@Override
	public void chocar() {
		--botesRestantes;
		
		super.chocar();
		
		if (botesRestantes == 0) {
			//No es necesario el super porque es un m�todo disponible por la herencia
			this.explotar();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getInfo() {
		return super.getInfo() + " - botesRestantes: " + botesRestantes;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getColor() {
		return Color.RED;
	}
}
