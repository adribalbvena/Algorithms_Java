package examen.clases;

import java.util.ArrayList;

public class Bolsa implements Envase<Galletita>{
	private int maxGramos;
	private int gramosActuales;
	private ArrayList<Galletita> bolsa;
	
	public Bolsa(int cantGramos) {
		this.bolsa = new ArrayList<>();
		this.maxGramos = cantGramos;
		this.gramosActuales = 0;
	}

	@Override
	public void agregar(Galletita unidad) {
		// TODO Auto-generated method stub
		if (gramosActuales < maxGramos) {
			bolsa.add(unidad);
			gramosActuales += unidad.getGramos();
		}	
		
	}

	@Override
	public Galletita extraer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.gramosActuales == 0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return gramosActuales == maxGramos;
	}



}
