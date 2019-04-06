package sesion12;

import java.util.LinkedList;

public class Programa {

	public static void main(String[] args) {
		EventoLibre eventoLibre1 = new EventoLibre("Real Madrid - F.C. Barcelona", 1);
		eventoLibre1.apostar("JUAN", new Marcador(5, 0));
		System.out.println(eventoLibre1);

		eventoLibre1.apostar("PEPE", new Marcador(1, 4));
		System.out.println(eventoLibre1);

		EventoRestringido eventoRestringido1 = new EventoRestringido("Nadal vs Federer", 3);
		eventoRestringido1.getConjuntoOpciones().add(new Marcador(2, 0));
		eventoRestringido1.getConjuntoOpciones().add(new Marcador(2, 1));
		eventoRestringido1.getConjuntoOpciones().add(new Marcador(0, 2));
		eventoRestringido1.getConjuntoOpciones().add(new Marcador(1, 2));
		eventoRestringido1.apostar("JUAN", new Marcador(2, 0));
		eventoRestringido1.apostar("PEDRO", new Marcador(2, 1));
		eventoRestringido1.apostar("PEPE", new Marcador(2, 0));
		

		LinkedList<Evento> listEventos = new LinkedList<Evento>();
		listEventos.add(eventoLibre1);
		listEventos.add(eventoRestringido1);
		
		for (Evento evento : listEventos) {
			evento.apostar("ENRIQUE", new Marcador(5, 0));
		}

		for (Evento evento : listEventos) {
			System.out.println("Nombre Evento: " + evento.getNombreEvento() + ", numero de apuestas : " + evento.getNumeroApuestas());
		}
	}

}
