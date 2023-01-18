package ar.edu.ort.tp1.final2.clases;

/**
 * Buzo con autorizacion para bajar hasta los 30 metros inclusive. nunca puede realizar buceos mas profundos
 *
 */
public class BuzoAdvancedOpenWater extends Buzo {

	private static final int PROFUNDIDAD_MAXIMA_PERMITIDA = 30;

	public BuzoAdvancedOpenWater(String nombre, String nacionalidad, int edad) {
		//TODO A completar
		super(nombre, nacionalidad, edad);
	}

	@Override
	public boolean habilitadoBuceoProfundo() {
		//TODO A completar
		return false;
	}

	@Override
	public boolean habilitadoBuceoMedio() {
		//TODO A completar
		return true;
	}

	@Override
	public boolean habilitado(int metros) {
		//TODO A completar
		return metros <= PROFUNDIDAD_MAXIMA_PERMITIDA;
	}

}
