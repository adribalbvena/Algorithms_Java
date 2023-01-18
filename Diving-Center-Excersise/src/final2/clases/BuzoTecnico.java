package ar.edu.ort.tp1.final2.clases;

/**
 * Buzo con autorizacion para bajar mas alla de los 30 metros.
 *
 */
public class BuzoTecnico extends Buzo {

	public BuzoTecnico(String nombre, String nacionalidad, int edad) {
		//TODO A completar
		super(nombre, nacionalidad, edad);
	}

	@Override
	public boolean habilitadoBuceoProfundo() {
		//TODO A completar
		return true;
	}

	@Override
	public boolean habilitadoBuceoMedio() {
		//TODO A completar
		return true;
	}
	
	@Override
	public boolean habilitado(int metros) {
		//TODO A completar
		return true;
	}

}
