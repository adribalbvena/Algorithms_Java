package examen.clases;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Pila;

public class Paquete implements Envase<Galletita>{
	private Pila<Galletita> paquete;
	private int maxUnidades;
	private int cantActual;
	
	public Paquete(int cantUnidades) {
		this.paquete = new PilaNodos<>();
		this.maxUnidades = cantUnidades;
		this.cantActual = 0;
	}

	@Override
	public void agregar(Galletita unidad) {
		// TODO Auto-generated method stub
		int cantActual = 0;
		if (cantActual < maxUnidades) {
			paquete.push(unidad);
			cantActual++;
		}
		
	}

	@Override
	public Galletita extraer() {
		// TODO Auto-generated method stub
		return paquete.pop();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return cantActual == 0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return cantActual == maxUnidades;
	}



}
