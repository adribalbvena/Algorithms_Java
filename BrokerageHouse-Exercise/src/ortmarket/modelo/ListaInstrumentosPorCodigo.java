package ar.edu.ort.tp1.ortmarket.modelo;

import ar.edu.ort.tp1.ortmarket.instrumentos.modelo.InstrumentoFinanciero;
import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaInstrumentosPorCodigo extends ListaOrdenadaNodos<String, InstrumentoFinanciero> implements Listable {

	@Override
	public int compare(InstrumentoFinanciero instrumento1, InstrumentoFinanciero instrumento2) {
		return instrumento1.getCodigo().compareTo(instrumento2.getCodigo());
	}

	@Override
	public int compareByKey(String codigo, InstrumentoFinanciero elemento) {
		return codigo.compareTo(elemento.getCodigo());
	}

	@Override
	public void listar() {
		for (InstrumentoFinanciero insF : this) {
			System.out.println(insF.obtenerDatos());
		}
	}
}