package ar.edu.ort.tp1.parcial2.clases;

import ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaOrdenadaProductosPorNombre extends ListaOrdenadaNodos<String, Producto>{

	@Override
	public int compare(Producto dato1, Producto dato2) {
		// TODO Auto-generated method stub
		return dato1.getNombre().compareToIgnoreCase(dato2.getNombre());
	}

	@Override
	public int compareByKey(String clave, Producto elemento) {
		// TODO Auto-generated method stub
		return clave.compareToIgnoreCase(elemento.getNombre());
	}

}
