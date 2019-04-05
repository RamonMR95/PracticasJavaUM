package pruebas;

import java.util.ArrayList;
import java.util.List;

import bitacoras.Bitacora;
import bitacoras.BitacoraInteligente;
import bitacoras.BitacoraUndo;

public class PruebasSesion7 {

	public static void main(String[] args) {

		Bitacora basica1 = new Bitacora("basica1");
		BitacoraInteligente bitacoraInteligente = new BitacoraInteligente("inteligente1", "facebook", "thepiratebay");
		BitacoraUndo bitacoraUndo = new BitacoraUndo("undo1");
		
		List<Bitacora> listaBitacoras = new ArrayList<>();
		listaBitacoras.add(basica1);
		listaBitacoras.add(bitacoraInteligente);
		listaBitacoras.add(bitacoraUndo);
		
		for (Bitacora bitacora : listaBitacoras) {
			bitacora.registroEntradas("Se ha producido un error en el servicio");
			bitacora.registroEntradas("Puedes descargar el driver desde thepiratebay");
			bitacora.registroEntradas("Las fotos están publicadas en facebook");
		}
		

		for (Bitacora bitacora : listaBitacoras) {
			if (bitacora instanceof BitacoraUndo) {
				((BitacoraUndo)bitacora).deshacer();
			}
		}
		
		for (Bitacora bitacora : listaBitacoras) {
			System.out.println(bitacora.toString());
		}
		
		Bitacora bitacoraInteligente2 = new BitacoraInteligente (bitacoraInteligente);
		bitacoraInteligente2.registroEntradas("La aplicación se puede descargar de thepiratebay");	
		
		System.out.println("Bitacora inteligente " + bitacoraInteligente);
		System.out.println("Bitacora inteligente2 " + bitacoraInteligente2);
	}

}
