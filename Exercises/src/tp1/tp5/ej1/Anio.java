package ar.edu.ort.tp1.tp5.ej1;

public class Anio {

	
	String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };
	int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public String getNombreDelMes(int numeroMes) {		
		return meses[numeroMes-1];
	}
	
	public int diasTranscurridos(int numeroMes) {
		int total;
		total = 0;
		
		
		for (int i = 0; i < numeroMes-1; i++) {
			total+= dias[i];
		}
		
		return total;
	}
}
