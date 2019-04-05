package rastreadores;

import java.util.LinkedList;

public class Mensaje implements Comparable<Mensaje> {
	private String autor;
	private String texto;
	private LinkedList<String> temas;

	public Mensaje(String autor, String texto) {
		this.autor = autor;
		this.texto = texto;
		this.temas = new LinkedList<>();
		addTemas();
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public LinkedList<String> getListaTemas(){
		return temas;
	}
	
	public void addTemas() {
		String[] arrayTemas = texto.split("\\s+");
		
		for (String palabra : arrayTemas) {
			if (palabra.startsWith("#")) {
				temas.add(palabra);
			}
		}
	}

	@Override
	public int compareTo(Mensaje o) {
		return this.autor.compareTo(o.autor);
	}

	@Override
	public String toString() {
		return "Mensaje [autor=" + autor + ", texto=" + texto + ", temas=" + temas + "]";
	}
	
}
