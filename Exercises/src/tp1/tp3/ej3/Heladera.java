package ar.edu.ort.tp1.tp3.ej3;

public class Heladera extends Producto{
	private float capacidad;
	private Tipo tipo;
	
	
	public Heladera(String marca, String modelo, String nroSerie, int voltaje, boolean estado, float precio, float capacidad, Tipo tipo) {
		super(marca, modelo, nroSerie, voltaje, estado, precio);
		setCapacidad(capacidad);
		setTipo(tipo);
	}


	private void setCapacidad(float capacidad) {
		this.capacidad = capacidad;
	}


	private void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "Heladera " + super.toString() + ", capacidad=" + capacidad + "litros , tipo=" + tipo + "]";
	}


	@Override
	public void imprimir() {
		System.out.println("Heladera "+super.getMarca()+ " ,modelo "+ super.getModelo()+ " ,"+tipo + " ,capacidad" + capacidad + " litros: $"+ super.getPrecio());
		
	}
	
	
	
	
	
}
