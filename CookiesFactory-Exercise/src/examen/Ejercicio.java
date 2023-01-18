package examen;

import examen.clases.FabricaDeGalletitas;

public class Ejercicio {
	
	public static void main(String[] args) {
		FabricaDeGalletitas fabrica = new FabricaDeGalletitas();
		fabrica.procesarTandas(3);
		fabrica.informarResultados();
	}
	
}
