package ar.edu.ort.tp1.parcial2.clases;

import ort.tp1.tdas.implementaciones.PilaNodos;
import ort.tp1.tdas.interfaces.Pila;

public class Producto implements Apreciable, Identificable<Integer> {

	private static final String MSJ_AJUSTE_INVALIDO = "Actualizacion Invalido";
	private final static String MSJ_PRECIO_INVALIDO = "Precio Invalido";
	private final static String MSJ_NOMBRE_INVALIDO = "Nombre Invalido";
	private static final String MSJ_ID_INVALIDO = "ID Invalido";

	private Integer id;
	private String nombre;

	private Pila<HistoricoActualizacion> historicoActualizaciones;

	public Producto(Integer id, double precioInicial, String nombre) {
		// TODO
		setId(id);
		setNombre(nombre);
		this.historicoActualizaciones = new PilaNodos<>();
		//this.historicoActualizaciones.push(new HistoricoActualizacion(new ActualizacionDirecta(precioInicial), 0.0, precioInicial));
		aplicarActualizacion(new ActualizacionDirecta(precioInicial));
	}
	
	

	private void setNombre(String nombre) {
		if (nombre.isEmpty() || nombre == null) {
			throw new RuntimeException(MSJ_NOMBRE_INVALIDO);
		}
		
		this.nombre = nombre;
	}
	
	private void setId(Integer id) {
		if(mismoId(id)) {
			throw new RuntimeException(MSJ_ID_INVALIDO);
		}
		this.id = id;
	}



	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public boolean mismoId(Integer otroId) {
		return otroId.equals(id);
	}
	
	public String getNombre() {
		return nombre;
	}

	public double obtenerPrecio() {
		double ultimoPrecio = 0;
		if (!historicoActualizaciones.isEmpty()) {
			ultimoPrecio = historicoActualizaciones.peek().getPrecio();
		}
		return ultimoPrecio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", precio=" + obtenerPrecio() + ", nombre=" + nombre + "]";
	}

	@Override
	public void aplicarActualizacion(Actualizacion actualizacion) throws RuntimeException {
		if (actualizacion == null) {
			throw new RuntimeException(MSJ_AJUSTE_INVALIDO);
		}
		double precio = obtenerPrecio();
		double nuevoPrecio = 0;
		// TODO Calcular el nuevo precio
		if (actualizacion instanceof ActualizacionDirecta) {
			nuevoPrecio = ((ActualizacionDirecta) actualizacion).obtenerValorCalculado();
		} else if (actualizacion instanceof ActualizacionExtendida) {
			nuevoPrecio = ((ActualizacionExtendida) actualizacion).obtenerValorCalculado(precio);
		} else if (actualizacion instanceof ActualizacionPorcentual) {
			nuevoPrecio = ((ActualizacionPorcentual) actualizacion).obtenerValorCalculado(precio);
		} else if (actualizacion instanceof ActualizacionPorMonto) {
			nuevoPrecio = ((ActualizacionPorMonto) actualizacion).obtenerValorCalculado(precio);
		}
		
		if (nuevoPrecio < 0) {
			throw new RuntimeException(MSJ_PRECIO_INVALIDO);
		}
		
		this.historicoActualizaciones.push(new HistoricoActualizacion(actualizacion, precio, nuevoPrecio));
	}

	public void listarActualizacionesDePrecio() {
		// TODO
		Pila<HistoricoActualizacion> pilaAux = new PilaNodos<>();
		HistoricoActualizacion elementoPila;
		
		while(!historicoActualizaciones.isEmpty()) {
			elementoPila = historicoActualizaciones.pop();
			System.out.println(elementoPila.toString());
			pilaAux.push(elementoPila);
		}
		
		while(!pilaAux.isEmpty()) {
			historicoActualizaciones.push(pilaAux.pop());
		}
	}
}