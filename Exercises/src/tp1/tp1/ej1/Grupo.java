package ar.edu.ort.tp1.tp1.ej1;

import java.util.ArrayList;

public class Grupo {
	private String nombre;
	private ArrayList<String> integrantes;
	
	
	public Grupo(String nombre) {
		setNombre(nombre);
		this.integrantes = new ArrayList<String>();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCantidadIntegrantes() {
		return integrantes.size();
	}
	
	
	private boolean existeIntegrante(String nombre) {
		return buscarIntegrante(nombre)!=null;
	}
	
	public void agregarIntegrante(String nombre) {
		if (existeIntegrante(nombre)) {
			integrantes.add(nombre);
		}
	}
	
	public String buscarIntegrante(String nombre) {
		int i;
		String integranteEncontrado;
		
		i = 0;
		integranteEncontrado = null;
		
		while (i < integrantes.size() && integranteEncontrado == null) {
			String miIntegrante = integrantes.get(i);
			if (miIntegrante.equals(nombre)) {
				integranteEncontrado = miIntegrante;
			}
			i++;
		}
		
		return integranteEncontrado;
	}
	
	private int obtenerPosicionIntegrante(String nombre) {
		return this.integrantes.indexOf(nombre);
	}
	
	public String obtenerIntegrante(int posicion) {
		String miIntegrante;
		miIntegrante = null;
		
		if (posicion >= 1) {
			miIntegrante = integrantes.get(posicion-1);
		}		
		
		return miIntegrante;		
	}
	
	public String removerIntegrante(String nombre) {
		String miIntegrante;
		miIntegrante = null;
		
		
		if (existeIntegrante(nombre)) {
			miIntegrante = integrantes.remove(obtenerPosicionIntegrante(nombre));
		}
		
		return miIntegrante;
	}
	
	private void mostrarIntegrantes() {
		System.out.println("Cantidad:"+ getCantidadIntegrantes());
		for (String integrante : integrantes ) {
			System.out.println(integrante);
		}
	}
	
	public void mostrar() {
		System.out.println("Nombre del grupo: "+ this.nombre);
		mostrarIntegrantes();
	}
	
	public void vaciar() {
		integrantes.clear();
	}
	
	
}
