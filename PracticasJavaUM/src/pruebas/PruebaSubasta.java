package pruebas;

import subastas.Subasta;
import subastas.Usuario;

public class PruebaSubasta {

	public static void main(String[] args) {
		Usuario usuario1 = new Usuario("Juan", 100.0);
		Usuario usuario2 = new Usuario("Pedro", 150.0);
		Usuario usuario3 = new Usuario("Enrique", 300.0);

		Subasta subasta1 = new Subasta("Teléfono Móvil", usuario1);
		Subasta subasta2 = new Subasta("SOAP", usuario2);

		subasta1.pujar(usuario2, 100.0);
		System.out.println(subasta1.toString());

		subasta1.pujar(usuario3, 50.0);
		System.out.println(subasta1.toString());

		subasta2.pujar(usuario1, 50);

		subasta2.ejecutar();
		subasta1.ejecutar();

		subasta1.pujar(usuario3, 200.0);

		System.out.println(subasta1.toString());
		System.out.println(subasta2.toString());
		System.out.println(usuario1.getSubastas());
		System.out.println(usuario2.getSubastas());
		System.out.println(usuario3.getSubastas());

	}

}
