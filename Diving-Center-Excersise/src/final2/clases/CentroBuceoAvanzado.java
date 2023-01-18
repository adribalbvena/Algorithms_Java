package ar.edu.ort.tp1.final2.clases;

import edu.ort.tp1.u5.tda.Cola;
import edu.ort.tp1.u5.tda.ListaOrdenada;
import edu.ort.tp1.u5.tda.Pila;
import edu.ort.tp1.u5.tda.nodos.ColaNodos;
import edu.ort.tp1.u5.tda.nodos.PilaNodos;

public class CentroBuceoAvanzado {

	private static final String BUCEO_INVALIDO = "Buceo Invalido";
	private static final int CANTIDAD_BUCEOS = 10;

	// TODO A completar atribuos.
	private String nombre;
	private Pila<String> erroresDeReserva;
	private ListaOrdenada<Integer, Buceo> buceosDisponibles;
	private Cola<Buzo> buzosRegistrados;
	private int[][] cantidadBuceosPorMes;

	public CentroBuceoAvanzado(String nombre) {
		// TODO A completar
		this.nombre = nombre;
		this.erroresDeReserva = new PilaNodos<>();
		this.buzosRegistrados = new ColaNodos<>();
		buceosDisponibles = new ListaBuceosPorId();
		cantidadBuceosPorMes = new int[CANTIDAD_BUCEOS][Mes.values().length];
	}

	/**
	 * Se registra un buceo para un determinado buzo. si ocurre un error se registra
	 * en el log de errores, pero no se aborta la ejecucion.
	 * 
	 * -El buzo no puede ser nulo.
	 * 
	 * -El buceo cuyo id se indica, debe estar en la coleccion de buceos disponibles.
	 * 
	 * -El buzo debe estar habilitado para realizar el buceo seleccionado.
	 * 
	 * -De poder registrar al buzo, se debe agregar el buceo a su bitacora y
	 * agregarlo a los buzos registrados, que deben estar almacenados de forma
	 * cronologica.
	 * 
	 * @param buzo    Que desea bucear.
	 * @param idBuceo Identificador del buceo que el buzo quiere hacer.
	 */
	public void registrarBuceo(Buzo buzo, Integer idBuceo) {
		// TODO A completar
		if (buzo == null) {
			erroresDeReserva.push("Buzo nulo");
		} else {
			Buceo buceo = buscarBuceoPorID(idBuceo);
			if (buceo == null) {
				erroresDeReserva.push("Buceo no disponible.");
			} else if (!buzo.habilitado(buceo.getProfundidad())) {
				erroresDeReserva.push("Buzo no habilitado por profundidad.");
			} else {

				buzo.agregarABitacora(buceo);
				this.buzosRegistrados.add(buzo);
			}
		}
	}

	public void agregarBuceo(Buceo buceo, Mes mes) {
		this.buceosDisponibles.add(buceo);
		this.cantidadBuceosPorMes[buceo.getId() - 1][mes.ordinal()]++;
	}

	private Buceo buscarBuceoPorID(Integer idBuceo) {
		// TODO A completar por los alumnos
		return this.buceosDisponibles.search(idBuceo);
	}

	public void listarErroresCronologico() {
		System.out.println("Mostrando errores en forma cronologica");
		// TODO A completar
		Pila<String> aux = new PilaNodos<>();
		while (!this.erroresDeReserva.isEmpty()) {
			aux.push(this.erroresDeReserva.pop());
		}
		while (!aux.isEmpty()) {
			String error = aux.pop();
			System.out.println(error);
			this.erroresDeReserva.push(error);
		}
		System.out.println("------------------");
	}


	public void mostrarCantidadDeBuceosPorBuzoRegistrado() {
		// TODO A completar
		System.out.println("Cantidad de buceos realizados por los buzos registrados en " + this.nombre);
		Buzo c = null;
		this.buzosRegistrados.add(c);
		Buzo aux = this.buzosRegistrados.remove();
		while (aux != c) {
			System.out.printf("-- El buzo %s realizo %3d buceos segun su bitacora.\n", aux.toString(),
					aux.cantidadDeEventos());
			this.buzosRegistrados.add(aux);
			aux = this.buzosRegistrados.remove();
		}
	}

	public void mostrarCantidadDeReservasPorMes() {
		System.out.println("------------------");
		System.out.println("Cantidad de buceos por Mes");
		// TODO a hacer por los alumnos.
		for (int idxMes = 0; idxMes < Mes.values().length; idxMes++) {
			int cantBuceos = 0;
			for (int idxBuceo = 0; idxBuceo < buceosDisponibles.size() - 1; idxBuceo++) {
				cantBuceos += this.cantidadBuceosPorMes[idxBuceo][idxMes];
			}
			System.out.printf("El mes de %s tiene una cantidad de reservas de: %d\n", Mes.values()[idxMes].getNombre(),
					cantBuceos);
		}

	}
}
