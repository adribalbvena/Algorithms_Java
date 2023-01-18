package edu.ort.tp1.generics.urna;

public class TestUrna {

	public static void main(String[] args) {
		// Probamos con una urna de strings, donde cargamos nombres
		Urna<String> urnaNombres = new Urna<>();
		urnaNombres.add("Athos");
		urnaNombres.add("Porthos");
		urnaNombres.add("Aramis");
		urnaNombres.add("D'Artagnan");
		mostrarContenidoUrna(urnaNombres);

		// Probemos con una urna de numeros enteros. Como siempre que se trabaja
		// con Generics los elementos deben ser objetos.
		Urna<Integer> urnaNumerica = new Urna<>();
		for (int i = 0; i < 10; i++) {
			// Debemos transformar el int en Integer
			urnaNumerica.add(new Integer(i));
		}
		mostrarContenidoUrna(urnaNumerica);

	}

	// El ? sirve de comodin para definir el tipo de elemento. Asi se puede
	// trabajar con cualquier tipo de dato, tambien en forma generica
	private static void mostrarContenidoUrna(Urna<?> urna) {
		while (!urna.isEmpty()) {
			System.out.println(urna.remove());
		}
	}

}
