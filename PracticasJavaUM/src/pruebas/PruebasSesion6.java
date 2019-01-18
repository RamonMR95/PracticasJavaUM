package pruebas;

import java.util.LinkedList;

import subastas.Subasta;
import subastas.SubastaLimitada;
import subastas.SubastaMinima;
import subastas.SubastaTemporal;
import subastas.Usuario;
import subastas.Puja;

public class PruebasSesion6 {

	public static void main(String[] args) {
		LinkedList<Subasta> subastas = new LinkedList<Subasta>();

		Usuario usuario1 = new Usuario("Juan", 100);
		Usuario usuario2 = new Usuario("Enrique", 500);

		Subasta subasta1 = new SubastaLimitada("Disco duro multimedia", usuario1, 1);
		Subasta subasta2 = new SubastaMinima("Impresora laser", usuario1, 100);

		subastas.add(subasta1);
		subastas.add(subasta2);

		SubastaTemporal temporal1 = new SubastaTemporal("Teclado", usuario1, 1000);
		subastas.add(temporal1);

		for (Subasta subasta : subastas) {
			subasta.pujar(usuario2, 10);
		}

		for (Subasta subasta : subastas) {
			if (subasta instanceof SubastaLimitada) {
				subasta.getListaPujas();
			}
			subasta.pujar(usuario2, 20);
		}

		for (Subasta subasta : subastas) {
			if (subasta instanceof SubastaTemporal) {
				if (!subasta.isCerrada()) {
					subasta.pujar(usuario2);
				}
			}
		}

		for (Subasta subasta : subastas) {
			if (!subasta.isCerrada()) {
				subasta.ejecutar();
			} else {
				System.out.println("La subasta estaba cerrada");
			}
		}

		System.out.println("Usuario1 " + usuario1.toString());
		System.out.println("Usuario2 " + usuario2.toString());

	}

}
