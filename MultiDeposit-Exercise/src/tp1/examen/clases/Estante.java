package ar.edu.ort.tp1.examen.clases;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Pila;

public class Estante implements Depositante<Producto, Integer> {
	private int profundidadEstanteria;
	private Pila<Producto> productos;
	private int cantProductos;
	//TODO Completar

	public Estante(int profundidadEstanteria) {
		this.cantProductos = 0;
		this.profundidadEstanteria = profundidadEstanteria;
		this.productos = new PilaNodos<>();
		
	}
	



	@Override
	public void depositar(Producto elemento) {
		// TODO Auto-generated method stub
		if (profundidadEstanteria == cantProductos) {
			throw new RuntimeException("No hay mas lugar en el estante.");
		}
		
		productos.push(elemento);
		cantProductos++;
		
	}

	@Override
	public Producto retirarPorId(Integer id) {
		// TODO Auto-generated method stub
		Pila<Producto> aux = new PilaNodos<>();
		Producto encontrado = null;
		Producto prod;
		
		while(encontrado == null && !productos.isEmpty()) {
			prod = productos.pop();
			if (prod.getId() == id) {
				encontrado = prod;
			} else {
				aux.push(prod); //SOLO SI NO COINCIDE VOLVEMOS A AGREGAR, SINO NO SE VUELVE AGREGAR XQ EL OBJETIVO ES REMOVER.
			}
			
		}
		
		while(!aux.isEmpty()) {
			productos.push(aux.pop());
		}
		
		return encontrado;
	}

	/**
	 * Agrega un elemento al estante siempre y cuando haya lugar, sino, deber� emitir la excepci�n que corresponda..
	 */

	/**
	 * Retira el producto de la estanter�a por su id
	 */

}
