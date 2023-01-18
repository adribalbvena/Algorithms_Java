package examen.clases;

import ar.edu.ort.tp1.tdas.interfaces.ListaOrdenada;

public class InformePorPaquetes implements Listable{
	private ListaOrdenada<Integer, Resumen> listaOrdenadaResumen;
	
	public InformePorPaquetes() {
		this.listaOrdenadaResumen = new ListaOrdenadaResumen();
	}
	
	public void agregarResumen(Resumen resumen) {
		listaOrdenadaResumen.add(resumen);
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		for(Resumen r : listaOrdenadaResumen)
		System.out.println(r.toString());
		
	}

}
