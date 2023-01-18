package edu.ort.tp1.generics.caja;

public class TestCaja2 {

	private static final int CANTIDAD_DE_CAJAS = 4;

	public static void main(String[] args) {
		ParDeZapatos zapatos = new ParDeZapatos("Negros");
		CajaDeZapatos [] zapatero = new CajaDeZapatos[CANTIDAD_DE_CAJAS];
		CajaDeZapatos caja = new CajaDeZapatos();
		caja.guardar(zapatos);
		zapatero[0] = caja;
	}

}
