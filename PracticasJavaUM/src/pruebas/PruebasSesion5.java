package pruebas;

import java.util.concurrent.TimeUnit;

import subastas.SubastaLimitada;
import subastas.SubastaMinima;
import subastas.SubastaTemporal;
import subastas.Usuario;

public class PruebasSesion5 {

	public static void main(String[] args) {
		Usuario usuario1 = new Usuario("Juan", 100);
		Usuario usuario2 = new Usuario("Enrique", 500);

		SubastaLimitada subastaLim1 = new SubastaLimitada("Disco duro multimedia", usuario1, 1);
		subastaLim1.pujar(usuario2, 10);

		System.out.println(subastaLim1.toString());

		SubastaTemporal subastaTem1 = new SubastaTemporal("COCHE", usuario1, 5000);
		subastaTem1.pujar(usuario2, 50);

		System.out.println(subastaTem1.toString());

//		try {
//			TimeUnit.SECONDS.sleep(5);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		subastaTem1.pujar(usuario2, 50);
//		System.out.println(subastaTem1.toString());
//		
//
//	}

		Usuario usuario3 = new Usuario("Ramon", 200);

		SubastaMinima subastaMin1 = new SubastaMinima("MOVIL", usuario3, 50);
		subastaMin1.pujar(usuario2, 40);
		System.out.println(subastaMin1.toString());
		subastaMin1.pujar(usuario2, 200);
		System.out.println(subastaMin1.toString());
		subastaMin1.cerrarSubasta();

	}
}
