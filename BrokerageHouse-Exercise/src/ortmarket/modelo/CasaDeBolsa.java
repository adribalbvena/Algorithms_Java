package ar.edu.ort.tp1.ortmarket.modelo;

import java.util.ArrayList;

import ar.edu.ort.tp1.ortmarket.instrumentos.modelo.Bono;
import ar.edu.ort.tp1.ortmarket.instrumentos.modelo.FondoInversion;
import ar.edu.ort.tp1.ortmarket.instrumentos.modelo.InstrumentoFinanciero;
import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Cola;

public class CasaDeBolsa {
	private static final String MSJ_ERROR_CLIENTE = "El cliente %s no existe";
	private static final String MSJ_ERROR_INSTRUMENTO = "El instrumento %s no existe";
	private static final String MSJ_ERROR_CLIENTE_MAX = "No se pueden agregar más clientes";
	private static final String MSJ_NUEVO_CLIENTE = "Cliente agregado: %s";
	private static final String SEPARADOR = "-------------";
	private static final String MSJ_HISTORIAL_POR_CLIENTE = "-------------Imprimir Historial por Cliente-------------";
	private static final String MSJ_LISTA_INSTRUMENTOS = "-------------Lista de Instrumentos-------------";
	private static final int MAXIMO_CLIENTES = 10;

	private Cliente[] clientes;
	private ListaInstrumentosPorCodigo instrumentos;
	private ColaNodos<Orden> ordenesPendientes;

	public CasaDeBolsa() {
		this.inicializarInstrumentos();
		this.inicializarClientes();
		this.inicializarOrdenes();
	}

	private void inicializarClientes() {
		this.clientes = new Cliente[MAXIMO_CLIENTES];
	}

	private void inicializarOrdenes() {
		this.ordenesPendientes = new ColaNodos<Orden>();
	}

	/**
	 * Metodo para dar de alta a un Cliente en una posicion
	 * 
	 * @param nombre
	 * @param apellido
	 * @param dni
	 * @param saldoInicial
	 */
	public void altaCliente(int dni, String nombre, String apellido, int saldoInicial) {
		int posicionLibre;

		try {
			posicionLibre = this.buscarPosicionLibre();

			if (posicionLibre == MAXIMO_CLIENTES) {
				throw new RuntimeException(MSJ_ERROR_CLIENTE_MAX);
			}

			this.clientes[posicionLibre] = new Cliente(nombre, apellido, dni, saldoInicial);

			System.out.println(String.format(MSJ_NUEVO_CLIENTE, this.clientes[posicionLibre].getNombreCompleto()));
		} catch (RuntimeException exception) {
			System.out.println(exception.getMessage());
		}
	}

	private int buscarPosicionLibre() {
		int pos = 0;
		while (pos < MAXIMO_CLIENTES && clientes[pos] != null) {
			pos++;
		}
		return pos;
	}

	private int buscarPosCliente(int dni) {
		int pos = 0;
		while (pos < MAXIMO_CLIENTES && (clientes[pos] == null || clientes[pos].getDni() != dni)) {
			pos++;
		}
		return pos;
	}

	/**
	 * Permite cargar ordenes pendientes que luego van a ser procesadas, se debe
	 * validar que el instrumento financiero exista al igual que el cliente
	 * 
	 * @param cantidad
	 * @param codigoInstrumento
	 * @param dniCliente
	 * @param esVenta
	 * @throws Exception
	 */
	public void cargarOrden(int cantidad, String codigoInstrumento, int dniCliente, boolean esVenta)
			throws RuntimeException {
		InstrumentoFinanciero instrumento;
		int posCliente;

		instrumento = this.instrumentos.search(codigoInstrumento);

		if (instrumento == null) {
			throw new RuntimeException(String.format(MSJ_ERROR_INSTRUMENTO, codigoInstrumento));
		}

		posCliente = this.buscarPosCliente(dniCliente);

		if (posCliente == MAXIMO_CLIENTES) {
			throw new RuntimeException(String.format(MSJ_ERROR_CLIENTE, dniCliente));
		}

		this.ordenesPendientes.add(new Orden(cantidad, instrumento, this.clientes[posCliente], esVenta));
	}

	public void imprimirHistorialDelCliente() {
		System.out.println(MSJ_HISTORIAL_POR_CLIENTE);

		for (Cliente cliente : clientes) {
			if (cliente != null) {
				System.out.println(SEPARADOR);
				cliente.imprimirHistorial();
				System.out.println(SEPARADOR);
			}
		}
	}

	public void imprimirListaPrecios() {
		System.out.println(MSJ_LISTA_INSTRUMENTOS);
		instrumentos.listar();
	}

	private void inicializarInstrumentos() {
		this.instrumentos = new ListaInstrumentosPorCodigo();

		// Metodo creado solo como caso de prueba.
		ArrayList<InstrumentoFinanciero> listaInstrumentos = new ArrayList<>();
		listaInstrumentos.add(new Bono("AL30", "BONO USD 2030 L.A.", "Gobierno Nacional Argentino", 0.75, 160000));
		listaInstrumentos.add(
				new Bono("GD30", "BONOS GLOBALES DE LA REP. ARG. 2030", "Gobierno Nacional Argentino", 0.063, 8965555));
		listaInstrumentos.add(new Bono("YPFD", "BONO USD 2030 L.A.", "Gobierno Nacional Argentino", 0.75, 160000));

		FondoInversion fi = new FondoInversion("SE", "Superfondo Equilibrado", "Banco Deplaza", 10000);

		for (InstrumentoFinanciero instrumentoFinanciero : listaInstrumentos) {
			instrumentos.add(instrumentoFinanciero);
			fi.agregarInstrumento(instrumentoFinanciero);
		}
		instrumentos.add(fi);
	}

	/**
	 * Metodo que tiene que procesar todas las ordenes pendiente de la Casa de Bolsa
	 */
	public void procesarOrdenesDeClientes() {
		Orden orden = null;

		/* recorro la cola hasta dejarla vacía, procesando cada orden */
		while (!this.ordenesPendientes.isEmpty()) {
			orden = this.ordenesPendientes.remove();
			orden.getCliente().procesarOrden(orden);
		}
	}
}
