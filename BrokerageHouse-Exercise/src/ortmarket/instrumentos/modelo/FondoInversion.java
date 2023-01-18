package ar.edu.ort.tp1.ortmarket.instrumentos.modelo;

import ar.edu.ort.tp1.ortmarket.modelo.ListaInstrumentosPorCodigo;

public class FondoInversion extends InstrumentoFinanciero {

	private static final String MSJ_ERROR_CUOTAS = "La cantidad de cuotas no puede ser menor a 1";
	private int nroCuotaPartes;
	private ListaInstrumentosPorCodigo instrumentos;

	public FondoInversion(String codigo, String nombre, String emisor, int nroCuotaPartes) {
		super(codigo, nombre, emisor);
		this.setNroCuotaPartes(nroCuotaPartes);
		this.instrumentos = new ListaInstrumentosPorCodigo();
	}

	private void setNroCuotaPartes(int nro) {
		if (nro < 1) {
			throw new RuntimeException(MSJ_ERROR_CUOTAS);
		}

		this.nroCuotaPartes = nro;
	}

	public void agregarInstrumento(InstrumentoFinanciero instrumentoFinanciero) {
		instrumentos.add(instrumentoFinanciero);
	}

	@Override
	public double obtenerPrecio() {
		double total = 0;

		for (InstrumentoFinanciero insF : this.instrumentos) {
			total += insF.obtenerPrecio();

		}

		return total / this.nroCuotaPartes;
	}

}
