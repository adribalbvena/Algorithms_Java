package ar.edu.ort.tp1.tp2.ej1;

import java.util.ArrayList;

public class Hito {
	private String fecha;
	private String descripcion;
	private String personasInvolucradas;
	
	
	public Hito (String fecha, String descripcion, String personasInvolucradas) {
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.personasInvolucradas = personasInvolucradas;
	}
	
	public String getValor() {
		return "Fecha: "+this.fecha+" Decripcion: "+this.descripcion+" Personas Involucradas: "+this.personasInvolucradas;
	}
	
	
	//Parte "un mismo hito puede ser utilizado por diferentes personas" no quedo claro
	
	

}
