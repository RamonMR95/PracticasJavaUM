package streams;

import java.util.LinkedList;

public class Generador {

	private LinkedList<Integer> lista;
	
	public Generador() {
		lista = new LinkedList<>();
		cargarNumeros();
	}
	
	
	public LinkedList<Integer> getLista() {
		return lista;
	}

	public void cargarNumeros() {
		for (int i = 0; i < 100; i++) {
			lista.add((int)(Math.random() * 100) + 1);
		}
	}
	
}
