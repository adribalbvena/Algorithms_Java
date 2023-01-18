package ar.edu.ort.tp1.examen.clases;

public class Pelota extends Producto {	
	private static final String LA_SUPERFICIE_NO_PUEDE_SER_NULA = "La superficie no puede ser nula";
	private static final String MSG_PELOTA = "La pelota para superficie %s es de la marca %s y tiene un id %d\n";
	private Superficie superficie;
	//TODO Completar
	public Pelota(int id, String marca, Superficie superficie) {
		super(id, marca);
		this.setSuperficie(superficie);
	}
	//TODO Completar
	private void setSuperficie(Superficie superficie) {
		if (superficie == null) {
			throw new RuntimeException(LA_SUPERFICIE_NO_PUEDE_SER_NULA);
		}
		this.superficie = superficie;
	}
	//TODO Completar
	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		System.out.printf(MSG_PELOTA, this.superficie, this.getMarca(), this.getId());
	}
	
	
}
