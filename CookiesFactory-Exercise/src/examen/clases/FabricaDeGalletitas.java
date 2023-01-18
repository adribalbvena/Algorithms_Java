package examen.clases;

import java.util.ArrayList;

public class FabricaDeGalletitas {

	private static final int CANTIDAD_TANDA = 10000;
	private static final int CANTIDAD_UNIDADES = 8;
	private static final int GRAMOS_TOTALES = 350;
	private Deposito deposito;
	private InformePorPaquetes informePaquetes;

	public FabricaDeGalletitas() {
		deposito = new Deposito();
		informePaquetes = new InformePorPaquetes();
	}

	private ArrayList<Galletita> fabricarGalletitas() {
		ArrayList<Galletita> galletitas = new ArrayList<>();
		for (int g = 0; g < CANTIDAD_TANDA; g++) {
			galletitas.add(new Galletita());
		}
		return galletitas;
	}
	
	public void procesarTandas(int tandas) {
		for (int t=1; t <= tandas; t++) {
			envasar(t, fabricarGalletitas());
		}
	}
	
	private void embolsar(Bolsa bolsa, Galletita galletita) {
		bolsa.agregar(galletita);
	}

	private void empaquetar(Paquete paquete, Galletita galletita) {
		paquete.agregar(galletita);
	}

	private void envasar(int tanda, ArrayList<Galletita> galletitasTanda) {
		// TODO desarrollar
		Paquete paquete = new Paquete(CANTIDAD_UNIDADES);
		Bolsa bolsa = new Bolsa(GRAMOS_TOTALES);
		int cantPaquetes = 0;
		int cantBolsas = 0;
		int pesoDescarte = 0;
		
		for (Galletita g: galletitasTanda) {
			if (g.obtenerCalidad().equals(Calidad.A)) {
				if(paquete.isFull()) {
					paquete = new Paquete(CANTIDAD_UNIDADES);
					deposito.estibar(paquete);
					cantPaquetes++;
				}
				empaquetar(paquete, g);
			} else if (g.obtenerCalidad().equals(Calidad.B)) {
				if(bolsa.isFull()) {
					bolsa = new Bolsa(GRAMOS_TOTALES);
					deposito.estibar(bolsa);
					cantBolsas++;
				}
				embolsar(bolsa, g);
			} else if (g.obtenerCalidad().equals(Calidad.C)) {
				pesoDescarte += g.getGramos();
 			}
		}
		
		generarEntradaEnInformeDiario(tanda, cantPaquetes, cantBolsas, pesoDescarte);
	}

	private void generarEntradaEnInformeDiario(int nroTanda, int paquetes, int bolsas, double pesoDescarte) {
		Resumen resumen = new Resumen(nroTanda, bolsas, paquetes, pesoDescarte / 1000);
		// TODO completar
		informePaquetes.agregarResumen(resumen);

	}
	
	public void informarResultados() {
		// TODO desarrollar
		informePaquetes.listar();
	}
	
}