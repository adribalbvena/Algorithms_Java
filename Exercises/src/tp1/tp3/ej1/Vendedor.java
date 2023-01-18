package ar.edu.ort.tp1.tp3.ej1;

public class Vendedor extends Subcontratado {
	private float porcentaje;


	public Vendedor(String nombre, int edad, float cantHoras, float precioHora, float porcentaje) {
		super(nombre, edad, cantHoras, precioHora);
		setPorcentaje(porcentaje);
	}


	private void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}


	@Override
	public String toString() {
		return "Vendedor [porcentaje=" + porcentaje + "]";
	}
	
	@Override
	public float calcularPago() {
		return super.calcularPago() + (super.calcularPago() * porcentaje) / 100;
	}
	
	
}
