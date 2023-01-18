package ar.edu.ort.tp1.final2.clases;

import edu.ort.tp1.u5.tda.Cola;
import edu.ort.tp1.u5.tda.nodos.ColaNodos;

public abstract class Buzo implements BuceoProfundo, Bitacorado<Buceo> {

	private static final String NOMBRE_INVALIDO = "Nombre invalido";
	private static final String NACIONALIDAD_INVALIDA = "Nacionalidad invalida";
	private static final String EDAD_INVALIDA = "Un buzo no puede ser menor de edad";
	private String nombre;
	private String nacionalidad;
	private int edad;
	private Cola<Buceo> bitacora;

	/**
	 * Constructor del buzo, los buzos deben tener al menos de 18 años.
	 * 
	 * @param nombre - No puede estar vacio ni ser nulo.
	 * @param nacionalidad - No puede estar vacio ni ser nulo.
	 * @param edad debe ser valida.
	 */
	public Buzo(String nombre, String nacionalidad, int edad) {
		//TODO A completar
		setNombre(nombre);
		setNacionalidad(nacionalidad);
		setEdad(edad);
		this.bitacora = new ColaNodos<>();
	}

	private void setNombre(String nombre) {
		//TODO A completar
		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException(NOMBRE_INVALIDO);
		}
		this.nombre = nombre;
	}

	private void setNacionalidad(String nacionalidad) {
		//TODO A completar
		if (nacionalidad == null || nacionalidad.isEmpty()) {
			throw new IllegalArgumentException(NACIONALIDAD_INVALIDA);
		}
		this.nacionalidad = nacionalidad;

	}

	private void setEdad(int edad) {
		//TODO A completar
		if (edad < 18) {
			throw new IllegalArgumentException(EDAD_INVALIDA);
		}
		this.edad = edad;

	}

	public String getNombre() {
		return nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public String toString() {
		return "Buzo [nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", edad=" + edad + "]";
	}

	@Override
	public int cantidadDeEventos() {
		//TODO A completar
		Buceo c = null;
		int contador = 0;
		this.bitacora.add(c);
		Buceo aux = this.bitacora.remove();
		while (aux != c) {
			contador++;
			this.bitacora.add(aux);
			aux = this.bitacora.remove();
		}
		return contador;
	}

	public abstract boolean habilitado(int metros);

	@Override
	public void agregarABitacora(Buceo buceo) {
		//TODO A completar
		bitacora.add(buceo);
	}
}
