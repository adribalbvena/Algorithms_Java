package examen.clases;

public interface Envase<TipoUnidad> {
	void agregar(TipoUnidad unidad);
	public TipoUnidad extraer();
	boolean isEmpty();
	boolean isFull();
}
