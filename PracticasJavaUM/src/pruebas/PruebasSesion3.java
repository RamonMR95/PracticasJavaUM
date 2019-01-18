package pruebas;

import geometria.Punto;
import geometria.Rectangulo;

public class PruebasSesion3 {

	public static void main(String[] args) {
		Punto verticeII = new Punto(3, 1);
		Rectangulo rectangulo1 = new Rectangulo(verticeII, 2, 5);
		System.out.println(rectangulo1.toString());

		Rectangulo rectanguloDesplazado = new Rectangulo(verticeII, 2, 5);
		rectanguloDesplazado.desplazar(0, -7);
		System.out.println(rectanguloDesplazado.toString());

	}

}
