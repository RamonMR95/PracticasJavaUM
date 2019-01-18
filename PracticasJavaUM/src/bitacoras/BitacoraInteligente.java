package bitacoras;

import java.util.HashSet;

public class BitacoraInteligente extends Bitacora {
	private final HashSet<String> palabrasProhibidas;
	private HashSet<String> spam;

	public BitacoraInteligente(String identificador, String... palabras) {
		super(identificador);
		this.spam = new HashSet<String>();
		this.palabrasProhibidas = new HashSet<String>();

		for (String palabra : palabras) {
			palabrasProhibidas.add(palabra);
		}

	}

	@Override
	public boolean registroEntradas(String suceso) {
		if (palabrasProhibidas.contains(suceso)) {
			spam.add(suceso);
			return false;

		} else {
			return super.registroEntradas(suceso);
		}
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder();
		resultado.append("Palabras prohibidas : ");

		for (String palabra : palabrasProhibidas) {
			resultado.append(palabra);
		}
		resultado.append("SPAM :");

		for (String palabra : spam) {
			resultado.append(palabra);
		}

		return resultado.toString();

	}
}
