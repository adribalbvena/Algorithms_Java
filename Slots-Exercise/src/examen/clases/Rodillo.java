package examen.clases;

public interface Rodillo<T> {
	void inicializar();
	void rodar();
	T obtenerActual();
}
