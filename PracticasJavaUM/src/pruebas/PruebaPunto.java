package pruebas;

import geometria.Punto;

public class PruebaPunto {

	public static void main(String[] args) {
		Punto punto1 = new Punto(1, 3);
		System.out.println(punto1.toString());

		Punto punto2 = new Punto();
		System.out.println(punto2.toString());

		Punto punto3 = new Punto(punto1);
		System.out.println(punto3.toString());

		Punto punto4 = punto2;

		punto2.desplazar(5, 4);

		System.out.println(punto2.toString());
		System.out.println(punto4.toString());

	}

}
