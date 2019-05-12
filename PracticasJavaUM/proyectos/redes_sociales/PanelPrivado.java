package redes_sociales;

import java.util.HashSet;

public class PanelPrivado extends Panel {

	private HashSet<String> palabrasClave;
	private HashSet<Mensaje> mensajesSeguimiento;
	
	public PanelPrivado(Perfil propietario) {
		super(propietario);
		this.palabrasClave = new HashSet<>();
		this.mensajesSeguimiento = new HashSet<>();
	}

	public void addPalabrasClave(String...palabras) {
		for (String palabra : palabras) {
			this.palabrasClave.add(palabra);
		}
	}
	
	public void addMensajesSeguimiento(Mensaje mensaje) {
		if (this.palabrasClave.contains(mensaje.getTexto())) {
			this.mensajesSeguimiento.add(mensaje);
		}
	}
	
}
