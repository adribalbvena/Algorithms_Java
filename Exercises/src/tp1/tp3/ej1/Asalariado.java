package ar.edu.ort.tp1.tp3.ej1;

public class Asalariado extends Empleado {
	private float sueldo;
	
	public Asalariado () {
	}
	
	public Asalariado (String nombre, int edad, float sueldo) {
		super(nombre, edad);
		setSueldo(sueldo);
	}

	public float getSueldo() {
		return sueldo;
	}

	private void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Asalariado [sueldo=" + sueldo + "]";
	}
	
	
	@Override
	public float calcularPago() {
		return sueldo;
	}
	
}

