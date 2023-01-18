package edu.ort.tp1.generics.caja;

public class Caja<T> {
	T contenido;

	public Caja() {
		contenido = null;
	}

	public boolean estaVacia() {
		return contenido == null;
	}

	public boolean estaLlena() {
		return contenido != null;
	}

	void guardar(T contenido) {
		if (contenido == null) {
			throw new RuntimeException("Debe agregarse un contenido");
		}
		if (estaLlena()) {
			throw new RuntimeException("La caja ya esta llena");
		}
		this.contenido = contenido;
	}

	T extraer() {
		if (estaVacia()) {
			throw new RuntimeException("La caja esta vacia");
		}
		return contenido;
	}
};