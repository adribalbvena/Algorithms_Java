package ar.edu.ort.tp1.tp3.ej3;

public class Televisor extends Producto {
	private String dimension;
	private Tipo tipo;
	
	
	
	public Televisor(String marca, String modelo, String nroSerie, int voltaje, boolean estado, float precio, String dimension, Tipo tipo) {
		super(marca, modelo, nroSerie, voltaje, estado, precio);
		setDimension(dimension);
		setTipo(tipo);
	}

	private void setDimension(String dimension) {
		this.dimension = dimension;
	}

	private void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Televisor " +super.toString() + ", dimension=" + dimension + ", tipo=" + tipo + "]";
	}

	@Override
	public void imprimir() {
		System.out.println("Televisor " + tipo +" "+ super.getMarca() +" "+ dimension + " pulgadas," + "modelo "+ super.getModelo() +":$"+super.getPrecio());
		
	}
	
}
