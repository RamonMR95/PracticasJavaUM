package tragaperras;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {

		// 1. Declara y construye dos premios

		Premio premio1 = new Premio(20, Fruta.FRESA, Fruta.FRESA, Fruta.FRESA);
		Premio premio2 = new Premio(10, Fruta.SANDIA, Fruta.SANDIA, Fruta.SANDIA);
		Premio premio3 = new Premio(30, Fruta.PLATANO, Fruta.PLATANO, Fruta.PLATANO);
		Premio premio4 = new Premio(40, Fruta.MELOCOTON, Fruta.MELOCOTON, Fruta.MELOCOTON);
		Premio premio5 = new Premio(50, Fruta.PERA, Fruta.PERA, Fruta.PERA);

		/*
		 * 2. Crea una máquina con un tamaño de combinación de 3 frutas, un precio por
		 * partida de 0,5 euros y los dos premios declarados previamente
		 */

		Maquina maquina = new Maquina(3, 0.5, premio1, premio2, premio3, premio4, premio5);

		/*
		 * 3. Solicita al usuario que introduzca por teclado la cantidad de crédito para
		 * jugar.
		 */
		System.out.println("Introduzca el crédito: ");
		Scanner teclado = new Scanner(System.in);
		double credito = teclado.nextDouble();
		teclado.nextLine();
		maquina.incrementarCredito(credito);

		// 4. Jugamos mientras haya crédito disponible
		while (maquina.getCreditoDisponible() > 0) {
			// 4.1 Realiza la jugada
			ArrayList<Fruta> combinacion = maquina.jugar();

			// 4.2 Muestra la combinación obtenida y el crédito
			System.out.println(combinacion.toString() + " --- " + maquina.getCreditoDisponible());
			// 4.3 Pide al usuario que pulse intro para continuar
			System.out.println("Pulse Intro para volver a jugar");
			teclado.nextLine();
		}
		teclado.close();
	}
}
