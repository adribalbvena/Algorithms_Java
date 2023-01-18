package ar.edu.ort.tp1.tp3.ej1;

public class Subcontratado extends Empleado{
	private float cantHoras;
	private float precioHora;
	
	public Subcontratado() {	
	}
	
	public Subcontratado(String nombre, int edad, float cantHoras, float precioHora) {
		super(nombre, edad);
		setCantHoras(cantHoras);
		setPrecioHora(precioHora);
		
	}

	private void setCantHoras(float cantHoras) {
		this.cantHoras = cantHoras;
	}

	private void setPrecioHora(float precioHora) {
		this.precioHora = precioHora;
	}

	@Override
	public String toString() {
		return "Subcontratado [cantHoras=" + cantHoras + ", precioHora=" + precioHora + "]";
	}
	
	@Override
	public float calcularPago() {
		return cantHoras * precioHora;
	}
	
	

}
