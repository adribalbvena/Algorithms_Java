package ar.edu.ort.tp1.examen.clases;

public abstract class Producto implements Mostrable {
	private static final String MSG_MARCA_INVALIDA = "La marca no puede ser nula ni vac�a";
	private static final String MSG_ID_INVALIDO = "El id no puede ser menor a 1";
	//TODO Completar
	private int id;
	private String marca;

	/**
	 * Constructor
	 * 
	 * @param id    debe ser mayor o igual a 1
	 * @param marca no ser nulo ni vac�o.
	 */
	public Producto(int id, String marca) {
		setId(id);
		setMarca(marca);
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		if(id < 1) {
			throw new RuntimeException(MSG_ID_INVALIDO);
		}
		
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	private void setMarca(String marca) {
		if(marca == null || marca.isEmpty()) {
			throw new RuntimeException(MSG_MARCA_INVALIDA);
		}
		this.marca = marca;
	}
	
	
}
