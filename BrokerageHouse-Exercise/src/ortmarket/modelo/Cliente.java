package ar.edu.ort.tp1.ortmarket.modelo;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;

public class Cliente {
	private static final int DNI_MINIMO = 1000000;
	private static final String MSJ_DNI_INVALIDO = "DNI Invalido";
	private static final String MSJ_NOMBRE_INVALIDO = "Nombre Invalido";
	private static final String MSJ_APELLIDO_INVALIDO = "Apellido Invalido";
	private static final String MSJ_HISTORIAL = "Mostrando historial de: %s";
	private static final String MSJ_FONDEO_INICIAL = "Creacion de la cuenta con %.1f$ de saldo";

	private String nombre;
	private String apellido;
	private int dni;
	private double saldo;
	private PilaNodos<String> historial;

	public Cliente(String nombre, String apellido, int dni, double saldoInicial) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDni(dni);
		this.inicializarCuenta(saldoInicial);
	}

	private void setNombre(String nombre) {
		if (nombre == null || nombre.isEmpty()) {
			throw new RuntimeException(MSJ_NOMBRE_INVALIDO);
		}

		this.nombre = nombre;
	}

	private void setApellido(String apellido) {
		if (apellido == null || apellido.isEmpty()) {
			throw new RuntimeException(MSJ_APELLIDO_INVALIDO);
		}

		this.apellido = apellido;
	}

	private void setDni(int dni) {
		if (dni < DNI_MINIMO) {
			throw new RuntimeException(MSJ_DNI_INVALIDO);
		}

		this.dni = dni;
	}

	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	private void inicializarCuenta(double saldoInicial) {
		this.historial = new PilaNodos<String>();
		this.setSaldo(saldoInicial);
		this.agregarEntradaEnHistorial(String.format(MSJ_FONDEO_INICIAL, saldoInicial), TipoHistorial.FONDEO_INICIAL);
	}

	private void agregarEntradaEnHistorial(String mensaje, TipoHistorial tipo) {
		this.historial.push(mensaje + " Tipo: " + tipo + " Dni: " + dni + " Saldo: " + saldo);
	}

	public int getDni() {
		return dni;
	}

	public String getNombreCompleto() {
		return nombre + " " + apellido;
	}

	/**
	 * Se tiene que mostrar en pantalla el historia completo del Cliente. Ejemplo:
	 * ------------- Mostrando historial de: Mario Perez Creacion de la cuenta con
	 * 60000.0$ de saldo Tipo: FONDEO_INICIAL Dni: 6852741 Saldo: 60000.0 Se proceso
	 * la orden. Codigo: YPFD - BONO USD 2030 L.A.(Gobierno Nacional Argentino)
	 * Tipo: VENTA Dni: 6852741 Saldo: 61200.0 Se proceso la orden. Codigo: SE -
	 * Superfondo Equilibrado(Santander Rio) Tipo: COMPRA Dni: 6852741 Saldo:
	 * 60958.5510105
	 */
	public void imprimirHistorial() {
		PilaNodos<String> pilaAux = new PilaNodos<String>();
		String aux = null;

		System.out.println(String.format(MSJ_HISTORIAL, this.getNombreCompleto()));

		/* recorro la pila original guardando los elementos en la pila auxiliar */
		while (!this.historial.isEmpty()) {
			pilaAux.push(this.historial.pop());
		}

		/*
		 * recorro la pila auxiliar mostrando los elementos y apil�ndolos nuevamente en
		 * su orden original
		 */
		while (!pilaAux.isEmpty()) {
			aux = pilaAux.pop();
			System.out.println(aux);
			this.historial.push(aux);
		}
	}

	/**
	 * El cliente es responsable de procesar sus ordenes Si la orden es de compra
	 * tiene que restar a su saldo el precio de la Orden al Cliente, si es menor a 0
	 * se va a registrar en el historial un error de compra Si la orden es de venta
	 * se va a sumar el saldo el precio de la Orden al Cliente, si el saldo del
	 * cliente es menor que el precio de la orden se va a registrar un error de
	 * venta. En los dos casos si se realizo la operacion tambien tiene que
	 * registrarse en el historial
	 * 
	 * @param orden
	 */
	public void procesarOrden(Orden orden) {
		TipoHistorial resultado;

		if (orden.isCompra()) {
			resultado = this.procesarOrdenCompra(orden);
		} else {
			resultado = this.procesarOrdenVenta(orden);
		}

		this.agregarEntradaEnHistorial(orden.obtenerDatosParaHistorial(), resultado);
	}

	private TipoHistorial procesarOrdenCompra(Orden orden) {
		double precio = orden.obtenerPrecio();
		TipoHistorial resultado;

		if ((this.saldo - precio) < 0) {
			resultado = TipoHistorial.ERROR_EN_COMPRA;
		} else {
			this.saldo -= precio;
			resultado = TipoHistorial.COMPRA;
		}

		return resultado;
	}

	private TipoHistorial procesarOrdenVenta(Orden orden) {
		double precio = orden.obtenerPrecio();
		TipoHistorial resultado;

		if (precio > this.saldo) {
			resultado = TipoHistorial.ERROR_EN_VENTA;
		} else {
			this.saldo += precio;
			resultado = TipoHistorial.VENTA;
		}

		return resultado;
	}

}
