package redes_sociales;

import java.util.HashMap;

public class Perfil {

	private final String identificador;
	private PanelPrivado panel;
	private HashMap<String, PanelSuscripcion> temasInteres;
	
	public Perfil(String identificador) {
		this.identificador = identificador;
		this.panel = new PanelPrivado(this);
		this.temasInteres = new HashMap<>();
	}

	public String getIdentificador() {
		return identificador;
	}

	public PanelPrivado getPanel() {
		return panel;
	}

	public HashMap<String, PanelSuscripcion> getTemasInteres() {
		return temasInteres;
	}
	
	public void addTemaInteres(String tema) {
		this.temasInteres.put(tema, new PanelSuscripcion(this));
	}
	
	public PanelSuscripcion consultarTema(String tema) {
			return this.temasInteres.get(tema);
	}
}
