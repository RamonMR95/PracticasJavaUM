package pruebas;


import streams.Generador;

public class PruebasSesion11 {

	public static void main(String[] args) {
		Generador generator = new Generador();
		System.out.println(generator.getLista());
		
		generator.getLista().stream().map(Integer::toHexString).forEach(n -> System.out.print(n));

	}

}
