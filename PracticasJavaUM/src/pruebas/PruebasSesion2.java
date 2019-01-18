package pruebas;

import geometria.Direccion;
import geometria.Punto;
import geometria.Circulo;

public class PruebasSesion2 {

	public static void main(String[] args) {
		Punto punto1 = new Punto(2, 3);
		punto1.desplazar(Direccion.ARRIBA);
		System.out.println(punto1.toString());

		Punto punto2 = new Punto(4, 2);
		System.out.println("La distancia entre punto1 y punto2 es de : " + punto1.distancia(punto2));

		Punto masLejano = Punto.puntoMasAlejado(punto1, punto2);
		System.out.println(masLejano.toString());

		/* CIRCULO */
		Circulo circulo1 = new Circulo(punto1, 3);
		Circulo circulo2 = new Circulo(punto1, 5);

		circulo1.desplazar(3, 2);
		System.out.println("El circulo 1 : " + circulo1.toString());
		System.out.println("El circulo 2 : " + circulo2.toString());

		Punto centro = circulo2.getCentro();
		centro.desplazar(Direccion.ABAJO);

		System.out.println(centro.toString());
		System.out.println(circulo2.toString());

		circulo2.escalar(150);
		System.out.println(circulo2.toString());

	}

}