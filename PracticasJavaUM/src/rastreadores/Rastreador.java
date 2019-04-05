package rastreadores;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Rastreador {
	private LinkedList<Mensaje> listaMensajes;
	private HashMap<String, LinkedList<String>> mapaMensajes;
	private HashSet<String> conjuntoAutores;
	private HashSet<String> conjuntoTemas;

	public Rastreador() {
		listaMensajes = new LinkedList<>();
		mapaMensajes = new HashMap<>();
		conjuntoAutores = new HashSet<>();
		conjuntoTemas  = new HashSet<>();
	}

	
	public LinkedList<Mensaje> getListaMensajes() {
		return listaMensajes;
	}


	public HashMap<String, LinkedList<String>> getMapaMensajes() {
		return mapaMensajes;
	}


	public HashSet<String> getConjuntoAutores() {
		return conjuntoAutores;
	}


	public HashSet<String> getConjuntoTemas() {
		return conjuntoTemas;
	}


	public void registrarMensaje(Mensaje mensaje) {
		listaMensajes.add(mensaje);
		mapaMensajes.put(mensaje.getAutor(), mensaje.getListaTemas());
		conjuntoAutores.add(mensaje.getAutor());
		conjuntoTemas.addAll(mensaje.getListaTemas());
	}


	@Override
	public String toString() {
		return "Rastreador [listaMensajes=" + listaMensajes + ", mapaMensajes=" + mapaMensajes + ", conjuntoAutores="
				+ conjuntoAutores + ", conjuntoTemas=" + conjuntoTemas + "]";
	}
	
}
