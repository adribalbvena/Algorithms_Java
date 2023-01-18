package ar.edu.ort.tp1.examen.clases;

public class Bolso extends Producto {
	private static final String MODELO_DE_BOLSO_INVALIDO = "Modelo de bolso inv�lido.";
	private static final String MSG_MODELO = 
			"El bolso es de modelo %s es de la marca %s y tiene un id %d\n";

	//TODO Completar
	private String modelo;

	//TODO Completar
	public Bolso(int id, String marca, String modelo) {
		super(id, marca);
		this.setModelo(modelo);
	}

	//TODO Completar
	private void setModelo(String modelo) {
		if (modelo == null || modelo.isEmpty()) {
			throw new RuntimeException(MODELO_DE_BOLSO_INVALIDO);
		}
		this.modelo = modelo;
	}

	//TODO Completar
	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.printf(MSG_MODELO, this.modelo, this.getMarca(), this.getId());
	}
}
