package bitacoras;

import java.util.Collections;
import java.util.HashSet;

public class BitacoraInteligente extends Bitacora {
	public HashSet<String> palabrasProhibidas;
	public HashSet<String> spam;

	public BitacoraInteligente(String identificador, String... palabras) {
		super(identificador);
		this.spam = new HashSet<String>();
		this.palabrasProhibidas = new HashSet<String>();
		Collections.addAll(palabrasProhibidas, palabras);	
		
//		for (String palabra : palabras) {
//			palabrasProhibidas.add(palabra);
//		}

	}

	public BitacoraInteligente(BitacoraInteligente bitacoraInteligente) {
		super(bitacoraInteligente);
		this.spam = new HashSet<>(bitacoraInteligente.spam);
		this.palabrasProhibidas = new HashSet<>(bitacoraInteligente.palabrasProhibidas);
	}

	@Override
	public boolean registroEntradas(String suceso) {
		for (String prohibida : palabrasProhibidas) {
			if (suceso.contains(prohibida)) {
				spam.add(suceso);
				return false;
			}
		}
		return super.registroEntradas(suceso);
		
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder();
		resultado.append(super.toString());
		resultado.append(", Palabras prohibidas : ");

		for (String palabra : palabrasProhibidas) {
			resultado.append(palabra + ", ");
		}
		resultado.append(" SPAM : ");

		for (String basura : spam) {
			resultado.append(basura + ",");
		}
		return resultado.toString();

	}

}
