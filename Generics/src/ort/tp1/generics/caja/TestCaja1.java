package edu.ort.tp1.generics.caja;

import java.util.ArrayList;

public class TestCaja1 {

	public static void main(String[] args) {
		ParDeZapatos zapatos = new ParDeZapatos("Negros");
		Caja<ParDeZapatos> cajaDeZapatos = new Caja<>();
		cajaDeZapatos.guardar(zapatos);

		// pongo en null la variable zapatos para asegurarme de que solo
		// "quedan" en la caja.
		zapatos = null;
		
		// Los saco de la caja
		System.out.println("De la caja obtuve... " + zapatos);

		// vuelvo a guardarlos y agrego la caja de zapatos a mi coleccion
		cajaDeZapatos.guardar(zapatos);
		ArrayList<Caja<ParDeZapatos>> miColeccionDeZapatos = new ArrayList<>();
		miColeccionDeZapatos.add(cajaDeZapatos);
	}

}
