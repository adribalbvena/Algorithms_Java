package ar.edu.ort.tp1.tp3.ej1;

public class Test {

	public static void main(String[] args) {
		Asalariado asalariado;
		Subcontratado subcontratado;
		
		asalariado = new Asalariado("Jose", 30, 10000);
		subcontratado = new Subcontratado("Carlos", 23, 50, 100);
		
		mostrarDetalle(asalariado);
		mostrarDetalle(subcontratado);

	}
	
	static void mostrarDetalle(Empleado e) {
		System.out.println(e.getClass().getSimpleName() + " " + e.getNombre() + " gana: "+ e.calcularPago());
	}

}
