package ar.edu.ort.tp1.tp3.ej1;

public abstract class Empleado {
	private String nombre;
	private int edad;
	
	public Empleado () {
		
	}
	
	public Empleado (String nombre, int edad) {
		super();
		setNombre(nombre);
		setEdad(edad);	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return " [Nombre=" + nombre + ", Edad=" + edad + "]";
	}
		
	public abstract float calcularPago();
	
}


