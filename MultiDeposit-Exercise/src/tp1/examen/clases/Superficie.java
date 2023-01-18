package ar.edu.ort.tp1.examen.clases;

public enum Superficie {
	POLVO_LADRILLO("Polvo de ladrillo"), CESPED("Cesped"), RAPIDA("Rápida");

	private String descripcion;

	private Superficie(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	
}
