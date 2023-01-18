package ar.edu.ort.tp1.examen;

import ar.edu.ort.tp1.examen.clases.Bolso;
import ar.edu.ort.tp1.examen.clases.Deposito;
import ar.edu.ort.tp1.examen.clases.Pelota;
import ar.edu.ort.tp1.examen.clases.Producto;
import ar.edu.ort.tp1.examen.clases.Raqueta;
import ar.edu.ort.tp1.examen.clases.Superficie;

public class Test {

	private static final int ONCE = 11;
	private static int id = 10;

	public static void main(String[] args) {

		Deposito d = new Deposito(3);

		depositar(d);

		int unId = 55;
		System.out.println(d.productoDepositado(unId) ? "El producto id " + unId + " est� depositado"
				: "El producto id " + unId + " NO est� depositado");
		unId = 23;
		System.out.println(d.productoDepositado(unId) ? "El producto id " + unId + " est� depositado"
				: "El producto id " + unId + " NO est� depositado");

		retiros(d);
	}

	private static void retiros(Deposito d) {
		System.out.println("Se comienza a retirar elementos");
		System.out.println();
		retirar(d, 12);
		System.out.println();
		retirar(d, 13);
		System.out.println();
		retirar(d, 28);
		System.out.println();
		System.out.println("Fin del retiro de elementos");
	}

	private static void retirar(Deposito d, int id) {
		Producto p = d.retirarPorId(id);
		if (p != null) {
			System.out.println("Se retir� el producto id: " + id);
			p.mostrar();
		} else {
			System.out.println("No se pudo retirar producto id: " + id);
		}

	}

	private static void depositar(Deposito d) {

		System.out.println("Depositando productos");
		System.out.println();

		depositarBolso(d, id++, "Wilson", "Us Open");
		System.out.println();
		depositarRaqueta(d, id++, "Wilson", 100);
		System.out.println();
		depositarPelota(d, id++, "Wilson", Superficie.POLVO_LADRILLO);
		System.out.println();
		depositarBolso(d, id++, "", "Us Open 2");
		System.out.println();
		depositarRaqueta(d, 0, "Wilson", 105);
		System.out.println();
		depositarBolso(d, id++, "Wilson", "All Team");
		System.out.println();
		depositarRaqueta(d, id++, "Prince", 98);
		System.out.println();
		depositarPelota(d, id++, "Wilson", Superficie.RAPIDA);
		System.out.println();
		depositarBolso(d, id++, "Wilson", null);
		System.out.println();
		depositarRaqueta(d, id++, "Wilson", 544);
		System.out.println();
		depositarPelota(d, id++, "Wilson", null);
		System.out.println();
		for (int i = 0; i < ONCE; i++) {
			depositarPelota(d, id++, "Wimbledon", Superficie.CESPED);
			System.out.println();
		}
		depositarBolso(d, id++, "Wilson", "Australian Bag");
		System.out.println();
		System.out.println("Fin de los dep�sitos");
	}

	private static void depositarBolso(Deposito d, int id, String marca, String modelo) {
		try {
			d.depositar(new Bolso(id, marca, modelo));
			System.out.println("Bolso depositado id:"+id);
		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
		}
		// TODO Completar
	}

	private static void depositarRaqueta(Deposito d, int id, String marca, int tamanioAro) {
		// TODO Completar
		try {
			d.depositar(new Raqueta(id, marca, tamanioAro));
			System.out.println("Raqueta depositada id:"+id);
		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
		}
	}

	private static void depositarPelota(Deposito d, int id, String marca, Superficie superficie) {
		//TODO Completar
		try {
			d.depositar(new Pelota(id, marca, superficie));
			System.out.println("Pelota depositada id:"+id);
		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
		}
	}

}
