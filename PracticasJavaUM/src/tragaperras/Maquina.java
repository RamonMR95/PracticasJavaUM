package tragaperras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Maquina {
	private final int numeroCasillas;
	private double precioJugada;
	private double creditoDisponible;
	private HashSet<Premio> conjuntoPremios = new HashSet<Premio>();

	public Maquina(int numeroCasillas, double precioJugada, Premio... premios) {
		this.numeroCasillas = numeroCasillas;
		this.precioJugada = precioJugada;
		this.creditoDisponible = 0.0;
		Collections.addAll(conjuntoPremios, premios);

	}

	public int getNumeroCasillas() {
		return numeroCasillas;
	}

	public double getPrecioJugada() {
		return precioJugada;
	}

	public double getCreditoDisponible() {
		return creditoDisponible;
	}

	public HashSet<Premio> getConjuntoPremios() {
		return conjuntoPremios;
	}

	// Funcionalidad de la clase
	public void incrementarCredito(double cantidad) {
		this.creditoDisponible += cantidad;
	}

	public void decrementarCredito(double cantidad) {
		this.creditoDisponible -= cantidad;
	}

	private ArrayList<Fruta> generarCombinacion() {
		ArrayList<Fruta> combinacion = new ArrayList<Fruta>(this.numeroCasillas);
		Random random = new Random();
		Fruta[] todas = Fruta.values();

		for (int i = 0; i < this.numeroCasillas; i++) {
			Fruta fruta = todas[random.nextInt(todas.length)];
			combinacion.add(fruta);
		}
		return combinacion;
	}

	public ArrayList<Fruta> jugar() {
		if (creditoDisponible > precioJugada) {
			decrementarCredito(precioJugada);

			ArrayList<Fruta> combinacion = generarCombinacion();

			for (Premio premios : conjuntoPremios) {
				if(premios.getCombinacionGanadora().equals(combinacion)) {
					incrementarCredito(premios.getCantidadPremio());
					return combinacion;
				}
			}
			return combinacion;
		}
		return null;

	}

}
