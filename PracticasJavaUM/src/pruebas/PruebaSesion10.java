package pruebas;

import java.util.Collections;

import rastreadores.Mensaje;
import rastreadores.Rastreador;

public class PruebaSesion10 {

	public static void main(String[] args) {
		Mensaje mensaje = new Mensaje("@ErnestoValverde", "Los rivales también juegan, no sólo el #Barça");
		Mensaje mensaje2 = new Mensaje("@Manolete", "El #Barça no sabe jugar sin Messi");
		Mensaje mensaje3 = new Mensaje("@Aanolete", "#Barça y #RealMadrid han roto el mercado de fichajes");
		
		Rastreador rastreador = new Rastreador();
		rastreador.registrarMensaje(mensaje);
		rastreador.registrarMensaje(mensaje2);
		rastreador.registrarMensaje(mensaje3);
		
		System.out.println(mensaje);
		System.out.println(mensaje2);
		System.out.println(mensaje3);
		
		Collections.sort(rastreador.getListaMensajes());
		System.out.println(rastreador.getMapaMensajes().get("@ErnestoValverde"));
		System.out.println(rastreador.getMapaMensajes().keySet());
		System.out.println(rastreador.getMapaMensajes().get("@Manolete"));
		System.out.println(rastreador.getListaMensajes());
		
	}
}
