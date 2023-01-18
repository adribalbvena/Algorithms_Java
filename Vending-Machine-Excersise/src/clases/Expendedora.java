package ar.edu.ort.tp1.parcial2.clases;

import ort.tp1.tdas.implementaciones.ColaNodos;
import ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;
import ort.tp1.tdas.interfaces.Cola;
import ort.tp1.tdas.interfaces.ListaOrdenada;

public class Expendedora {

	private final static String MSJ_NOMBRE_INVALIDO = "Nombre Invalido";
	private final static String MSJ_ID_INVALIDO = "ID de producto Invalido";
	private static final String MSJ_ACTUALIZACION_NULA = "La actualizacion no puede ser nula";
	private static final String MSJ_PRODUCTO_NULO = "El producto no puede ser nulo";
	private static final String MSJ_PRODUCTO_REPETIDO = "ID de producto ya existente";
	// TODO Completar estructuras faltantes
	private ListaOrdenada<Integer, Producto> productosPorId;
	private ListaOrdenada<String, Producto> productosPorNombre;
	private Cola<String> erroresDeActualizacion;
	private String nombre;

	public Expendedora(String nombre) {
		// TODO
		this.nombre = nombre;
		this.productosPorId = new ListaOrdenadaProductosPorId();
		this.productosPorNombre = new ListaOrdenadaProductosPorNombre();
		this.erroresDeActualizacion = new ColaNodos<>();
	}

	public void agregarProducto(Producto p) {
		// TODO
		if (p == null) {
			throw new RuntimeException(MSJ_PRODUCTO_NULO);
		} else if (p.getNombre().isEmpty() || p.getNombre() == null) {
			throw new RuntimeException(MSJ_NOMBRE_INVALIDO);
		} else if (productosPorId.exists(p.getId())) {
			throw new RuntimeException(MSJ_PRODUCTO_REPETIDO);
		} else if (p.getId() == null) {
			throw new RuntimeException(MSJ_ID_INVALIDO);
		}
		
		productosPorId.add(p);
		productosPorNombre.add(p);
	}

	public void ajustarPrecio(int idProducto, Actualizacion actualizacion) {
		Producto producto = obtenerProductoPorId(idProducto);
		if (producto == null) {
			agregarError(MSJ_ID_INVALIDO, idProducto, actualizacion);
		} else if (actualizacion == null) {
			agregarError(MSJ_ACTUALIZACION_NULA, idProducto, actualizacion);
		} else {
			try {
				producto.aplicarActualizacion(actualizacion);
			} catch (RuntimeException re) {
				agregarError(re.getMessage(), idProducto, actualizacion);
			}
		}
	}
	
	private Producto obtenerProductoPorId(int idProducto) {
		Producto producto = null;
		// TODO Completar
		producto = productosPorId.search(idProducto);
		return producto;
	}

	private void agregarError(String mensaje, int idProducto, Actualizacion actualizacion) {
		erroresDeActualizacion.add(String.format("%s - %s - %s", mensaje, idProducto, actualizacion));
	}

	public void mostrarHistoricoActualizaciones() {
		// TODO Si te toco este tema
		System.out.println("Resumen actualizacion de precio de la maquina: " + this.nombre);
		System.out.println("Se muestra cada producto.");
		for(Producto p : productosPorId) {
			System.out.println("Mostrando actualizaciones de: "+p.toString());
			p.listarActualizacionesDePrecio();
			System.out.println("---------");
		}
		
	}

	public void mostrarErrores() {
		// TODO Si te toco este tema
		String centinela = null;
		String elementoCola;
		
		System.out.println("Errores de actualizacion de precio de la maquina: "+this.nombre);
		
		erroresDeActualizacion.add(centinela);
		elementoCola = erroresDeActualizacion.remove();
		while(elementoCola != centinela) {
			System.out.println(elementoCola.toString());
			erroresDeActualizacion.add(elementoCola);
			elementoCola = erroresDeActualizacion.remove();
		}
		
	}

	// Solo si te toco la lista por nombre
//	public void listarProductosPorNombre() {
//		productosPorNombre.listar();
//	}

	// Solo si te toco la lista por ID
//	public void listarProductosPorId() {
//		productosPorID.listar();
//	}

}
