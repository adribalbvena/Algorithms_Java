package examen;

import examen.clases.Tragamonedas;

public class ExamenRecuperatorio {

	public static void main(String[] args) {
		try {
			Tragamonedas tm = new Tragamonedas();
			System.out.println(tm);
			do {
				tm.jugar();
				tm.mostrar();
			} while (!tm.hayGanador());
		} catch (RuntimeException re) {
			System.out.println("Hubo un error al crear el tragamonedas: " + re.getMessage());
		}
	}

}
