package ar.edu.ort.tp1.examen.clases;

import ar.edu.ort.tp1.tdas.interfaces.ListaOrdenada;

public class Deposito implements Depositante<Producto, Integer> {

	private static final String MSG_TIPO_PROD_INVALIDO = "Tipo de producto inv�lido";
	private static final String MSG_NO_PUDO_DEPOSITAR = "No se pudo depositar el producto.";
	private static final String MSG_PROF_INVALIDO = "Profundidad de estanter�a inv�lido";
	private static final int ALTO_ESTANTERIA = 3;
	private static final int ANCHO_ESTANTERIA = 4;
	private static final int PROFUNDIDAD_ESTANTERIA_MAX = 10;
	private static final int PROFUNDIDAD_ESTANTERIA_MIN = 2;
	private static final int FILA_PELOTA = 0;
	private static final int FILA_RAQUETA = 1;
	private static final int FILA_BOLSO = 2;
	Estante[][] estanteria;
	ListaOrdenadaProductos depositados;

	

	// TODO Completar

	// TODO Completar
	public Deposito(int profundidadEstanteria) {
		inicializarEstanteria(profundidadEstanteria);
		this.depositados = new ListaOrdenadaProductos();
		
	}
	
	private void inicializarEstanteria(int profundidadEstanteria) {
		//PRIMERO TIRAMOS EL ERROR POR SI NO DA LA PROFUNDIDAD
		if(profundidadEstanteria < PROFUNDIDAD_ESTANTERIA_MIN || profundidadEstanteria > PROFUNDIDAD_ESTANTERIA_MAX) {
			throw new RuntimeException(MSG_PROF_INVALIDO);
		}
		
		//INICIALIZAMOS EL ARRAY Q VA SER DE TIPO ESTANTE PARA Q PODAMOS GUARDAR EL ESTANTE NUEVO ADENTRO
		this.estanteria = new Estante[ALTO_ESTANTERIA][ANCHO_ESTANTERIA];
		for (int i=0; i < estanteria.length; i++) {
			for(int j=0; j < estanteria[i].length; j++) {
				estanteria[i][j] = new Estante(profundidadEstanteria);
			}
		}
		
	}

	@Override
	public void depositar(Producto elemento) {
		// TODO Auto-generated method stub
		int fila = calcularFila(elemento);
		int columna = 0;
		boolean depositado = false;
		
		do {
			try {
				estanteria[fila][columna].depositar(elemento); //deberá intentar almacenar el producto recibido en la primera ubicación de la fila que corresponda a su tipo, que tenga lugar
				depositado = true;
				depositados.add(elemento);
				
			} catch (RuntimeException re) {
				columna++; //SOLO SI HUBO UN ERROR INCREMENTO LA COLUMNA, EN ESTE CASO EL ERROR ES Q NO HAY MAS LUGAR
			}
			
		}while(!depositado && columna < estanteria[fila].length);		
		
		if (!depositado) {
			throw new RuntimeException(MSG_NO_PUDO_DEPOSITAR); //Si no hay lugar, deberá arrojarse una excepción indicando el problema.
		}		
	}
	
	private int calcularFila(Producto e) {
		int fila = 0;
		
		if (e instanceof Pelota) {
			fila = FILA_PELOTA;
		} else if (e instanceof Raqueta) {
			fila = FILA_RAQUETA;
		} else if (e instanceof Bolso) {
			fila = FILA_BOLSO;
		}
		
		
		return fila;
	}

	@Override
	public Producto retirarPorId(Integer id) {
		Producto prodRegistro = depositados.removeByKey(id);
		if(prodRegistro != null) {
			retirarDeEstante(prodRegistro);
		}
		
		return prodRegistro;
	}

	private void retirarDeEstante(Producto prodRegistro) {
		// TODO Auto-generated method stub
		int fila = calcularFila(prodRegistro);
		int columna = 0;
		boolean existe = false;
		
		while(columna < estanteria[fila].length && existe) { //aca abajo pasandole el prodRegistro.getId le estamos diciendo q saque el mismo producto q teniamos en la lista depositados
			if(estanteria[fila][columna].retirarPorId(prodRegistro.getId()) != null) {
				existe = true; //como es distinto a null significa q estaba en la pila en Estante
			}
			columna++;
		}	
	}

	/**
	 * Saca el producto de la estanter�a
	 * @param p
	 */


	public boolean productoDepositado(int unId) {
		// TODO Auto-generated method stub
		return depositados.exists(unId);
	}


	// TODO Completar
	/**
	 * Deposita el producto recibido en la estanter�a, en la fila que le corresponde
	 * seg�n su producto, en el el primer estante que tenga lugar.
	 */
	
	/**
	 * Indica si un producto se encuentra depositado
	 * @param idProducto
	 * @return
	 */

	/**
	 * Retira un producto en base a su ID
	 */

}
