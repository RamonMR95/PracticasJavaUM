package redes_sociales;

public class Mensaje {

	private final String texto;
	private final Perfil autor;
	private Mensaje referido;
	private boolean isIndependiente;
	
	
	public String getTexto() {
		return texto;
	}

	public Perfil getAutor() {
		return autor;
	}

	public Mensaje getReferido() {
		return referido;
	}

	public boolean isIndependiente() {
		return isIndependiente;
	}

	public Mensaje(String texto, Perfil autor) {
		this.texto = texto;
		this.autor = autor;
		this.referido = null;
		this.isIndependiente = true;
	}
	
	public Mensaje(String texto, Perfil autor, Mensaje referido) {
		this.texto = texto;
		this.autor = autor;
		this.referido = referido;
		this.isIndependiente = false;
	}
}
