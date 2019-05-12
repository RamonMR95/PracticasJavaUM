package redes_sociales;

import java.util.LinkedList;

public class Panel {

	private final Perfil propietario;
	private LinkedList<Mensaje> listaMensajes;

	public Panel(Perfil propietario) {
		this.propietario = propietario;
		this.listaMensajes = new LinkedList<>();
	}


	public LinkedList<Mensaje> getListaMensajes() {
		return listaMensajes;
	}


	public void setListaMensajes(LinkedList<Mensaje> listaMensajes) {
		this.listaMensajes = listaMensajes;
	}


	public Perfil getPropietario() {
		return propietario;
	}
	

	public LinkedList<Mensaje> consultar(Mensaje mensaje) {
		LinkedList<Mensaje> mensajes = new LinkedList<>();
		mensajes.add(mensaje.getReferido());
		return mensajes;
	}

	public boolean borrar(Mensaje mensaje) {
		if (this.listaMensajes.contains(mensaje)) {
			this.listaMensajes.remove(mensaje);
		}
		return false;
	}
}
