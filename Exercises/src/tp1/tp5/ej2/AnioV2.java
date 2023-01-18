package ar.edu.ort.tp1.tp5.ej2;

import ar.edu.ort.tp1.tp5.ej1.Meses;

public class AnioV2 {
	

	
int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public String getNombreDelMes(int numeroMes) {		
		return Meses.values()[numeroMes-1].name();
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
