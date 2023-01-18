package examen.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaOrdenadaResumen extends ListaOrdenadaNodos<Integer, Resumen>{

	@Override
	public int compare(Resumen dato1, Resumen dato2) {
		// TODO Auto-generated method stub
		return dato2.getTanda()-dato1.getTanda();
	}

	@Override
	public int compareByKey(Integer clave, Resumen elemento) {
		// TODO Auto-generated method stub
		return clave-elemento.getTanda();
	}

}
