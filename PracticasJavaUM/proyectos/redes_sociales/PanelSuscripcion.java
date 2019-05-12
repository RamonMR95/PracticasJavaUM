package redes_sociales;

import java.util.HashSet;

public class PanelSuscripcion extends Panel {

	private HashSet<Perfil> colaboradores;
	
	public PanelSuscripcion(Perfil propietario) {
		super(propietario);
	}

	public void addColaboradores(Perfil perfil) {
		this.colaboradores.add(perfil);
	}
	
	public void removeColaboradores(Perfil perfil) {
		if (this.colaboradores.contains(perfil)) {
			this.colaboradores.remove(perfil);
		}
	}
}
 